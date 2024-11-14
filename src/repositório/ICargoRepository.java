package repositório;

import negócios.Cargo;
import negócios.Departamento;

public interface ICargoRepository {
	void adicionarCargo(Cargo novoCargo); // Create
	Cargo acessarCargo(String nome); // Read
	boolean reajusteSalarial(String nome, double novoSalario); // update
	boolean trocaDeDepartamento(String nome, Departamento novoDepartamento); // update
	boolean removerCargo(String nome); // Delete
}
