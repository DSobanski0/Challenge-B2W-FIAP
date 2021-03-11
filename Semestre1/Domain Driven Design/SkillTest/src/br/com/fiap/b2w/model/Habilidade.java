package br.com.fiap.b2w.model;

public class Habilidade {
	private String nome;
	private int peso;
	private double nota;
	
	public Habilidade(String nome, int peso) {
		super();
		this.nome = nome;
		if(peso > 5 || peso < 1) {
			System.err.println("Escolha um peso de 1 a 5");
		}
		this.peso = peso;
		this.nota = 0.0;
	}

	public String getNome() {
		return nome;
	}

	public int getPeso() {
		return peso;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
