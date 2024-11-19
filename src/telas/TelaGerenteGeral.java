package telas;

import java.util.List;
import java.util.Scanner;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import negócios.Cargo;
import negócios.Departamento;
import negócios.Empresa;
import negócios.Funcionario;
import negócios.Gerente;

public class TelaGerenteGeral {
    private Empresa empresa;
    private Scanner scanner;

    public TelaGerenteGeral(Empresa empresa, Scanner scanner) {
        this.empresa = empresa;
        this.scanner = scanner;
    }
	
	public void mostrarOpcoes(Empresa gerenteGeral, TelaInicial telaInicial) {
		String operacao = "N";
		System.err.println(">>>"+gerenteGeral.getNome()+"<<<");
		while(operacao != "S") {
			System.out.println("-----------Opções------------");
			System.out.println("1. Cadastrar Cargo...........");
			System.out.println("2. Remover Cargo.............");
			System.out.println("3. Listar Cargos.............");
			System.out.println("4. Cadastrar Departamento....");
			System.out.println("5. Remover Departamento......");
			System.out.println("6. Listar Departamento.......");
			System.out.println("7. Cadastrar Gerente.........");
			System.out.println("8. Remover Gerente...........");
			System.out.println("9. Listar Gerentes...........");
			System.out.println("S - Voltar...................");
			operacao = scanner.nextLine();
			switch (operacao) {
			case "1" : cadastrarCargo(); break;
			case "2" : removerCargo(); break;
			case "3" : listarCargos(); break;
			case "4" : criarDepartamento(); break;
			case "5" : removerDepartamento(); break;
			case "6" : listarDepartamentos(); break;
			case "7" : cadastrarGerente(); break;
			case "8" : removerGerente(); break;
			case "9" : listarGerentes(); break;
			case "s": 
			case "S": telaInicial.iniciar(); break;
			default:
				throw new IllegalArgumentException("Valor inesperado: " + operacao);
			}
		}
	}

	private void cadastrarCargo() {
		System.out.println("----Cadastro de Cargo----");
		System.out.println("Digite o título:");
		String titulo = scanner.nextLine();
		System.out.println("Digite o salário:");
		double salario = scanner.nextDouble();
		System.out.println("Digite o departamento onde ele atua:");
		String departamento = scanner.nextLine();
		System.out.println("Digite o cargo superior a ele (se houver)");
		String nomeCargo = scanner.nextLine();
		try {
			Cargo cargo = empresa.acessarCargo(nomeCargo);
			try {
				empresa.cadastrarCargo(titulo, salario, empresa.acessarDepartamento(departamento), cargo);
				System.out.println("Feito com sucesso...");
			}catch (ChaveDuplicadaException  | ElementoInexistenteException e) {
				System.out.println("Chave duplicada ou Cargo Inexistente.");
				System.out.println("Reiniciando...");
			}
		}catch (ElementoInexistenteException e) {
			try {
				empresa.cadastrarCargo(titulo, salario, empresa.acessarDepartamento(departamento), null);
				System.out.println("Feito com sucesso...");
			}catch (ChaveDuplicadaException  | ElementoInexistenteException er) {
				System.out.println("Chave duplicada ou Cargo Inexistente.");
				System.out.println("Reiniciando...");
			}
		}
	}
	
	private void removerCargo() {
		System.out.println("----Remoção de Cargo----");
		System.out.println("Digite o título:");
		String titulo = scanner.nextLine();
		try {
			empresa.removerCargo(titulo);
			System.out.println("Feito com sucesso...");
		}catch (ElementoInexistenteException e) {
			System.out.println("Cargo Inexistente.");
			System.out.println("Reiniciando...");
		}
	}
	
	private void listarCargos() {
		System.out.println("----Listagem de Cargos----");
		List<Cargo> cargos = empresa.getCargos();
		for (Cargo cargoEmpresa : cargos) {
			System.out.println(cargoEmpresa.toString());
        }
	}
	
	private void criarDepartamento() {
		System.out.println("----Cadastro de Departamento----");
		System.out.println("Digite o nome:");
		String nome = scanner.nextLine();
		System.out.println("Digite o codigo:");
		String codigo = scanner.nextLine();
		System.out.println("Digite a matricula do gerente:");
		String gerente = scanner.nextLine();
		try {
			empresa.cadastrarDepartamento(nome, codigo, empresa.buscarGerente(gerente));
			System.out.println("Feito com sucesso...");
		}catch (ChaveDuplicadaException  | ElementoInexistenteException e) {
			System.out.println("Chave duplicada ou Cargo Inexistente.");
			System.out.println("Reiniciando...");
		}
	}
	private void removerDepartamento() {
		System.out.println("----Remoção de Departamentos----");
		System.out.println("Digite o título:");
		String code = scanner.nextLine();
		try {
			empresa.removerDepartamento(code);
			System.out.println("Feito com sucesso...");
		}catch (ElementoInexistenteException e) {
			System.out.println("Cargo Inexistente.");
			System.out.println("Reiniciando...");
		}
	}
	private void listarDepartamentos() {
		System.out.println("----Listagem de Departamentos----");
		List<Departamento> departamentos = empresa.getDepartamentos();
		for (Departamento departamentoAtual : departamentos) {
			System.out.println(departamentoAtual.toString());
		}
	}
	
	private void cadastrarGerente() {
		System.out.println("----Cadastro de Gerente----");
		System.out.println("Digite o nome:");
		String nome = scanner.nextLine();
		System.out.println("Digite o cpf:");
		String cpf = scanner.nextLine();
		System.out.println("Digite o email:");
		String email = scanner.nextLine();
		System.out.println("Digite a matricula:");
		String matricula = scanner.nextLine();
		try {
			empresa.cadastrarGerente(nome, cpf, email, matricula, null);
			System.out.println("Feito com sucesso...");
		}catch (ChaveDuplicadaException e) {
			System.out.println("Chave duplicada ou Cargo Inexistente.");
		}
	}
	private void removerGerente() {
		System.out.println("----Remoção de Gerente----");
		System.out.println("Digite o título:");
		String matricula = scanner.nextLine();
		try {
			empresa.demitirGerente(matricula);
			System.out.println("Feito com sucesso...");
		}catch (ElementoInexistenteException e) {
			System.out.println("Cargo Inexistente.");
			System.out.println("Reiniciando...");
		}
	}
	private void listarGerentes() {
		System.out.println("----Listagem de Gerentes----");
		List<Gerente> gerentes = empresa.getGerentes();
		for (Gerente gerenteAtual : gerentes) {
			System.out.println(gerenteAtual.toString());
		}
	}
}






