package br.com.governo.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import br.com.fiap.endpoint.EndpointFinanceiro;
import br.com.fiap.endpoint.EndpointFinanceiroService;
import br.com.fiap.endpoint.Exception_Exception;
import br.com.governo.model.NotaFiscal;

@Stateful
public class NotaFiscalService {
	
	private static Map<String, List<NotaFiscal>> notasFiscais = new HashMap<String, List<NotaFiscal>>();
	@EJB
	private ImpostoService impostoService;
	
	public List<NotaFiscal> recuperarNotasFiscais(String cpfOuCnpj) {
		return notasFiscais.get(cpfOuCnpj);
	}
	
	public NotaFiscal emitirNotaFiscal(String cpfOuCnpjEmissor, String cpfOuCnpjDestinatario, Double valorTotalProdutos) throws Exception_Exception {
		//TODO Tentar debitar valor
		NotaFiscal nf = new NotaFiscal();
		if (cpfOuCnpjEmissor.length() == 11) {
			nf.setCpfEmissor(cpfOuCnpjEmissor);
		} else {
			nf.setCnpjEmissor(cpfOuCnpjEmissor);
		}
		if (cpfOuCnpjDestinatario.length() == 11) {
			nf.setCpfReceptor(cpfOuCnpjDestinatario);
		} else {
			nf.setCnpjReceptor(cpfOuCnpjDestinatario);
		}
		Double valorImposto = impostoService.calcularImposto(valorTotalProdutos);
		nf.setValorTotal(valorTotalProdutos + valorImposto);
		EndpointFinanceiroService service = new EndpointFinanceiroService();
		EndpointFinanceiro port = service.getEndpointFinanceiroPort();
		boolean cobrado = port.cobrar(cpfOuCnpjEmissor, valorImposto);
		
		return cobrado ? nf : null;
	}
	
	

}
