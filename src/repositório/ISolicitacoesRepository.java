package repositório;

import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import negócios.Solicitacao;

public interface ISolicitacoesRepository {
	void adicionar(Solicitacao novaSolicitacao) throws ChaveDuplicadaException; // Create
	Solicitacao acessar(String nome) throws ElementoInexistenteException; // Read
	void remover(String nome) throws ElementoInexistenteException; // Delete
	List<Solicitacao> getSolicitacoes();
}
