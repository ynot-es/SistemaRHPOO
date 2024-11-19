package repositório;

import negócios.Funcionario.StatusFuncionario;
import negócios.Gerenciado;

import java.util.ArrayList;
import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import excecoes.LimitePromocoes;

public class GerenciadoRepository implements IGerenciadoRepository{
	private List<Gerenciado> gerenciados = new ArrayList<>();
	
	@Override
	public void adicionar(Gerenciado gerenciado) throws ChaveDuplicadaException{
		try {
			buscarPorMatricula(gerenciado.getMatricula());
			throw new ChaveDuplicadaException(gerenciado.getMatricula());
		} catch (Exception e) {
			gerenciados.add(gerenciado);
		}
	}

	@Override
	public void remover(String matricula) throws ElementoInexistenteException{
		Gerenciado usuario = buscarPorMatricula(matricula);
        gerenciados.remove(usuario);
	}

	@Override
	public void promover(String matricula) throws ElementoInexistenteException, LimitePromocoes{
		Gerenciado usuario = buscarPorMatricula(matricula);
    	if(usuario.getCargo().getSuperior() != null) {
	        usuario.setCargo(usuario.getCargo().getSuperior());
    	}
    	else {
    		throw new LimitePromocoes(usuario.getCargo().getTitulo());
    	}
	}

	@Override
	public Gerenciado buscarPorMatricula(String matricula) throws ElementoInexistenteException{
		 for (Gerenciado usuario : gerenciados) {
			 System.out.println(usuario.getMatricula() + " x " + matricula);
			 if (usuario.getMatricula().equals(matricula)) {
                return usuario;
			 }
		 }
		 throw new ElementoInexistenteException();
	}
	
	@Override
	public List<Gerenciado> buscarPorDepartamento(String code) throws ElementoInexistenteException{
		List<Gerenciado> gerenciadosPD = new ArrayList<>();
		for (Gerenciado usuario : gerenciados) {
            if (usuario.getCargo().getDepartamento().getCodigo().equals(code)){
                gerenciadosPD.add(usuario);
            }
        }
		throw new ElementoInexistenteException();
	}

	@Override
	public List<Gerenciado> buscarPorStatus(StatusFuncionario status) throws ElementoInexistenteException{
		List<Gerenciado> gerenciadosPS = new ArrayList<>();
		for (Gerenciado usuario : gerenciados) {
            if (usuario.getStatus() == status){
                gerenciadosPS.add(usuario);
            }
        }
		throw new ElementoInexistenteException();
	}
	
	@Override
	public List<Gerenciado> buscarPorCargo(String nomeCargo) throws ElementoInexistenteException{
		List<Gerenciado> gerenciadosPS = new ArrayList<>();
		for (Gerenciado usuario : gerenciados) {
            if (usuario.getCargo().getTitulo().equals(nomeCargo)){
                gerenciadosPS.add(usuario);
            }
        }
		throw new ElementoInexistenteException();
	}
	
	@Override
	public List<Gerenciado> getGerenciados() {
		return gerenciados;
	}	
	
}

