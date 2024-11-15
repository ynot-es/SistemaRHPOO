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
		IFuncionarioRepository fRepository = new FuncionarioRepository();
		ICargoRepository cRepository = new CargoRepository(); 
		Scanner scanner = new Scanner(System.in);
        int escolha;
       
		Cargo cargo1 = new Cargo("Viado", 1200.90, null);
        cRepository.adicionarCargo(cargo1);
		
        String nome;
        String cpf;
        String matricula;
        String email;
        
        List<Funcionario> funcionarios;
     
        do {
            // Exibe o menu de opções
            System.out.println("Menu ------------------------------------");
            System.out.println("1. Salvar Funcionário");
            System.out.println("2. Demitir Funcionário");
            System.out.println("3. Busca por Matrícula");
            System.out.println("4. Ver funcionários");
            System.out.println("0. Sair");
            System.out.print("Digite sua escolha: ");
            
            escolha = scanner.nextInt();
            System.out.println();
            switch (escolha) {
                case 1:
                	System.out.println("nome");
                	nome = scanner.next();
                	System.out.println("cpf");
                	cpf = scanner.next();
                	System.out.println("matricula");
                	matricula = scanner.next();
                	System.out.println("email");
                	email = scanner.next();
                	
                	Funcionario func1 = new Funcionario(nome, cpf, matricula, email, cargo1, LocalDate.now());
                	fRepository.salvar(func1);
                	
                	break;
                	
                case 2:
                	matricula = scanner.next();
                	boolean verifica = fRepository.remover(matricula);
                	System.out.println("Remoção realizada com sucesso? " + verifica);
                	break;
                case 3:
                	matricula = scanner.next();
                	Funcionario user = fRepository.buscarPorMatricula(matricula);
                	if(user != null) {
                		System.out.println(user.nome);
                	}
                	else {
                		System.out.println("Funcionário de matricula '" + matricula + "' não encontrado");
                	}
                	break;
                case 4:
                    funcionarios = fRepository.getFuncionarios();
            		for (Funcionario usuario : funcionarios) {
            			System.out.println(usuario.toString());
                    }
            		break;
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
