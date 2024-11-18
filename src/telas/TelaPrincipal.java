package telas;

import java.util.Scanner;

import negócios.Empresa;

public class TelaPrincipal {
	private Scanner scanner;
	private TelaCadastroFuncionario telaCadastroFuncionario;
	private TelaCadastroCargo telaCadastroCargo;
	private TelaCadastroDepartamento telaCadastroDepartamento;
	
	public TelaPrincipal(Empresa empresa) {
		scanner = new Scanner(System.in);
		telaCadastroFuncionario = new TelaCadastroFuncionario(empresa);
		telaCadastroCargo = new TelaCadastroCargo(empresa);
		telaCadastroDepartamento = new TelaCadastroDepartamento(empresa);
	}

	public void iniciar() {
		while(true) {
			System.out.println("-----------Opções------------");
			System.out.println("1. Cadastrar Funcionário.....");
			System.out.println("2. Cadastrar Cargo...........");
			System.out.println("3. Cadastrar Departamento....");
			String operacao = scanner.nextLine();
			switch (operacao) {
			case "1" : telaCadastroFuncionario.solicitarDados(); break;
			case "2" : telaCadastroCargo.solicitarDados(); break;
			case "3" : telaCadastroDepartamento.solicitarDados(); break;
			case "s":
			case "S": System.exit(0); break;
			default:
				throw new IllegalArgumentException("Valor inesperaddo: " + operacao);
			}
		}
	}
}
