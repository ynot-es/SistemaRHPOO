package telas;

import java.util.Scanner;

import excecoes.ChaveDuplicadaException;
import negócios.Empresa;
import negócios.Gerenciado;

public class TelaGerenciado {
	private Empresa empresa;
	private Scanner scanner;
	
	public TelaGerenciado(Empresa empresa) {
		scanner = new Scanner(System.in);
		this.empresa = empresa;
	}
	
	public void mostrarOpcoes(Gerenciado gerenciado, TelaInicial telaInicial){
		
		String operacao;
		do {
			System.err.println(">>>Olá,"+gerenciado.getNome()+"!<<<");
			System.out.println("-----------Opções------------");
			System.out.println("1. Pedir Afastamento.........");
			System.out.println("2. Pedir Demissão............");
			System.out.println("S - Voltar...................");
			operacao = scanner.nextLine();
			switch (operacao) {
			case "1" : pedirAfastamento(gerenciado); break;
			case "2" : pedirDemissao(gerenciado); break;
			case "s" :
			case "S" : telaInicial.iniciar(); break;
			default:
				throw new IllegalArgumentException("Valor inesperddo: " + operacao);
			}
		}while(operacao != "S");
	}
	
	public void pedirAfastamento(Gerenciado gerenciado) {
		String verifica;
		System.out.println("Confirma a solicitação? S : sim ou N: nao");
		verifica = scanner.nextLine();
		if(verifica.equals("S")) {
			int dias = 0;
			System.out.println("Digite o número de dias:");
			scanner.nextInt();
			scanner.nextLine(); 
			gerenciado.pedirAfastamento(dias);
			System.out.println("Solicitação realizada.");
		}else {
			System.out.println("Solicitação cancelada.");
		}
	}
	
	public void pedirDemissao(Gerenciado gerenciado){
		String verifica;
		System.out.println("Confirma a solicitação? S : sim ou N: nao");
		verifica = scanner.nextLine();
		if(verifica.equals("S")) {
			gerenciado.pedirDemissao();
			System.out.println("Solicitação realizada.");
		}else {
			System.out.println("Solicitação cancelada.");
		}
	}
}
