package telas;

import java.util.Scanner;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import negócios.Empresa;
import negócios.Funcionario;

public class TelaGerenteGeral {
	private Empresa empresa;
	private Scanner scanner;

	public TelaGerenteGeral(Empresa empresa) {
		scanner = new Scanner(System.in);
		this.empresa = empresa;
	}
	
	public void mostrarOpcoes(GerenteGeral gerente, TelaInicial telaInicial) {
		String operacao = "N";
		System.err.println(">>>Olá,"+gerente.getNome()+"!<<<");
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
			case "1" : cadastrarCargo();
			case "2" : removerCargo();
			case "3" : listarCargo();
			case "4" : cadastrarDepartamento();
			case "5" : removerDepartamento();
			case "6" : listarDepartamemto();
			case "7" : cadastrarGerente();
			case "8" : removerGerente();
			case "9" : listarGerente();
			case "s": 
			case "S": telaInicial.iniciar();
			default:
				throw new IllegalArgumentException("Valor inesperado: " + operacao);
			}
		}
	}

	public void cadastrarCargo() {
		boolean erro = false;
		do {
			System.out.println("----Cadastro de Cargo----");
			System.out.println("Digite o título:");
			String titulo = scanner.next();
			System.out.println("Digite o salário:");
			double salario = scanner.nextDouble();
			System.out.println("Digite o código:");
			String codigo = scanner.next();
			try {
				//funcao de cadastrar o cargo
				erro = false;
				System.out.println("Feito com sucesso...");
			}catch (ChaveDuplicadaException  | ElementoInexistenteException e) {
				System.out.println("Chave duplicada ou Cargo Inexistente.");erro = true;
				System.out.println("Reiniciando...");
			}
		}while(erro);
	}
	
	private void removerCargo() {
		boolean erro = false;
		do {
			System.out.println("----Remoção de Cargo----");
			System.out.println("Digite o título:");
			String titulo = scanner.next();
			try {
				//funcao de remover o cargo
				erro = false;
				System.out.println("Feito com sucesso...");
			}catch (ElementoInexistenteException e) {
				System.out.println("Cargo Inexistente.");erro = true;
				System.out.println("Reiniciando...");
			}
		}while(erro);	
	}
	
	private void listarCargo() {
		boolean erro = false;
			System.out.println("----Listagem de Cargos----");
			cargo = empresa.getCargos();
    		for (Funcionario cargosEmpresa : cargo) {
    			System.out.println(cargo.toString());
            }
	}
	
}

public void cadastrarDepartamento() {
	boolean erro = false;
	do {
		System.out.println("----Cadastro de Departamento----");
		System.out.println("Digite o código:");
		String titulo = scanner.next();
		System.out.println("Digite o salário:");
		double salario = scanner.nextDouble();
		System.out.println("Digite o código:");
		String codigo = scanner.next();
		try {
			//funcao de cadastrar o cargo
			erro = false;
			System.out.println("Feito com sucesso...");
		}catch (ChaveDuplicadaException  | ElementoInexistenteException e) {
			System.out.println("Chave duplicada ou Cargo Inexistente.");erro = true;
			System.out.println("Reiniciando...");
		}
	}while(erro);
}

private void removerCargo() {
	boolean erro = false;
	do {
		System.out.println("----Remoção de Cargo----");
		System.out.println("Digite o título:");
		String titulo = scanner.next();
		try {
			//funcao de remover o cargo
			erro = false;
			System.out.println("Feito com sucesso...");
		}catch (ElementoInexistenteException e) {
			System.out.println("Cargo Inexistente.");erro = true;
			System.out.println("Reiniciando...");
		}
	}while(erro);	
}

private void listarCargo() {
	boolean erro = false;
		System.out.println("----Listagem de Cargos----");
		cargo = empresa.getCargos();
		for (Funcionario cargosEmpresa : cargo) {
			System.out.println(cargo.toString());
        }
}

}



