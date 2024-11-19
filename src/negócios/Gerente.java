package negócios;

import java.time.LocalDate;
import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import negócios.Solicitacao.tipoSolicitacao;
import repositório.IGerenciadoRepository;
import repositório.ISolicitacoesRepository;
import repositório.SolicitacoesRepository;

public class Gerente extends Funcionario{
	
	private ISolicitacoesRepository sRepository = new SolicitacoesRepository();
	private IGerenciadoRepository fRepository;
	private ISolicitacoesRepository EsRepository;
	
    public Gerente(String nome, String cpf, String email, String matricula, Cargo cargo, LocalDate dataAdmissao, StatusFuncionario status, IGerenciadoRepository fRepository, ISolicitacoesRepository EsRepository) {
    	super(nome, cpf, email, matricula, cargo, dataAdmissao, status);
    	this.fRepository = fRepository;
    	this.EsRepository = EsRepository;
    }
    
	@Override
	public void pedirDemissao() throws ChaveDuplicadaException {
		EsRepository.adicionar(new Solicitacao(tipoSolicitacao.demissao, this, LocalDate.now(), 0));
	}
	
	@Override
	public void pedirAfastamento(int dias) throws ChaveDuplicadaException {
		EsRepository.adicionar(new Solicitacao(tipoSolicitacao.afastamento, this, LocalDate.now(), dias));
	}
	
	public void cadastrarFuncionario(String nome, String cpf, String email, String matricula, Cargo cargo) throws ChaveDuplicadaException { 
		fRepository.adicionar(new Gerenciado(nome, cpf, email, matricula, cargo, LocalDate.now(), StatusFuncionario.ativo, sRepository));
	}
	
	public void demitirFuncionario(String matricula) throws ElementoInexistenteException {
		fRepository.remover(matricula);
	}
	
    public void acessarFuncionario(String matricula) throws ElementoInexistenteException {
    	fRepository.buscarPorMatricula(matricula);
    }
    
    public void afastarFuncionario(String matricula) throws ElementoInexistenteException {
    	fRepository.buscarPorMatricula(matricula).setStatus(StatusFuncionario.afastado);
    }
    
    public void reintegrarFuncionario(String matricula)throws ElementoInexistenteException {
    	fRepository.buscarPorMatricula(matricula).setStatus(StatusFuncionario.ativo);
    }
    
    public void aprovarSolicitacao(String matricula) throws ElementoInexistenteException {
		Solicitacao solicitacao = sRepository.acessar(matricula);	
		if(solicitacao.getSolicitacao() == tipoSolicitacao.afastamento) {
			afastarFuncionario(matricula);
		}
		else {
			demitirFuncionario(matricula);
		}
		sRepository.remover(matricula);
    }
    
    public void negarSolicitacao(String matricula) throws ElementoInexistenteException {
    	sRepository.remover(matricula);
    }
    
	public List<Solicitacao> getSolicitacoes() {
		return sRepository.getSolicitacoes();
	}
}
