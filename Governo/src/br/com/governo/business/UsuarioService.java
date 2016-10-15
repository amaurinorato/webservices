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
		usuarios.put("99334696494", new Usuario("99334696494", null, "123"));
		usuarios.put("67341083689", new Usuario("67341083689", null, "123"));
		usuarios.put("22532243000103", new Usuario(null, "22532243000103", "123"));
		usuarios.put("03169483000140", new Usuario(null, "03169483000140", "123"));
		usuarios.put("92252235000199", new Usuario(null, "92252235000199", "123"));
	}
	
	public Usuario recuperarUsuario(String cpfOuCnpj) {
		return usuarios.get(cpfOuCnpj);
	}
	
}
