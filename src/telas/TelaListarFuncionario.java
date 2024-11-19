package telas;

import java.util.List;

import negócios.Empresa;
import negócios.Funcionario;
import negócios.Gerenciado;

public class TelaListarFuncionario {

	private Empresa empresa;
	private List<Gerenciado> auxiliarFunc;
	
	public TelaListarFuncionario(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void solicitarDados() {
		
		System.out.println("----Listagem de Funcionários----");
		auxiliarFunc = empresa.getGerenciados();
		for (Gerenciado funcionario : auxiliarFunc) {
			System.out.println(funcionario.toString());
		}
		System.out.println("Feito com sucesso...");
	}

}
