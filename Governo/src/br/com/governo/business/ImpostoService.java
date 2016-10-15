package br.com.governo.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import br.com.governo.model.Imposto;

@Stateful
public class ImpostoService {
	
	private static List<Imposto> impostos = new ArrayList<Imposto>();
	
	static {
		impostos.add(new Imposto("ISS", 0.2));
		impostos.add(new Imposto("ICMS", 0.7));
		impostos.add(new Imposto("IPI", 0.5));
	}
	
	public List<Imposto> listarImpostos() {
		return impostos;
	}
	
	public void cadastrarImposto(Imposto imposto) {
		impostos.add(imposto);
	}
	
	public Double calcularImposto(Double valorProdutos) {
		Double valorImpostos = 0d;
		for (Imposto imposto : impostos) {
			valorImpostos += imposto.getAliquota() * valorProdutos; 
		}
		return valorImpostos;
	}
}
