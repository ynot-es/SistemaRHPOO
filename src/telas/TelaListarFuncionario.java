package telas;

import java.util.List;

import negócios.Empresa;
import negócios.Funcionario;

public class TelaListarFuncionario {

	private Empresa empresa;
	private List<Funcionario> auxiliarFunc;
	
	public TelaListarFuncionario(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void solicitarDados() {
		
		System.out.println("----Listagem de Funcionários----");
		auxiliarFunc = empresa.getFuncionarios();
		for (Funcionario funcionarios : auxiliarFunc) {
			System.out.println(funcionarios.toString());
		}
		System.out.println("Feito com sucesso...");
	}

}
