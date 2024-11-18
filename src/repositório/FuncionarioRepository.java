package repositório;

import negócios.Funcionario;
import negócios.Funcionario.StatusFuncionario;

import java.util.ArrayList;
import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import excecoes.LimitePromocoes;

public class FuncionarioRepository implements IFuncionarioRepository{
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	@Override
	public void adicionar(Funcionario funcionario) throws ChaveDuplicadaException{
		try {
			buscarPorMatricula(funcionario.getMatricula());
			throw new ChaveDuplicadaException(funcionario.getMatricula());
		} catch (Exception e) {
			funcionarios.add(funcionario);
		}
	}

	@Override
	public void remover(String matricula) throws ElementoInexistenteException{
		Funcionario usuario = buscarPorMatricula(matricula);
        funcionarios.remove(usuario);
	}

	@Override
	public void promover(String matricula) throws ElementoInexistenteException, LimitePromocoes{
		Funcionario usuario = buscarPorMatricula(matricula);
    	if(usuario.getCargo().getPai() != null) {
	        usuario.setCargo(usuario.getCargo().getPai());
    	}
    	else {
    		throw new LimitePromocoes(usuario.getCargo().getTitulo());
    	}
	}

	@Override
	public Funcionario buscarPorMatricula(String matricula) throws ElementoInexistenteException{
		 for (Funcionario usuario : funcionarios) {
			 System.out.println(usuario.getMatricula() + " x " + matricula);
			 if (usuario.getMatricula().equals(matricula)) {
                return usuario;
			 }
		 }
		 throw new ElementoInexistenteException();
	}
	
	@Override
	public List<Funcionario> buscarPorDepartamento(String code) throws ElementoInexistenteException{
		List<Funcionario> FuncionariosPD = new ArrayList<>();
		for (Funcionario usuario : funcionarios) {
            if (usuario.getCargo().getDepartamento().getCodigo().equals(code)){
                FuncionariosPD.add(usuario);
            }
        }
		throw new ElementoInexistenteException();
	}

	@Override
	public List<Funcionario> buscarPorStatus(StatusFuncionario status) throws ElementoInexistenteException{
		List<Funcionario> FuncionariosPS = new ArrayList<>();
		for (Funcionario usuario : funcionarios) {
            if (usuario.getStatus() == status){
                FuncionariosPS.add(usuario);
            }
        }
		throw new ElementoInexistenteException();
	}
	
	@Override
	public List<Funcionario> buscarPorCargo(String nomeCargo) throws ElementoInexistenteException{
		List<Funcionario> FuncionariosPS = new ArrayList<>();
		for (Funcionario usuario : funcionarios) {
            if (usuario.getCargo().getTitulo().equals(nomeCargo)){
                FuncionariosPS.add(usuario);
            }
        }
		throw new ElementoInexistenteException();
	}
	
	@Override
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}	
	
}

