package telas;

import java.util.Scanner;

import excecoes.ChaveDuplicadaException;
import negócios.Empresa;

public class TelaCadastroCargo {
	private Scanner scanner;
	private Empresa empresa;
	
	public TelaCadastroCargo(Empresa empresa) {
		this.empresa = empresa;
		scanner = new Scanner(System.in);
	}
	
	public void solicitarDados() {
		boolean erro = false;
		do {
			System.out.println("----Dados do Cargo----");
			
			String titulo = solicitarTitulo();
			Double salario = solicitarSalario();
			String codigo = solicitarCodigo();
			try {
				empresa.cadastrarCargo(titulo, salario, null, null);
				erro = false;
				System.out.println("Feito com sucesso...");
			}catch (ChaveDuplicadaException e) {
				System.out.println(e.getMessage());
				erro = true;
				System.out.println("Reiniciando...");
			}
		}while(erro);
		
	}
	
	public String solicitarTitulo() {
		System.out.println("Digite o titulo do cargo:");
		return scanner.next();
	}
	
	public double solicitarSalario() {
	    System.out.println("Digite o salário:");
		return scanner.nextDouble();
	}
	
	public String solicitarCodigo() {
		System.out.println("Digite o código do cargo:");
		return scanner.next();
	}
	
}
