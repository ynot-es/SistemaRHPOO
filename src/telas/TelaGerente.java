package telas;

import java.util.Scanner;

import negócios.Empresa;

public class TelaGerente {
	private Scanner scanner;
	private TelaCadastroFuncionario telaCadastroFuncionario;
	private TelaRemocaoFuncionario telaRemocaoFuncionario;
	private TelaBuscaMatricula telaBuscaMatricula;
	private TelaListarFuncionario telaListarFuncionarios;
	private TelaCadastroCargo telaCadastroCargo;
	private TelaCadastroDepartamento telaCadastroDepartamento;
	
	public TelaGerente(Empresa empresa) {
		scanner = new Scanner(System.in);
		telaCadastroFuncionario = new TelaCadastroFuncionario(empresa);
		telaCadastroCargo = new TelaCadastroCargo(empresa);
		telaCadastroDepartamento = new TelaCadastroDepartamento(empresa);
		
	}

	public void mostrarOpcoes(Gerente gerente, TelaInicial telaInicial) {
		String operacao = "N";
		System.err.println(">>>Olá,"+gerente.getNome()+"!<<<");
		while(operacao != "S") {
			System.out.println("-----------Opções------------");
			System.out.println("1. Cadastrar Funcionário.....");
			System.out.println("2. Remover Funcionário.......");
			System.out.println("3. Busca por Matrícula.......");
			System.out.println("S - Voltar...................");
			operacao = scanner.nextLine();
			switch (operacao) {
			case "1" : telaCadastroFuncionario.solicitarDados(); break;
			case "2" : telaRemocaoFuncionario.solicitarDados(); break;
			case "3" : telaBuscaMatricula.solicitarDados(); break;
			case "s":
			case "S": telaInicial.iniciar();
			default:
				throw new IllegalArgumentException("Valor inesperado: " + operacao);
			}
		}
	}
}
