package negócios;

import java.util.ArrayList;



public class Funcionario extends Pessoa {
	
	public enum StatusFuncionario{
		ativo, ferias, afastado, desligado;
	}
	
	private String matricula;
    private Cargo cargo;
    private Data dataAdmissao;
    private ArrayList<Beneficios> beneficios;
    private StatusFuncionario status; // ativo, férias, afastado, desligado
	
    public Funcionario(String nome, String cpf, String email, Cargo cargo, StatusFuncionario status) {
        super(nome, cpf, email);
        this.cargo = cargo; 
        this.status = status;
    }


	public ArrayList<Beneficios> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(ArrayList<Beneficios> beneficios) {
		this.beneficios = beneficios;
	}

	public String getMatricula() {
		return matricula;
	}

	public Data getDataAdmissao() {
		return dataAdmissao;
	}

	public void setStatus(StatusFuncionario status) {
		this.status = status;
	}

	public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public StatusFuncionario getStatus() {
        return this.status;
    }
    
    @Override
    public String toString() { 
        return "Funcionario [nome:" + this.getNome() + ", cpf:" + this.getCpf() + ", cargo:" + this.getCargo()+", nome:" + this.getNome() + "]";
    }
}
