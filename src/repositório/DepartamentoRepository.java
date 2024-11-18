package repositório;

import java.util.ArrayList;
import java.util.List;

import excecoes.ChaveDuplicadaException;
import excecoes.ElementoInexistenteException;
import negócios.Departamento;
import negócios.Gerente;

public class DepartamentoRepository implements IDepartamentoRepository{
	
	private List<Departamento> departamentos = new ArrayList<>();
	
	@Override
	public void adicionar(Departamento novoDepartamento) throws ChaveDuplicadaException{
		try {
			acessar(novoDepartamento.getCodigo());
			throw new ChaveDuplicadaException(novoDepartamento.getCodigo());
		}
		catch (ElementoInexistenteException e) {
			departamentos.add(novoDepartamento);			
		}
	}

	@Override
	public void remover(String code) throws ElementoInexistenteException{
		Departamento departamentoAtual = acessar(code);
		departamentos.remove(departamentoAtual);
	}
	
	@Override
	public void trocaDeGestor(String code, Gerente novoGestor) throws ElementoInexistenteException{
		Departamento departamentoAtual = acessar(code);
        departamentoAtual.setGestor(novoGestor);
	}

	@Override
	public Departamento acessar(String code) throws ElementoInexistenteException{
		for (Departamento departamentoAtual : departamentos) {
            if (departamentoAtual.getCodigo().equals(code)) {
                return departamentoAtual;
            }
        }
        throw new ElementoInexistenteException();
	}
	
	@Override
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}
}
