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
			String titulo = solicitarCargo();
			Double salario = solicitarNumero();
			String codigo = solicitarCargo();
			try {
				empresa.cadastrarCargo(titulo, salario, codigo);
				erro = false;
				System.out.println("Feito com sucesso...");
			}catch (ChaveDuplicadaException e) {
				System.out.println(e.getMessage());erro = true;
				System.out.println("Reiniciando...");
			}
		}while(erro);
		
	}
	
	public String solicitarCargo() {
		return scanner.next();
	}
	
	public double solicitarNumero() {
		return scanner.nextDouble();
	}
	
}
