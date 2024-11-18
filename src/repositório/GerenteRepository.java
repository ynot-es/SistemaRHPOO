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
	public void promover(String matricula) throws ElementoInexistenteException, LimitePromocoes{
		Gerente usuario = buscarPorMatricula(matricula);
    	if(usuario.getCargo().getPai() != null) {
	        usuario.setCargo(usuario.getCargo().getPai());
    	}
    	else {
    		throw new LimitePromocoes(usuario.getCargo().getTitulo());
    	}
	}

	@Override
	public Gerente buscarPorMatricula(String matricula) throws ElementoInexistenteException{
		 for (Gerente usuario : gerentes) {
			 System.out.println(usuario.getMatricula() + " x " + matricula);
			 if (usuario.getMatricula().equals(matricula)) {
                return usuario;
			 }
		 }
		 throw new ElementoInexistenteException();
	}
	
	@Override
	public List<Gerente> buscarPorDepartamento(String code) throws ElementoInexistenteException{
		List<Gerente> gerentesPD = new ArrayList<>();
		for (Gerente usuario : gerentes) {
            if (usuario.getCargo().getDepartamento().getCodigo().equals(code)){
                gerentesPD.add(usuario);
            }
        }
		throw new ElementoInexistenteException();
	}

	@Override
	public List<Gerente> getGerentes() {
		return gerentes;
	}	
	
}

