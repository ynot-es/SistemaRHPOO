package telas;

import java.util.Scanner;

import negócios.Empresa;
import negócios.Funcionario;

public class TelaFuncionario {
	private Empresa empresa;
	private Scanner scanner;
	
	public TelaFuncionario(Empresa empresa) {
		scanner = new Scanner(System.in);
		this.empresa = empresa;
	}
	
	public void mostrarOpcoes(Funcionario funcionario, TelaInicial telaInicial) {
		
		String operacao;
		do {
			System.err.println(">>>Olá,"+funcionario.getNome()+"!<<<");
			System.out.println("-----------Opções------------");
			System.out.println("1. Pedir Afastamento.........");
			System.out.println("2. Pedir Demissão............");
			System.out.println("2. Pedir Promoção............");
			System.out.println("S - Voltar...................");
			operacao = scanner.nextLine();
			switch (operacao) {
			case "1" : pedirAfastamento(funcionario);
			case "2" : pedirDemissao(funcionario);
			case "3" : pedirPromoção(funcionario);
			case "s" :
			case "S" : telaInicial.iniciar();
			default:
				throw new IllegalArgumentException("Valor inesperddo: " + operacao);
			}
		}while(operacao != "S");
	}
	
	public void pedirAfastamento(Funcionario funcionario) {
		String verifica;
		System.out.println("Confirma a solicitação? S : sim ou N: nao");
		verifica = scanner.next();
		if(verifica == "S") {
			int dias;
			System.out.println("Digite o número de dias:");
			scanner.nextInt();
			funcionario.pedirAfastamento(dias);
			System.out.println("Solicitação realizada.");
		}else {
			System.out.println("Solicitação cancelada.");
		}
	}
	
	public void pedirDemissao(Funcionario funcionario) {
		String verifica;
		System.out.println("Confirma a solicitação? S : sim ou N: nao");
		verifica = scanner.next();
		if(verifica == "S") {
			funcionario.pedirDemissao();
			System.out.println("Solicitação realizada.");
		}else {
			System.out.println("Solicitação cancelada.");
		}
	}
	
	public void pedirPromocao(Funcionario funcionario) {
		String verifica;
		System.out.println("Confirma a solicitação? S : sim ou N: nao");
		verifica = scanner.next();
		if(verifica == "S") {
			funcionario.pedirPromoção();
			System.out.println("Solicitação realizada.");
		}else {
			System.out.println("Solicitação cancelada.");
		}
	}
}
