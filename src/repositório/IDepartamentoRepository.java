package repositório;

import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import negócios.Departamento;
import negócios.Gerente;

public interface IDepartamentoRepository {
	void adicionar(Departamento novoDepartamento) throws ChaveDuplicadaException; // Create
	Departamento acessar(String code) throws ElementoInexistenteException; // Read
	void trocaDeGestor(String code, Gerente novoGestor) throws ElementoInexistenteException; // update
	void remover(String code) throws ElementoInexistenteException; // Delete
	List<Departamento> getDepartamentos();
}
