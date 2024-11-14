package repositório;

import java.util.List;
import negócios.Funcionario;
import negócios.Funcionario.StatusFuncionario;

public interface IFuncionarioRepository {
	public abstract void salvar(Funcionario funcionario); // Create
    Funcionario buscarPorMatricula(String matricula); // Read
    boolean promover(String matricula); // Update
    boolean remover(String matricula); // Delete
    public List<Funcionario> getFuncionarios();
    public List<Funcionario> buscarPorDepartamento(String code); // Read
    public List<Funcionario> buscarPorStatus(StatusFuncionario status); // Read
    public List<Funcionario> buscarPorCargo(String nomeCargo); // Read
}
