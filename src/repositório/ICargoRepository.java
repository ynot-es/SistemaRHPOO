package repositório;

import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import excecoes.ValorIncompativelException;
import negócios.Cargo;
import negócios.Departamento;

public interface ICargoRepository {
	void adicionar(Cargo novoCargo) throws ChaveDuplicadaException; // Create
	Cargo acessar(String nome) throws ElementoInexistenteException; // Read
	void reajusteSalarial(String nome, double novoSalario) throws ValorIncompativelException, ElementoInexistenteException; // update
	void trocaDeDepartamento (String nome, Departamento novoDepartamento) throws ElementoInexistenteException; // update
	void remover(String nome) throws ElementoInexistenteException; // Delete
	List<Cargo> getCargos();
}
