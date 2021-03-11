package br.com.fiap.b2w.model;

public class Funcionario {
	private int rm;
	private String nome;
	private String cpf;
	private String email;
	
	public Funcionario(String nome, String cpf, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public int getRm() {
		return rm;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
