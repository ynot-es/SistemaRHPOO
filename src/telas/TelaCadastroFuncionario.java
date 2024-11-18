package telas;

import java.time.LocalDate;
import java.util.Scanner;

import excecoes.ChaveDuplicadaException;
import negócios.Cargo;
import negócios.Empresa;

public class TelaCadastroFuncionario {
	private Scanner scanner;
	private Empresa empresa;
	
	public TelaCadastroFuncionario(Empresa empresa) {
		this.empresa = empresa;
		scanner = new Scanner(System.in);
	}
	
	public void solicitarDados() {
		boolean erro = false;
		do {
			System.out.println("----Dados do Funcionário----");
			String nome = solicitarFuncionario();
			String cpf = solicitarFuncionario();
			String email = solicitarFuncionario();
			String matricula = solicitarFuncionario();
			String titulo = solicitarFuncionario();
			try {
				empresa.cadastrarFuncionario(nome, cpf, email, matricula, titulo);
				erro = false;
				System.out.println("Feito com sucesso...");
			}catch (ChaveDuplicadaException e) {
				System.out.println(e.getMessage());erro = true;
				System.out.println("Reiniciando...");
			}
		}while(erro);
		
	}
	
	public String solicitarFuncionario() {
		return scanner.next();
	}
		
}

