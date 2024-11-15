package repositório;

import negócios.Funcionario;
import negócios.Funcionario.StatusFuncionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository implements IFuncionarioRepository{
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	@Override
	public void salvar(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}

	@Override
	public boolean remover(String matricula) {
		Funcionario usuario = buscarPorMatricula(matricula);
        if (usuario != null) {
            funcionarios.remove(usuario);
            return true;
        } else {
            return false;
        }
	}

	@Override
	public boolean promover(String matricula) {
		Funcionario usuario = buscarPorMatricula(matricula);
        if (usuario != null) {
        	if(usuario.getCargo().getPai() != null) {
		        usuario.setCargo(usuario.getCargo().getPai());
		        return true;
        	}
        	else {
        		return false;
        	}
        } else {
            return false;
        }
	}

	@Override
	public Funcionario buscarPorMatricula(String matricula){
		 for (Funcionario usuario : funcionarios) {
			 System.out.println(usuario.getMatricula() + " x " + matricula);
			 if (usuario.getMatricula().equals(matricula)) {
                return usuario;
			 }
		 }
		 return null;
	}
	
	@Override
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	@Override
	public List<Funcionario> buscarPorDepartamento(String code){
		List<Funcionario> FuncionariosPD = new ArrayList<>();
		for (Funcionario usuario : funcionarios) {
            if (usuario.getCargo().getDepartamento().getCodigo().equals(code)){
                FuncionariosPD.add(usuario);
            }
        }
		return FuncionariosPD;
	}

	@Override
	public List<Funcionario> buscarPorStatus(StatusFuncionario status){
		List<Funcionario> FuncionariosPS = new ArrayList<>();
		for (Funcionario usuario : funcionarios) {
            if (usuario.getStatus() == status){
                FuncionariosPS.add(usuario);
            }
        }
		return FuncionariosPS;
	}
	
	@Override
	public List<Funcionario> buscarPorCargo(String nomeCargo) {
		List<Funcionario> FuncionariosPS = new ArrayList<>();
		for (Funcionario usuario : funcionarios) {
            if (usuario.getCargo().getTitulo().equals(nomeCargo)){
                FuncionariosPS.add(usuario);
            }
        }
		return FuncionariosPS;
	}
	
	
}
