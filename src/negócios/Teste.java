package negócios;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import repositório.CargoRepository;
import repositório.FuncionarioRepository;
import repositório.ICargoRepository;
import repositório.IFuncionarioRepository;

public class Teste {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
        int escolha;
        int mes; 
        int ano;
        String nome;
        String cpf;
        String matricula;
        String email;
        String titulo;
        String codigo;
        Double salario;
        Cargo cargo;
        Departamento departamento;
        boolean verifica;
        Funcionario funcionario;
        List<Funcionario> auxiliarFunc;
        List<FolhaPagamento> auxiliarFolha;
        
        System.out.println("Digite o nome da sua empresa:");
        nome = scanner.next();
        
        Empresa empresa = new Empresa(nome,LocalDate.now());
        
        do {
            // Exibe o menu de opções
            System.out.println("-----------------MENU------------------");
            System.out.println("1. Cadastrar funcionário...............");
            System.out.println("2. Remover funcionário.................");
            System.out.println("3. Busca por Matrícula.................");
            System.out.println("4. Listar funcionários.................");
            System.out.println("5. Cadastar Cargo......................");
            System.out.println("6. Remover Cargo.......................");
            System.out.println("7. Pagar Funcionários..................");
            System.out.println("8. Listar folhas de pagamento..........");
            System.out.println("0. Sair");
            System.out.print("Digite sua escolha: ");
            
            escolha = scanner.nextInt();
            System.out.println();
            switch (escolha) {
                case 1:
                	System.out.println("nome:");
                	nome = scanner.next();
                	System.out.println("cpf:");
                	cpf = scanner.next();
                	System.out.println("matrícula:");
                	matricula = scanner.next();
                	System.out.println("email:");
                	email = scanner.next();
                	System.out.println("Digite o título do cargo:");
                	titulo = scanner.next();
                	
                	//Não deveria ser algo do tipo?
                	cargo = empresa.BuscaPorcargo(titulo);
                	
                	funcionario = new Funcionario(nome, cpf, matricula, email, cargo, LocalDate.now());
                	empresa.cadastrarFuncionario(funcionario);
                	if(cargo == null) {
                		System.out.println("Funcionário cadastrado sem cargo!");
                	}
                	
                	break;
                	
                case 2:
                	System.out.println("matrícula:");
                	matricula = scanner.next();
                	verifica = empresa.remover(matricula);
                	if (verifica == true) {
                		System.out.println("Funcionário removido com sucesso!");
                	}else {
                		System.out.println("Erro na remoção / matrícula inválida!");
                	}
                	break;
                	
                case 3:
                	System.out.println("matrícula:");
                	matricula = scanner.next();
                	funcionario = empresa.buscarPorMatricula(matricula);
                	if(funcionario != null) {
                		System.out.println(funcionario.toString());
                	}
                	else {
                		System.out.println("Funcionário de matricula '" + matricula + "' não encontrado");
                	}
                	break;
                	
                case 4:
                    auxiliarFunc = empresa.getFuncionarios();
            		for (Funcionario funcionarios : auxiliarFunc) {
            			System.out.println(funcionarios.toString());
                    }
            		break;
            		
                case 5:
                	System.out.println("Digite o título do cargo:");
                	titulo = scanner.next();
                	System.out.println("Digite o salário correspondente:");
                	salario = scanner.nextDouble();
                	System.out.println("Digite o código do departamento:");
                	codigo = scanner.next();
                	
                	departamento = empresa.BuscaPorDepartamento(codigo);
                	
                	cargo = new Cargo(titulo, salario, departamento);
                	empresa.cadastrarCargo(cargo);
                	if(departamento == null) {
                		System.out.println("Departamento omitido!");
                	}
                	
                case 6:
                	System.out.println("Digite o título do cargo:");
                	titulo = scanner.next();
                	
                	verifica = empresa.removerCargo(titulo);      
                	
                	if(verifica == true) {
                		System.out.println("Cargo removido com sucesso!");
                	}else {
                		System.out.println("Erro na remoção / cargo inválido!");
                	}
                	
                case 7:
                	System.out.println("Digite o mês de referência:");
                	mes = scanner.nextInt();
                	System.out.println("Digite o ano de referência:");
                	ano = scanner.nextInt();
                	empresa.pagarFuncionarios(mes, ano);
                	
                	//como eu verifico se foi pago com sucesso?
                	
                case 8:
                	auxiliarFolha = empresa.getFolhaPagamento();
            		for (FolhaPagamento folhas : auxiliarFolha) {
            			System.out.println(folhas.toString());
                    }
                	
                case 0:
                	break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            
            System.out.println();

        } while (escolha != 0);

        scanner.close();
        
	}
}
