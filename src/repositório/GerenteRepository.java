package repositório;

import negócios.Gerente;

import java.util.ArrayList;
import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import excecoes.LimitePromocoes;

public class GerenteRepository implements IGerenteRepository{
	private List<Gerente> gerentes = new ArrayList<>();
	
	@Override
	public void adicionar(Gerente gerente) throws ChaveDuplicadaException{
		try {
			buscarPorMatricula(gerente.getMatricula());
			throw new ChaveDuplicadaException(gerente.getMatricula());
		} catch (Exception e) {
			gerentes.add(gerente);
		}
	}

	@Override
	public void remover(String matricula) throws ElementoInexistenteException{
		Gerente usuario = buscarPorMatricula(matricula);
        gerentes.remove(usuario);
	}

	@Override
	public Gerente buscarPorMatricula(String matricula) throws ElementoInexistenteException{
		for (Gerente usuario : gerentes) {
			if (usuario.getMatricula().equals(matricula)) {
				return usuario;
			}
		}
		throw new ElementoInexistenteException();
	}
	
	@Override
	public List<Gerente> getGerentes() {
		return gerentes;
	}	
	
}

