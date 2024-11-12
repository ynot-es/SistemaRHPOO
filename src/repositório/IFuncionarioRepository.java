package repositório;

public interface IFuncionarioRepository {
	void salvar(Funcionario funcionario);
    Funcionario buscarPorMatricula(String matricula);
    List<Funcionario> buscarPorDepartamento(Departamento depto);
    List<Funcionario> buscarPorStatus(StatusFuncionario status);
}
