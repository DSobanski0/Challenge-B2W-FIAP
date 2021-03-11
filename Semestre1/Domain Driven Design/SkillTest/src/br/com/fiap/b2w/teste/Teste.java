package br.com.fiap.b2w.teste;

import java.util.Scanner;

import br.com.fiap.b2w.model.Cargo;
import br.com.fiap.b2w.model.Funcionario;
import br.com.fiap.b2w.model.Habilidade;
import br.com.fiap.b2w.model.Pergunta;

public class Teste {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe nome do funcionário: ");
		String nomeFuncionario = scan.nextLine();
		System.out.print("Informe CPF do funcionário: ");
		String cpf = scan.nextLine();
		System.out.println("Informe e-mail do funcionário: ");
		String email = scan.nextLine();
		Funcionario funcionario1 = new Funcionario(nomeFuncionario, cpf, email);
		System.out.printf("Nome: %s%nCPF: %s%nE-mail: %s%n", funcionario1.getNome(), funcionario1.getCpf(), funcionario1.getEmail());
		
		System.out.print("Informe o cargo: ");
		String nomeCargo = scan.nextLine();
		System.out.print("Informe a quantidade de habilidades: ");
		int qtdeHabilidades = scan.nextInt();
		System.out.print("Informe a quantidade de perguntas: ");
		int qtdePerguntas = scan.nextInt();
		Cargo cargo1 = new Cargo(nomeCargo, funcionario1, qtdeHabilidades, qtdePerguntas);
		System.out.printf("%s trabalhará no cargo %s.%n", funcionario1.getNome(), cargo1.getNome());
		
		System.out.println("Informe a habilidade: ");
		String nomeHabilidade1 = scan.next();
		System.out.print("Informe seu peso na nota final: ");
		int pesoHabilidade1 = scan.nextInt();
		System.out.print("Informe a habilidade: ");
		String nomeHabilidade2 = scan.next();
		System.out.print("Informe seu peso na nota final: ");
		int pesoHabilidade2 = scan.nextInt();
		System.out.print("Informe a habilidade: ");
		String nomeHabilidade3 = scan.next();
		System.out.print("Informe seu peso na nota final: ");
		int pesoHabilidade3 = scan.nextInt();
		System.out.print("Informe a habilidade: ");
		String nomeHabilidade4 = scan.next();
		System.out.print("Informe seu peso na nota final: ");
		int pesoHabilidade4 = scan.nextInt();
		System.out.print("Informe a habilidade: ");
		String nomeHabilidade5 = scan.next();
		System.out.print("Informe seu peso na nota final: ");
		int pesoHabilidade5 = scan.nextInt();

		Habilidade habilidade1 = new Habilidade(nomeHabilidade1, pesoHabilidade1);
		Habilidade habilidade2 = new Habilidade(nomeHabilidade2, pesoHabilidade2);
		Habilidade habilidade3 = new Habilidade(nomeHabilidade3, pesoHabilidade3);
		Habilidade habilidade4 = new Habilidade(nomeHabilidade4, pesoHabilidade4);
		Habilidade habilidade5 = new Habilidade(nomeHabilidade5, pesoHabilidade5);

		System.out.print("Informe a pergunta: ");
		String descricaoPergunta1 = scan.next();
		System.out.print("Informe seu peso na nota final: ");
		int pesoPergunta1 = scan.nextInt();
		System.out.print("Informe a pergunta: ");
		String descricaoPergunta2 = scan.next();
		System.out.print("Informe seu peso na nota final: ");
		int pesoPergunta2 = scan.nextInt();
		System.out.print("Informe a pergunta: ");
		String descricaoPergunta3 = scan.next();
		System.out.print("Informe seu peso na nota final: ");
		int pesoPergunta3 = scan.nextInt();
		System.out.print("Informe a pergunta: ");
		String descricaoPergunta4 = scan.next();
		System.out.print("Informe seu peso na nota final: ");
		int pesoPergunta4 = scan.nextInt();
		System.out.print("Informe a pergunta: ");
		String descricaoPergunta5 = scan.next();
		System.out.print("Informe seu peso na nota final: ");
		int pesoPergunta5 = scan.nextInt();

		Pergunta pergunta1 = new Pergunta(descricaoPergunta1, pesoPergunta1);
		Pergunta pergunta2 = new Pergunta(descricaoPergunta2, pesoPergunta2);
		Pergunta pergunta3 = new Pergunta(descricaoPergunta3, pesoPergunta3);
		Pergunta pergunta4 = new Pergunta(descricaoPergunta4, pesoPergunta4);
		Pergunta pergunta5 = new Pergunta(descricaoPergunta5, pesoPergunta5);		
		
		cargo1.adicionaHabilidade(habilidade1);
		cargo1.adicionaHabilidade(habilidade2);
		cargo1.adicionaHabilidade(habilidade3);
		cargo1.adicionaHabilidade(habilidade4);
		cargo1.adicionaHabilidade(habilidade5);
		
		cargo1.adicionaPergunta(pergunta1);
		cargo1.adicionaPergunta(pergunta2);
		cargo1.adicionaPergunta(pergunta3);
		cargo1.adicionaPergunta(pergunta4);
		cargo1.adicionaPergunta(pergunta5);

		System.out.printf("%s trabalhará no cargo %s e será avaliado em %s habilidades e responderá %s perguntas.%n", funcionario1.getNome(), cargo1.getNome(), cargo1.getTotalHabilidades(), cargo1.getTotalPerguntas());

		habilidade1.setNota(7.5);
		habilidade2.setNota(8.0);
		habilidade3.setNota(6.0);
		habilidade4.setNota(6.5);
		habilidade5.setNota(7.5);

		pergunta1.setNota(5.0);
		pergunta2.setNota(7.0);
		pergunta3.setNota(4.0);
		pergunta4.setNota(5.5);
		pergunta5.setNota(7.0);
		
		double x = cargo1.calculaMediaHabilidades();
		double y = cargo1.calculaMediaPerguntas();
		double z = cargo1.calculaMediaGeral();
		System.out.printf("Média das habilidades: %.1f%nMédia das perguntas: %.1f%nMédia geral: %.1f%n", x, y, z);
		
		cargo1.removeHabilidade(habilidade3);
		cargo1.removePergunta(pergunta4);
		double a = cargo1.calculaMediaHabilidades();
		double b = cargo1.calculaMediaPerguntas();
		double c = cargo1.calculaMediaGeral();
		System.out.printf("Média das habilidades: %.1f%nMédia das perguntas: %.1f%nMédia geral: %.1f", a, b, c);

		scan.close();
	}

}
