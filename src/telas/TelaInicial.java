package telas;

import java.util.Scanner;

import negócios.Empresa;

public class TelaInicial {

		private Scanner scanner;
		private TelaLoginGerente telaLoginGerente;
		private TelaLoginFuncionario telaLoginFuncionario;
		private TelaGerenteGeral telaDono;
		
		public TelaInicial(Empresa empresa) {
			scanner = new Scanner(System.in);
			telaLoginGerente = new TelaLoginGerente(empresa);
			telaLoginFuncionario = new TelaLoginFuncionario(empresa);
			telaDono = new TelaDono(empresa);
		}

		public void iniciar() {
			while(true) {
				System.out.println("-----------Opções------------");
				System.out.println("1. Opções do Gerente.........");
				System.out.println("2. Opções dos Funcionários...");
				System.out.println("3. Opções do Dono............");
				System.out.println("S - Sair.....................");
				String operacao = scanner.nextLine();
				switch (operacao) {
				case "1" : telaLoginGerente.Login(this); break;
				case "2" : telaLoginFuncionario.Login(this); break;
				case "3" : ; break;
				case "s" :
				case "S": System.exit(0); break;
				default:
					throw new IllegalArgumentException("Valor inesperado: " + operacao);
				}
			}
		}
	}
