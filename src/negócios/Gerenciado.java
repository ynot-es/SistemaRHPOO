package negócios;

import java.time.LocalDate;

import excecoes.ChaveDuplicadaException;
import negócios.Solicitacao.tipoSolicitacao;
import repositório.ISolicitacoesRepository;

public class Gerenciado extends Funcionario {
	
    private ISolicitacoesRepository sRepository;
    
    public Gerenciado(String nome, String cpf, String email, String matricula, Cargo cargo, LocalDate dataAdmissao, StatusFuncionario status, ISolicitacoesRepository sRepository) {
    	super(nome, cpf, email, matricula, cargo, dataAdmissao, status);
    	this.sRepository = sRepository;
    }

	@Override
	public void pedirDemissao() throws ChaveDuplicadaException {
		sRepository.adicionar(new Solicitacao(tipoSolicitacao.demissao, this, LocalDate.now(), 0));
	}

	@Override
	public void pedirAfastamento(int dias) throws ChaveDuplicadaException {
		sRepository.adicionar(new Solicitacao(tipoSolicitacao.afastamento, this, LocalDate.now(), dias));
	}
}
