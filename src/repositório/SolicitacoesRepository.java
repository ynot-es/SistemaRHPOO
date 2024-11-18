package repositório;

import java.util.ArrayList;
import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import excecoes.ValorIncompativelException;
import negócios.Solicitacao;
import negócios.Departamento;

public class SolicitacoesRepository implements ISolicitacoesRepository{
	
	private List<Solicitacao> solicitacoes = new ArrayList<>();
	
	@Override
	public void adicionar(Solicitacao novaSolicitacao) throws ChaveDuplicadaException{
		try {
			acessar(novaSolicitacao.getSolicitante().getMatricula());
			throw new ChaveDuplicadaException(novaSolicitacao.getSolicitante().getMatricula());
		}
		catch(ElementoInexistenteException e) {
			solicitacoes.add(novaSolicitacao);
		}
	}

	@Override
	public void remover(String matricula) throws ElementoInexistenteException{
		Solicitacao solicitacaoAtual = acessar(matricula);
        solicitacoes.remove(solicitacaoAtual);
	}

	@Override
	public Solicitacao acessar(String matricula) throws ElementoInexistenteException{
		for (Solicitacao solicitacaoAtual : solicitacoes) {
            if (solicitacaoAtual.getSolicitante().getMatricula().equals(matricula)) {
                return solicitacaoAtual;
            }
        }
		throw new ElementoInexistenteException();
	}
	
	@Override
	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}
}
