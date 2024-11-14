package repositório;

import negócios.Cargo;

public interface ICargoRepository {
	void adicionarCargo(Cargo novoCargo); // Create
	Cargo acessarCargo(String nome); // Read
	// update
	boolean removerCargo(String nome);
}
