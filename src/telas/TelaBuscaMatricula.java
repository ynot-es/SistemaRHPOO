package telas;

import java.util.Scanner;

import excecoes.ElementoInexistenteException;
import negócios.Empresa;

public class TelaBuscaMatricula {
	
	private Scanner scanner;
	private Empresa empresa;
	
	public TelaBuscaMatricula(Empresa empresa) {
		this.empresa = empresa;
		scanner = new Scanner(System.in);
	}
	
	public void solicitarDados() {
		boolean erro = false;
		do {
			System.out.println("----Busca por Matrícula----");
			String matricula = solicitarMatricula();
			try {
				empresa.buscarGerenciado(matricula);
				erro = false;
				System.out.println("Feito com sucesso...");
			}catch (ElementoInexistenteException e) {
				System.out.println(e.getMessage());erro = true;
				System.out.println("Reiniciando...");
			}
		}while(erro);
	}

	public String solicitarMatricula() {
		System.out.println("Digite a matrícula:");
		return scanner.nextLine();
	}

}
