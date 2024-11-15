package negócios;

import java.time.LocalDate;
import java.util.List;

import repositório.CargoRepository;
import repositório.FuncionarioRepository;
import repositório.ICargoRepository;
import repositório.IFuncionarioRepository;

public class Empresa {
	
	private IFuncionarioRepository fRepository = new FuncionarioRepository();
	private ICargoRepository cRepository = new CargoRepository(); 
	
	private List<Funcionario> funcionarios = fRepository.getFuncionarios();
	private List<Cargo> cargos = cRepository.getCargos();
	private String nome;
	private int n_funcionarios;
	private int n_departamentos;
	private int n_cargos;
	private FolhaPagamento folhaPagamento;
	private LocalDate fundacao;
	
	public Empresa(String nome, int n_funcionarios, int n_cargos, int n_departamentos, FolhaPagamento folhaPagamento, LocalDate fundacao) {
		this.nome = nome;
		this.n_funcionarios = n_funcionarios;
		this.n_departamentos = n_departamentos;
		this.n_cargos = n_cargos;
		this.folhaPagamento = folhaPagamento;
		this.fundacao = fundacao;
	}

	public int getN_funcionarios() {
		return n_funcionarios;
	}

	public void setN_funcionarios(int n_funcionarios) {
		this.n_funcionarios = n_funcionarios;
	}

	public int getN_departamentos() {
		return n_departamentos;
	}

	public void setN_departamentos(int n_departamentos) {
		this.n_departamentos = n_departamentos;
	}

	public int getN_cargos() {
		return n_cargos;
	}

	public void setN_cargos(int n_cargos) {
		this.n_cargos = n_cargos;
	}

	public FolhaPagamento getFolhaPagamento() {
		return folhaPagamento;
	}

	public void setFolhaPagamento(FolhaPagamento folhaPagamento) {
		this.folhaPagamento = folhaPagamento;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getFundacao() {
		return fundacao;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	
	
}
