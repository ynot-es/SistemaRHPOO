package repositório;

import java.util.ArrayList;
import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import excecoes.SalarioBaixoException;
import negócios.Cargo;
import negócios.Departamento;

public class CargoRepository implements ICargoRepository{
	
	private List<Cargo> cargos = new ArrayList<>();
	
	@Override
	public void adicionar(Cargo novoCargo) throws ChaveDuplicadaException{
		try {
			acessar(novoCargo.getTitulo());
			throw new ChaveDuplicadaException(novoCargo.getTitulo());
		}
		catch(ElementoInexistenteException e) {
			cargos.add(novoCargo);
		}
	}

	@Override
	public void remover(String nome) throws ElementoInexistenteException{
		Cargo cargoAtual = acessar(nome);
        cargos.remove(cargoAtual);
	}

	@Override
	public void reajusteSalarial(String nome, double novoSalario) throws SalarioBaixoException, ElementoInexistenteException{
		Cargo cargoAtual = acessar(nome);
		if (novoSalario < 1412) throw new SalarioBaixoException(novoSalario);
		cargoAtual.setSalario(novoSalario);
	}
	
	@Override
	public void trocaDeDepartamento (String nome, Departamento novoDepartamento) throws ElementoInexistenteException{
		Cargo cargoAtual = acessar(nome);
		cargoAtual.setDepartamento(novoDepartamento);
	}

	@Override
	public Cargo acessar(String nome) throws ElementoInexistenteException{
		for (Cargo cargoAtual : cargos) {
            if (cargoAtual.getTitulo().equals(nome)) {
                return cargoAtual;
            }
        }
		throw new ElementoInexistenteException();
	}
	
	@Override
	public List<Cargo> getCargos() {
		return cargos;
	}
}
