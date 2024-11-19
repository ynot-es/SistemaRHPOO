package telas;

import java.util.Scanner;

import negócios.Empresa;

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
		boolean erro = false;
		do{
			try {
				gerente = empresa.buscaPorMatricula(matricula);
			}catch (ElementoInexistenteException e) {
				System.out.println(e.getMessage());erro = true;
				System.out.println("Tente novamente...");
			}
		}while(erro);
			TelaGerente.mostrarOpcoes(gerente, telaInicial);
		}
}
