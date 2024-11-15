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
	private List<FolhaPagamento> folhasPagamento;
	private LocalDate fundacao;
	
	public Empresa(String nome, LocalDate fundacao) {
		this.nome = nome;
		this.fundacao = fundacao;
	}

	public int getN_funcionarios() {
		return n_funcionarios;
	}

	public int getN_departamentos() {
		return n_departamentos;
	}
	
	public int getN_cargos() {
		return n_cargos;
	}

	public List<FolhaPagamento> getFolhaPagamento() {
		return folhasPagamento;
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

	public List<Cargo> getCargos() {
		return cargos;
	}
	
	public void pagarFuncionarios(int mes, int ano) { // DEIXAR MAIS COMPLEXO DEPOIS.
		double valor = 0;
		for (Cargo cargoAtual : cargos) {			
			valor += cargoAtual.getSalario() + fRepository.buscarPorCargo(cargoAtual.getTitulo()).size();
		}
		FolhaPagamento folhaPagamento = new FolhaPagamento(mes, ano, null, valor);
		folhasPagamento.add(folhaPagamento);
	}
	
	public void cadastrarCargo(Cargo novoCargo) {
		cRepository.adicionarCargo(novoCargo);
		n_cargos += 1;
	}
	
	public void cadastrarFuncionario(Funcionario novoFuncionario) {
		fRepository.salvar(novoFuncionario);
		n_funcionarios += 1;
	}
	
	public boolean removerCargo(String nome){
		n_cargos -= 1;
		return cRepository.removerCargo(nome);

	}
}
