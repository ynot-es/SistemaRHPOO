package telas;

import java.util.Scanner;

import excecoes.ElementoInexistenteException;
import negócios.Empresa;
import negócios.Gerente;

public class TelaLoginGerente {

	private Empresa empresa;
	private Scanner scanner;
	private TelaGerente telaGerente;
	
	public TelaLoginGerente(Empresa empresa) {
		scanner = new Scanner(System.in);
		this.empresa = empresa;
	}

	public void Login(TelaInicial telaInicial) {
			System.out.println("-----Digite sua Matrícula-----");
			String matricula;
			matricula = scanner.next();
			Gerente gerente = null;
		
			try {
				gerente = empresa.buscarGerente(matricula);
			}catch (ElementoInexistenteException e) {
				System.out.println(e.getMessage());
				System.out.println("Tente novamente...");
			}
		
		telaGerente.mostrarOpcoes(gerente, telaInicial);
	}
}
