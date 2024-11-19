package repositório;

import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import excecoes.LimitePromocoes;
import negócios.Gerente;

public interface IGerenteRepository {
	void adicionar(Gerente Gerente) throws ChaveDuplicadaException; // Create
	Gerente buscarPorMatricula(String matricula) throws ElementoInexistenteException; // Read
    void remover(String matricula) throws ElementoInexistenteException; // Delete
    public List<Gerente> getGerentes(); // Read all
}
