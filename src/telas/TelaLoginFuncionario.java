package telas;

import java.util.List;
import java.util.Scanner;

import excecoes.ElementoInexistenteException;
import negócios.Empresa;
import negócios.Funcionario;
import negócios.Gerenciado;

public class TelaLoginFuncionario {
	private Empresa empresa;
	private Scanner scanner;
	private Gerenciado gerenciado;
	private TelaGerenciado telaFuncionario;
	
	public TelaLoginFuncionario(Empresa empresa) {
		scanner = new Scanner(System.in);
		this.empresa = empresa;
	}

	public void Login(TelaInicial telaInicial) {
		
		System.out.println("-----Digite sua Matrícula-----");
		String matricula;
		matricula = scanner.next();
		boolean erro = false;
			try {
				gerenciado = empresa.buscarGerenciado(matricula);
			}catch (ElementoInexistenteException e) {
				System.out.println(e.getMessage());
				System.out.println("Tente novamente...");
			}
		telaFuncionario.mostrarOpcoes(gerenciado, telaInicial);
	}
}
