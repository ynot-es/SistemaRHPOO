package negócios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import excecoes.LimitePromocoes;
import excecoes.ValorIncompativelException;
import negócios.Funcionario.StatusFuncionario;
import negócios.Solicitacao.tipoSolicitacao;
import repositório.CargoRepository;
import repositório.DepartamentoRepository;
import repositório.GerenciadoRepository;
import repositório.GerenteRepository;
import repositório.ICargoRepository;
import repositório.IDepartamentoRepository;
import repositório.IGerenciadoRepository;
import repositório.IGerenteRepository;
import repositório.ISolicitacoesRepository;
import repositório.SolicitacoesRepository;

public class Empresa {
	
	private IGerenciadoRepository fRepository = new GerenciadoRepository();
	private ICargoRepository cRepository = new CargoRepository(); 
	private IGerenteRepository gRepository = new GerenteRepository();
	private IDepartamentoRepository dRepository = new DepartamentoRepository();
	private ISolicitacoesRepository sRepository = new SolicitacoesRepository();
	
	private String nome;
	private List<FolhaPagamento> folhasPagamento;
	private LocalDate fundacao;
	
	public Empresa(String nome, LocalDate fundacao) {
		this.nome = nome;
		this.fundacao = fundacao;
	}
	
	public int getN_Gerenciados() {
		return fRepository.getGerenciados().size();
	}

	public int getN_departamentos() {
		return dRepository.getDepartamentos().size();
	}
	
	public int getN_cargos() {
		return cRepository.getCargos().size();
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
		return fRepository.getGerenciados();
	}

	public List<Cargo> getCargos() {
		return cRepository.getCargos();
	}

	public List<Departamento> getDepartamentos() {
		return dRepository.getDepartamentos();
	}

	public List<FolhaPagamento> getFolhasPagamento() {
		return folhasPagamento;
	}
	
	public List<Solicitacao> getSolicitacoes() {
		return sRepository.getSolicitacoes();
	}

	public List<Gerente> getGerentes() {
		return gRepository.getGerentes();
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
	
	public void cadastrarCargo(String titulo, Double salario, Departamento departamento, Cargo superior) throws ChaveDuplicadaException {
		cRepository.adicionar(new Cargo(titulo, salario, departamento, superior));
	}
	
	public void cadastrarDepartamento(String nome, String codigo, Gerente gerente) throws ChaveDuplicadaException {
		dRepository.adicionar(new Departamento(nome, codigo, gerente));
	}
	
	public void cadastrarGerente(String name, String cpf, String email, String matricula, Cargo cargo) throws ChaveDuplicadaException {
		gRepository.adicionar(new Gerente(name, cpf, email, matricula, cargo, LocalDate.now(), StatusFuncionario.ativo, fRepository, sRepository));
	}
	
	public void removerCargo(String nome) throws ElementoInexistenteException{
		cRepository.remover(nome);
	}
	
	public void demitirGerente(String matricula) throws ElementoInexistenteException{
		fRepository.remover(matricula);
	}
	
	public void removerDepartamento(String code) throws ElementoInexistenteException{
		dRepository.remover(code);
	}
	
	public void reajusteSalarial(String matricula, double novoSalario) throws ValorIncompativelException, ElementoInexistenteException {
		cRepository.reajusteSalarial(matricula, novoSalario);
	}
	
	public void trocaDeDepartamento (String nome, Departamento novoDepartamento) throws ElementoInexistenteException{
		cRepository.trocaDeDepartamento(nome, novoDepartamento);
	}
	
	public void trocarGestor(String code, Gerente novoGestor) throws ElementoInexistenteException{
		dRepository.trocaDeGestor(code, novoGestor);
	}
	
    public void promoverGerenciado(String matricula) throws ElementoInexistenteException, LimitePromocoes{
    	fRepository.promover(matricula);
    }
    
    public Cargo acessarCargo(String nome) throws ElementoInexistenteException {
    	return cRepository.acessar(nome);
    }

    public Departamento acessarDepartamento(String code) throws ElementoInexistenteException {
    	return dRepository.acessar(code);
    }

	public Gerente buscarGerente(String chave) throws ElementoInexistenteException {
		return gRepository.buscarPorMatricula(chave);			
	}
	
	public Gerenciado buscarGerenciado(String chave) throws ElementoInexistenteException {
		return fRepository.buscarPorMatricula(chave);			
	}
	
    public void afastarGerente(String matricula) throws ElementoInexistenteException {
    	gRepository.buscarPorMatricula(matricula).setStatus(StatusFuncionario.afastado);
    }
    
    public void reintegrarGerente(String matricula)throws ElementoInexistenteException {
    	gRepository.buscarPorMatricula(matricula).setStatus(StatusFuncionario.ativo);
    }
    
    public void aprovarSolicitacao(String matricula) throws ElementoInexistenteException {
		Solicitacao solicitacao = sRepository.acessar(matricula);	
		if(solicitacao.getSolicitacao() == tipoSolicitacao.afastamento) {
			afastarGerente(matricula);
		}
		else {
			demitirGerente(matricula);
		}
		sRepository.remover(matricula);
    }
    
    public void negarSolicitacao(String matricula) throws ElementoInexistenteException {
    	sRepository.remover(matricula);
    }
	
}
