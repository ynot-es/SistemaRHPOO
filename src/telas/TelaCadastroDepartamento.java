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
			String nome = solicitarDepartamento();
			String codigo = solicitarDepartamento();
			String matricula = solicitarDepartamento();
			Double orcamento = solicitarNumero();
			try {
				empresa.cadastrarCargo(nome, codigo, matricula, orcamento);
				erro = false;
				System.out.println("Feito com sucesso...");
			}catch (ChaveDuplicadaException e) {
				System.out.println(e.getMessage());erro = true;
				System.out.println("Reiniciando...");
			}
		}while(erro);
		
	}
	
	public String solicitarDepartamento() {
		return scanner.next();
	}
	
	public double solicitarNumero() {
		return scanner.nextDouble();
	}
		
}
