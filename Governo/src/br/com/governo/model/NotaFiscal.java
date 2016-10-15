package br.com.governo.model;

import java.io.Serializable;

public class NotaFiscal implements Serializable {
	
	private String cpfEmissor;
	private String cnpjEmissor;
	private String cpfReceptor;
	private String cnpjReceptor;
	private Double valorTotal;
	public String getCpfEmissor() {
		return cpfEmissor;
	}
	public void setCpfEmissor(String cpfEmissor) {
		this.cpfEmissor = cpfEmissor;
	}
	public String getCnpjEmissor() {
		return cnpjEmissor;
	}
	public void setCnpjEmissor(String cnpjEmissor) {
		this.cnpjEmissor = cnpjEmissor;
	}
	public String getCpfReceptor() {
		return cpfReceptor;
	}
	public void setCpfReceptor(String cpfReceptor) {
		this.cpfReceptor = cpfReceptor;
	}
	public String getCnpjReceptor() {
		return cnpjReceptor;
	}
	public void setCnpjReceptor(String cnpjReceptor) {
		this.cnpjReceptor = cnpjReceptor;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
