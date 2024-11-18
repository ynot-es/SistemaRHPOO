package negócios;

import java.time.LocalDate;

import excecoes.ChaveDuplicadaException;
import negócios.Solicitacao.tipoSolicitacao;

public class Gerenciado extends Funcionario {
	
    public Gerenciado(String nome, String cpf, String email, String matricula, Cargo cargo, LocalDate dataAdmissao, StatusFuncionario status) {
    	super(nome, cpf, email, matricula, cargo, dataAdmissao, status);
    }

	@Override
	public void pedirDemissao() throws ChaveDuplicadaException {
		this.getCargo().getDepartamento().getGestor().getsRepository().adicionar(new Solicitacao(tipoSolicitacao.demissao, this, LocalDate.now(), 0));
	}

	@Override
	public void pedirAfastamento(int dias) throws ChaveDuplicadaException {
		this.getCargo().getDepartamento().getGestor().getsRepository().adicionar(new Solicitacao(tipoSolicitacao.afastamento, this, LocalDate.now(), dias));
	}

}
