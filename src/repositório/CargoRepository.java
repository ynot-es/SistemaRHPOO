package repositório;

import java.util.ArrayList;
import java.util.List;

import negócios.Cargo;
import negócios.Departamento;

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

	@Override
	public boolean reajusteSalarial(String nome, double novoSalario) {
		Cargo cargoAtual = acessarCargo(nome);
		if (cargoAtual != null) {
            cargoAtual.setSalario(novoSalario);
            return true;
        } else {
            return false;
        }
	}
	
	@Override
	public boolean trocaDeDepartamento(String nome, Departamento novoDepartamento) {
		Cargo cargoAtual = acessarCargo(nome);
		if (cargoAtual != null) {
            cargoAtual.setDepartamento(novoDepartamento);
            return true;
        } else {
            return false;
        }
	}

	@Override
	public Cargo acessarCargo(String nome){
		for (Cargo cargoAtual : cargos) {
            if (cargoAtual.getTitulo() == nome) {
                return cargoAtual;
            }
        }
        return null;
	}
	
	@Override
	public List<Cargo> getCargos() {
		return cargos;
	}
}
