package br.com.governo.ws;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import br.com.governo.business.ImpostoService;
import br.com.governo.business.NotaFiscalService;
import br.com.governo.business.UsuarioService;
import br.com.governo.model.Imposto;
import br.com.governo.model.NotaFiscal;
import br.com.governo.model.Usuario;

@WebService
public class WebServiceNF {

	@Resource
	WebServiceContext ctx;
	@EJB
	private UsuarioService usuarioService;
	@EJB
	private ImpostoService impostoService;
	@EJB
	private NotaFiscalService notaFiscalService;

	
	private String cpfOuCnpjEmissor = null;
	
	@WebMethod
	public List<Imposto> listarImpostos() throws Exception {
		if (autenticado()) {
			return impostoService.listarImpostos();
		} else {
			throw new Exception("Usuário não autorizado");
		}
	}

	@WebMethod(exclude=true)
	private boolean autenticado() {
		MessageContext mc = ctx.getMessageContext();
		Map httpHeaders = (Map) mc.get(MessageContext.HTTP_REQUEST_HEADERS);
		List cpfs = (List) httpHeaders.get("cpf");
		List cnpjs = (List) httpHeaders.get("cnpj");
		List senhas = (List) httpHeaders.get("password");

		String usuario = "";
		String senha = "";

		if (cpfs != null) {
			usuario = cpfs.get(0).toString();
		} else if (cnpjs != null) {
			usuario = cnpjs.get(0).toString();
		}

		if (senhas != null) {
			senha = senhas.get(0).toString();
		}

		if (usuario != null && senha != null) {
			Usuario user = usuarioService.recuperarUsuario(usuario);
			if (user != null) {
				if (user.getSenha().equals(senha)) {
					this.cpfOuCnpjEmissor = user.getCnpj() != null ? user.getCnpj() : user.getCpf();
					return true;
				} 
			} 
		}
		return false;
	}
	
	@WebMethod
	public List<NotaFiscal> listarNotasFiscais(@WebParam(name="cpfOuCnpj")String cpfOuCnpj) throws Exception {
		if (autenticado()){
			return notaFiscalService.recuperarNotasFiscais(cpfOuCnpj);
		} else {
			throw new Exception("Usuário não autorizado");
		}
	}
	
	@WebMethod
	public NotaFiscal emitirNotaFiscal (@WebParam(name="cpfOuCnpjDestinatario")String cpfOuCnpjDestinatario, @WebParam(name="valorTotalProdutos")Double valorTotalProdutos) throws Exception {
		if (autenticado()) {
			NotaFiscal nf = notaFiscalService.emitirNotaFiscal(cpfOuCnpjEmissor, cpfOuCnpjDestinatario, valorTotalProdutos);
			if (nf != null) {
				return nf;
			} else {
				throw new Exception("Erro ao emitir a nota. Saldo insuficiente para cobrança dos impostos!");
			}
		} else {
			throw new Exception("Usuário não autorizado");
		}
	}
}
