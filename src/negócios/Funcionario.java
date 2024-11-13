package negócios;

import java.util.ArrayList;

public class Funcionario extends Pessoa {
	
	private String matricula;
    private Departamento departamento;
    private Cargo cargo;
    private Data dataAdmissao;
    private Double salarioBase;
    private ArrayList<Beneficios> beneficios;
    private StatusFuncionario status; //Ativo, férias, afastado
	
    public Funcionario(String nome, String cpf, String email, Cargo cargo) {
        super(nome, cpf, email);
        this.cargo = cargo;
        this.salarioBase = cargo.getSalarioBase(); 
    }
    
    public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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
    
    public void getStatus() {
        return this.status;
    }
    
    
    
    @Override
    public String toString() {
        return "Funcionario [nome:" + this.getNome() + ", cpf:" + this.getCpf() + ", cargo:" + this.getCargo()+", nome:" + this.getNome() + ", salario=" + this.getSalario() + "]";
    }
}
