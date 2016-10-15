package br.com.governo.business;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateful;

import br.com.governo.model.Usuario;

@Stateful
public class UsuarioService {
	
	private static Map<String, Usuario> usuarios = new HashMap<String, Usuario>();
	
	static {
		usuarios.put("12345678901", new Usuario("12345678901", null, "123"));
	}
	
	public Usuario recuperarUsuario(String cpfOuCnpj) {
		return usuarios.get(cpfOuCnpj);
	}
	
}
