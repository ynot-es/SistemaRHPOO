package telas;

import java.util.Scanner;

import excecoes.ChaveDuplicadaException;
import negócios.Empresa;

public class TelaCadastroDepartamento {
	private Scanner scanner;
	private Empresa empresa;
	
	public TelaCadastroDepartamento(Empresa empresa) {
		this.empresa = empresa;
		scanner = new Scanner(System.in);
	}
	
	public void solicitarDados() {
		boolean erro = false;
		do {
			System.out.println("----Dados do Departamento----");
			String nome = solicitarNome();
			String codigo = solicitarCodigo();
			Double orcamento = solicitarOrcamento();
			try {
				empresa.cadastrarCargo(nome, codigo, orcamento);
				erro = false;
				System.out.println("Feito com sucesso...");
			}catch (ChaveDuplicadaException e) {
				System.out.println(e.getMessage());erro = true;
				System.out.println("Reiniciando...");
			}
		}while(erro);
		
	}
	
	public String solicitarNome() {
		System.out.println("Digite o nome do departamento:");
		return scanner.next();
	}
	
	public String solicitarCodigo() {
		System.out.println("Digite o código:");
		return scanner.next();
	}
	
	public double solicitarOrcamento() {
		System.out.println("Digite o orcamento do departamento:");
		return scanner.nextDouble();
	}
	
		
}
