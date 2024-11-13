package negócios;

import java.util.ArrayList;

import repositório.FuncionarioRepository;
import repositório.IFuncionarioRepository;


public class Funcionario extends Pessoa {
	IFuncionarioRepository funcRepositorio = new FuncionarioRepository();
	public enum StatusFuncionario{
		ativo, ferias, afastado, desligado;
	}
	
	private String matricula;
    private Cargo cargo;
    private Data dataAdmissao;
    private Double salarioBase;
    private ArrayList<Beneficios> beneficios;
    private StatusFuncionario status; //Ativo, férias, afastado
	
    public Funcionario(String nome, String cpf, String email, Cargo cargo, StatusFuncionario status) {
        super(nome, cpf, email);
        this.cargo = cargo; 
        this.salarioBase = cargo.getSalario(); 
        this.status = status;
    }

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
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

    public double getSalario() {
        return salarioBase;
    }

    public void setSalario(double salario) {
        this.salarioBase = salario;
    }
    
    public StatusFuncionario getStatus() {
        return this.status;
    }
    
    public void pedirDemissao() {
    	funcRepositorio.remover(this.matricula);
    }
    
    @Override
    public String toString() {
        return "Funcionario [nome:" + this.getNome() + ", cpf:" + this.getCpf() + ", cargo:" + this.getCargo()+", nome:" + this.getNome() + ", salario=" + this.getSalario() + "]";
    }
}
