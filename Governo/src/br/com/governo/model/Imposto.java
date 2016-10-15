package br.com.governo.model;

import java.io.Serializable;

public class Imposto implements Serializable {
	
	private String sigla;
	private Double aliquota;
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Double getAliquota() {
		return aliquota;
	}
	public void setAliquota(Double aliquota) {
		this.aliquota = aliquota;
	}
	public Imposto() {
	}
	public Imposto(String sigla, Double aliquota) {
		super();
		this.sigla = sigla;
		this.aliquota = aliquota;
	}

}