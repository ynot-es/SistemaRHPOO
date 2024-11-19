package telas;

import java.util.Scanner;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
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
			String gerente = solicitarGerente();
			try {
				empresa.cadastrarDepartamento(nome, codigo, empresa.buscarGerente(gerente));
				erro = false;
				System.out.println("Feito com sucesso...");
			}catch (ChaveDuplicadaException e) {
				System.out.println(e.getMessage());erro = true;
				System.out.println("Reiniciando...");
			}catch (ElementoInexistenteException e) {
				System.out.println(e.getMessage());erro = true;
				System.out.println("Reiniciando...");
			}
		}while(erro);
		
	}
	
	public String solicitarNome() {
		System.out.println("Digite o nome do departamento:");
		return scanner.nextLine();
	}
	
	public String solicitarCodigo() {
		System.out.println("Digite o código:");
		return scanner.nextLine();
	}
	
	public String solicitarGerente() {
		System.out.println("Digite a matricula do gerente: ");
		return scanner.nextLine();
	}
	
		
}
