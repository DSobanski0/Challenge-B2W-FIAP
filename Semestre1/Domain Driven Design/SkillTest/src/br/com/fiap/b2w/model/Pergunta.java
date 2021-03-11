package br.com.fiap.b2w.model;

public class Pergunta {
	private String pergunta;
	private int peso;
	private double nota;
	
	public Pergunta(String pergunta, int peso) {
		super();
		this.pergunta = pergunta;
		if(peso > 5 || peso < 1) {
			System.err.println("Escolha um peso de 1 a 5");
		}
		this.peso = peso;
		this.nota = 0.0;
	}

	public String getPergunta() {
		return pergunta;
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
