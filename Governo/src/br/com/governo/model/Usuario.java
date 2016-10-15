package br.com.governo.model;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private String cpf;
	private String cnpj;
	private String senha;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario(String cpf, String cnpj, String senha) {
		super();
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.senha = senha;
	}
	public Usuario() {
	}
}
