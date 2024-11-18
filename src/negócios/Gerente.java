package negócios;

import java.time.LocalDate;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import negócios.Solicitacao.tipoSolicitacao;
import repositório.IGerenciadoRepository;
import repositório.ISolicitacoesRepository;
import repositório.SolicitacoesRepository;

public class Gerente extends Funcionario{
	
	private ISolicitacoesRepository sRepository = new SolicitacoesRepository();
	private IGerenciadoRepository fRepository;
	
    public Gerente(String nome, String cpf, String email, String matricula, Cargo cargo, LocalDate dataAdmissao, StatusFuncionario status, IGerenciadoRepository fRepository) {
    	super(nome, cpf, email, matricula, cargo, dataAdmissao, status);
    	this.fRepository = fRepository;
    }
    

	@Override
	public void pedirDemissao() throws ChaveDuplicadaException {
		getsRepository().adicionar(new Solicitacao(tipoSolicitacao.demissao, this, LocalDate.now(), 0));
	}
	
	@Override
	public void pedirAfastamento(int dias) throws ChaveDuplicadaException {
		getsRepository().adicionar(new Solicitacao(tipoSolicitacao.afastamento, this, LocalDate.now(), dias));
	}
	
	public void cadastrarFuncionario(String nome, String cpf, String email, String matricula, Cargo cargo) throws ChaveDuplicadaException { 
		fRepository.adicionar(new Gerenciado(nome, cpf, email, matricula, cargo, LocalDate.now(), StatusFuncionario.ativo));
	}
	
    void acessarFuncionario(String matricula) throws ElementoInexistenteException {
    	fRepository.buscarPorMatricula(matricula);
    }
    
    void afastarFuncionario(String matricula) throws ElementoInexistenteException {
    	fRepository.buscarPorMatricula(matricula).setStatus(StatusFuncionario.afastado);
    }
    
    void reintegrarFuncionario(String matricula)throws ElementoInexistenteException {
    	fRepository.buscarPorMatricula(matricula).setStatus(StatusFuncionario.ativo);
    }

	public ISolicitacoesRepository getsRepository() {
		return sRepository;
	}
}
