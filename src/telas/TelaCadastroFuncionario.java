package telas;

import java.time.LocalDate;
import java.util.Scanner;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import negócios.Cargo;
import negócios.Empresa;
import negócios.Gerente;

public class TelaCadastroFuncionario {
	private Scanner scanner;
	private LocalDate data;
	private Empresa empresa;
	private Gerente gerente;
	
	public TelaCadastroFuncionario(Empresa empresa, Gerente gerente, Scanner scanner) {
		this.empresa = empresa;
		this.gerente = gerente;
		this.scanner = scanner;
		data = LocalDate.now();
	}
	
	public void solicitarDados() {
		boolean erro = false;
		do {
			System.out.println("----Dados do Funcionário----");
			String nome = solicitarNome();
			String cpf = solicitarCpf();
			String email = solicitarEmail();
			String matricula = solicitarMatricula();
			String titulo = solicitarTitulo();
			try {
				gerente.cadastrarFuncionario(nome, cpf, email, matricula, empresa.acessarCargo(titulo));
				erro = false;
				System.out.println("Feito com sucesso...");
			}catch (ChaveDuplicadaException  | ElementoInexistenteException e) {
				System.out.println("Chave duplicada ou Cargo Inexistente.");erro = true;
				System.out.println("Reiniciando...");
			}
		}while(erro);
		
	}
	
	public String solicitarNome() {
		System.out.println("Digite o nome:");
		return scanner.nextLine();
	}
	
	public String solicitarCpf() {
		System.out.println("Digite o CPF:");
		return scanner.nextLine();
	}
	
	public String solicitarEmail() {
		System.out.println("Digite o email:");
		return scanner.nextLine();
	}
	
	public String solicitarMatricula() {
		System.out.println("Digite a matrícula:");
		return scanner.nextLine();
	}
	
	public String solicitarTitulo() {
		System.out.println("Digite o título do cargo:");
		return scanner.nextLine();
	}
		
}

