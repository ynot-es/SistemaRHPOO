package repositório;

import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import excecoes.LimitePromocoes;
import negócios.Funcionario.StatusFuncionario;
import negócios.Gerenciado;

public interface IGerenciadoRepository {
	void adicionar(Gerenciado gerenciado) throws ChaveDuplicadaException; // Create
	Gerenciado buscarPorMatricula(String matricula) throws ElementoInexistenteException; // Read
	List<Gerenciado> buscarPorDepartamento(String code) throws ElementoInexistenteException; // Read
	List<Gerenciado> buscarPorStatus(StatusFuncionario status) throws ElementoInexistenteException; // Read
	List<Gerenciado> buscarPorCargo(String nomeCargo) throws ElementoInexistenteException; // Read
    void promover(String matricula) throws ElementoInexistenteException, LimitePromocoes; // Update
    void remover(String matricula) throws ElementoInexistenteException; // Delete
    public List<Gerenciado> getGerenciados(); // Read all
}
