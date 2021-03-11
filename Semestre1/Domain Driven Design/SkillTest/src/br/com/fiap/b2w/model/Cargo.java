package br.com.fiap.b2w.model;

public class Cargo {
	private int codigo;
	private String nome;
	private Funcionario funcionario;
	private Habilidade[] habilidades;
	private int totalHabilidades;
	private Pergunta[] perguntas;
	private int totalPerguntas;
	
	public Cargo(String nome) {
		super();
		this.nome = nome;
	}
	
	public Cargo(String nome, Funcionario funcionario, int quantidadeHabilidades, int quantidadePerguntas) {
		this(nome);
		this.funcionario = funcionario;
		this.habilidades = new Habilidade[quantidadeHabilidades];
		this.perguntas = new Pergunta[quantidadePerguntas];
		this.totalHabilidades = -1;
		this.totalPerguntas = -1;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Habilidade[] getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Habilidade[] habilidades) {
		this.habilidades = habilidades;
	}

	public int getTotalHabilidades() {
		return totalHabilidades + 1;
	}

	public Pergunta[] getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(Pergunta[] perguntas) {
		this.perguntas = perguntas;
	}
	
	public int getTotalPerguntas() {
		return totalPerguntas + 1;
	}

	public void adicionaHabilidade(Habilidade habilidade) {
		this.totalHabilidades++;
		this.habilidades[this.totalHabilidades] = habilidade;
	}
	
	public void adicionaPergunta(Pergunta pergunta) {
		this.totalPerguntas++;
		this.perguntas[this.totalPerguntas] = pergunta;
	}
	
	public Habilidade removeHabilidade(Habilidade habilidade) {
		Habilidade habilidadeRemovida = null;
		boolean removida = false;
		
		for(int i = 0; i < this.totalHabilidades; i++) {
			if(habilidade.getNome()
					.equalsIgnoreCase(this.habilidades[i].getNome())
				&& !removida
			) {
				habilidadeRemovida = this.habilidades[i];
				removida = true;
			}
			
			if (removida) {
				this.habilidades[i] = this.habilidades[i+1];
			}	
		}
		
		this.totalHabilidades--;
		return habilidadeRemovida;
	}
	
	public Pergunta removePergunta(Pergunta pergunta) {
		Pergunta perguntaRemovida = null;
		boolean removida = false;
		
		for(int i = 0; i < this.totalPerguntas; i++) {
			if(pergunta.getPergunta()
					.equalsIgnoreCase(this.perguntas[i].getPergunta())
				&& !removida
			) {
				perguntaRemovida = this.perguntas[i];
				removida = true;
			}
			
			if (removida) {
				this.perguntas[i] = this.perguntas[i+1];
			}	
		}
		
		this.totalPerguntas--;
		return perguntaRemovida;
	}
	
	public double calculaMediaHabilidades() {
		double soma = 0.0;
		int peso = 0;
		for(int i = 0; i < this.totalHabilidades; i++) {
			 soma = soma + habilidades[i].getPeso() * habilidades[i].getNota();
			 peso = peso + habilidades[i].getPeso();
		}
		return soma / peso;
	}
	
	public double calculaMediaPerguntas() {
		double soma = 0.0;
		int peso = 0;
		for(int i = 0; i < this.totalPerguntas; i++) {
			soma = soma + perguntas[i].getPeso() * perguntas[i].getNota();
			peso = peso + perguntas[i].getPeso();
		}
		return soma / peso;
	}
	
	public double calculaMediaGeral() {
		return (this.calculaMediaHabilidades() + this.calculaMediaPerguntas()) / 2;
	}
}

