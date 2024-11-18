package repositório;

import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import excecoes.LimitePromocoes;
import negócios.Funcionario;
import negócios.Funcionario.StatusFuncionario;

public interface IFuncionarioRepository {
	void adicionar(Funcionario funcionario) throws ChaveDuplicadaException; // Create
	Funcionario buscarPorMatricula(String matricula) throws ElementoInexistenteException; // Read
	List<Funcionario> buscarPorDepartamento(String code) throws ElementoInexistenteException; // Read
	List<Funcionario> buscarPorStatus(StatusFuncionario status) throws ElementoInexistenteException; // Read
	List<Funcionario> buscarPorCargo(String nomeCargo) throws ElementoInexistenteException; // Read
    void promover(String matricula) throws ElementoInexistenteException, LimitePromocoes; // Update
    void remover(String matricula) throws ElementoInexistenteException; // Delete
    public List<Funcionario> getFuncionarios(); // Read all
}
