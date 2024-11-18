package negócios;

import java.time.LocalDate;
import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import excecoes.LimitePromocoes;
import excecoes.ValorIncompativelException;
import repositório.CargoRepository;
import repositório.DepartamentoRepository;
import repositório.GerenciadoRepository;
import repositório.ICargoRepository;
import repositório.IDepartamentoRepository;
import repositório.IGerenciadoRepository;

public class Empresa {
	
	private IGerenciadoRepository fRepository = new GerenciadoRepository();
	private ICargoRepository cRepository = new CargoRepository(); 
	private IDepartamentoRepository dRepository = new DepartamentoRepository();
	
	private List<Gerenciado> Gerenciados = fRepository.getGerenciados();
	private List<Cargo> cargos = cRepository.getCargos();
	private List<Departamento> departamentos = dRepository.getDepartamentos();
	
	private String nome;
	private int n_Gerenciados;
	private int n_departamentos;
	private int n_cargos;
	private List<FolhaPagamento> folhasPagamento;
	private LocalDate fundacao;
	
	public Empresa(String nome, LocalDate fundacao) {
		this.nome = nome;
		this.fundacao = fundacao;
	}
	
	public int getN_Gerenciados() {
		return n_Gerenciados;
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

	public List<Gerenciado> getGerenciados() {
		return Gerenciados;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}
	
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}
	
	public void pagarGerenciados(int mes, int ano, Cargo cargoAtual) throws ElementoInexistenteException, ValorIncompativelException { // DEIXAR MAIS COMPLEXO DEPOIS.
		double valor = cargoAtual.getSalario() + fRepository.buscarPorCargo(cargoAtual.getTitulo()).size();
		for (FolhaPagamento fp : folhasPagamento) {
			if(fp.getAno() == ano) {
				if (fp.getMes() == mes) {
					fp.IncrementarValor(valor);
				}
			}
		}	
		FolhaPagamento folhaPagamento = new FolhaPagamento(mes, ano, null, valor);
		folhasPagamento.add(folhaPagamento);
	}
	
	public void cadastrarCargo(Cargo novoCargo) throws ChaveDuplicadaException {
		cRepository.adicionar(novoCargo);
		n_cargos += 1;
	}
	
	public void cadastrarDepartamento(Departamento novoDepartamento) throws ChaveDuplicadaException {
		dRepository.adicionar(novoDepartamento);
		n_departamentos += 1;
	}
	
	public void removerCargo(String nome) throws ElementoInexistenteException{
		n_cargos -= 1;
		cRepository.remover(nome);
	}
	
	public void removerGerenciado(String matricula) throws ElementoInexistenteException{
		n_cargos -= 1;
		fRepository.remover(matricula);
	}

	public void removerDepartamento(String code) throws ElementoInexistenteException{
		n_cargos -= 1;
		dRepository.remover(code);
	}
	
	public void reajusteSalarial(String matricula, double novoSalario) throws ValorIncompativelException, ElementoInexistenteException {
		cRepository.reajusteSalarial(matricula, novoSalario);
	}
	
	public void trocaDeDepartamento (String nome, Departamento novoDepartamento) throws ElementoInexistenteException{
		cRepository.trocaDeDepartamento(nome, novoDepartamento);
	}
	
	void trocarGestor(String code, Gerenciado novoGestor) throws ElementoInexistenteException{
		dRepository.trocaDeGestor(code, novoGestor);
	}
	
    void promoverGerenciado(String matricula) throws ElementoInexistenteException, LimitePromocoes{
    	fRepository.promover(matricula);
    }
    
    void acessarCargo(String nome) throws ElementoInexistenteException {
    	cRepository.acessar(nome);
    }
	

    void acessarDepartamento(String code) throws ElementoInexistenteException {
    	dRepository.acessar(code);
    }
    
    
    
}
