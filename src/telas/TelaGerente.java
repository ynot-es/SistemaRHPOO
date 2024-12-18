package telas;

import java.util.Scanner;

import negócios.Empresa;
import negócios.Gerente;

public class TelaGerente {
	private Scanner scanner;
	private TelaCadastroFuncionario telaCadastroFuncionario;
	private TelaRemocaoFuncionario telaRemocaoFuncionario;
	private TelaBuscaMatricula telaBuscaMatricula;
	private TelaListarFuncionario telaListarFuncionarios;
	private TelaCadastroCargo telaCadastroCargo;
	private TelaCadastroDepartamento telaCadastroDepartamento;
	private Gerente gerente;
	
	public TelaGerente(Gerente gerente, Empresa empresa, Scanner scanner) {
		this.scanner = scanner;
		this.gerente = gerente;
		this.telaCadastroFuncionario = new TelaCadastroFuncionario(empresa, gerente, scanner);
		this.telaCadastroCargo = new TelaCadastroCargo(empresa);
		this.telaRemocaoFuncionario = new TelaRemocaoFuncionario(gerente, empresa);
		this.telaCadastroDepartamento = new TelaCadastroDepartamento(empresa);
		this.telaBuscaMatricula = new TelaBuscaMatricula(empresa);
	}

	public void mostrarOpcoes(Gerente gerente, TelaInicial telaInicial) {
		String operacao = "N";
		System.err.println(">>>Olá," + gerente.getNome() + "!<<<");
		while(operacao != "S") {
			System.out.println("-----------Opções------------");
			System.out.println("1. Cadastrar Funcionário..................");
			System.out.println("2. Remover Funcionário....................");
			System.out.println("3. Buscar funcionario por Matrícula.......");
			System.out.println("S - Voltar................................");
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
