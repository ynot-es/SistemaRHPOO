package repositório;

import negócios.Funcionario;
import negócios.Funcionario.StatusFuncionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FuncionarioRepository implements IFuncionarioRepository{
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	@Override
	public void salvar(Funcionario funcionario) {
		 funcionarios.add(funcionario);
	     System.out.println("Usuário cadastrado: " + funcionario.getNome());
	}
//
//	@Override
//	public void remover(String nome) {
//		 User usuario = consultar(nome);
//	        if (usuario != null) {
//	            funcionarios.remove(usuario);
//	            System.out.println("Usuário removido: " + usuario.getNome());
//	        } else {
//	            System.out.println("Usuário não existe.");
//	        }
//	}

//	@Override
//	void promocao(String matricula) {
//		
//	}

	@Override
	public Funcionario buscarPorMatricula(String matricula){
		 for (Funcionario usuario : funcionarios) {
	            if (usuario.getMatricula() == matricula) {
	                return usuario;
	            }
	        }
	        return null;
	}
	
	@Override
	public List<Funcionario> buscarPorDepartamento(String code){
		List<Funcionario> FuncionariosPD = new ArrayList<>();
		for (Funcionario usuario : funcionarios) {
            if (usuario.getDepartamento().getCodigo() == code){
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
	
//	@Override
//	public List<User> lerTodos() {
//		return new ArrayList<>(funcionarios);
//	}
}
