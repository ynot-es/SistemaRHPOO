package telas;

import java.util.List;
import java.util.Scanner;

import excecoes.ElementoInexistenteException;
import negócios.Empresa;
import negócios.Funcionario;

public class TelaLoginFuncionario {
	private Empresa empresa;
	private Scanner scanner;
	private Funcionario funcionario;
	private TelaFuncionario telaFuncionario;
	
	public TelaLoginFuncionario(Empresa empresa) {
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
				funcionario = empresa.getGerente().buscaPorMatricula(matricula);
			}catch (ElementoInexistenteException e) {
				System.out.println(e.getMessage());erro = true;
				System.out.println("Tente novamente...");
			}
		}while(erro);
		telaFuncionario.mostrarOpcoes(funcionario, telaInicial);
	}
}
