package repositório;

import java.util.ArrayList;
import java.util.List;

import negócios.Cargo;

public class CargoRepository implements ICargoRepository{
	
	private List<Cargo> cargos = new ArrayList<>();
	
	@Override
	public void adicionarCargo(Cargo novoCargo) {
		 cargos.add(novoCargo);
	}

	@Override
	public boolean removerCargo(String nome) {
		Cargo cargoAtual = acessarCargo(nome);
        if (cargoAtual != null) {
            cargos.remove(cargoAtual);
            return true;
        } else {
            return false;
        }
	}

//	@Override
//	void promocao(String matricula) {
//		
//	}

	@Override
	public Cargo acessarCargo(String nome){
		for (Cargo cargoAtual : cargos) {
            if (cargoAtual.getTitulo() == nome) {
                return cargoAtual;
            }
        }
        return null;
	}
}
