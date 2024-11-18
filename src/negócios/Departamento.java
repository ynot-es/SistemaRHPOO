package negócios;

import java.util.ArrayList;

public class Departamento {
	private String nome;
	private String codigo;
	private Gerente gerente;
	private ArrayList<Funcionario> funcionarios;
	private Double orcamento;
	
	public Departamento(String nome, String codigo, Gerente gerente, ArrayList<Funcionario> funcionarios, Double orcamento) {
		this.nome = nome;
		this.codigo = codigo;
		this.gerente = gerente;
		this.funcionarios = funcionarios;
		this.orcamento = orcamento;
	}

	public Gerente getGestor() {
		return gerente;
	}

	public void setGestor(Gerente gerente) {
		this.gerente = gerente;
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
