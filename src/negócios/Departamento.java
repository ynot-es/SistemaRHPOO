package negócios;

import java.util.ArrayList;

public class Departamento {
	private String nome;
	private String codigo;
	private Funcionario gestor;
	private ArrayList<Funcionario> funcionarios;
	private Double orcamento;
	
	public Departamento(String nome, String codigo, Funcionario gestor, ArrayList<Funcionario> funcionarios, Double orcamento) {
		this.nome = nome;
		this.codigo = codigo;
		this.gestor = gestor;
		this.funcionarios = funcionarios;
		this.orcamento = orcamento;
	}

	public Funcionario getGestor() {
		return gestor;
	}

	public void setGestor(Funcionario gestor) {
		this.gestor = gestor;
	}

	public Double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}

	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
}
