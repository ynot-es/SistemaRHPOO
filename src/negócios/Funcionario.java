package negócios;

import java.time.LocalDate;
import java.util.ArrayList;



public class Funcionario extends Pessoa {
	
	public enum StatusFuncionario{
		ativo, ferias, afastado, desligado;
	}

	private String matricula;
    private Cargo cargo;
    private LocalDate dataAdmissao;
    private ArrayList<Beneficios> beneficios;
    private StatusFuncionario status; // ativo, férias, afastado, desligado

    public Funcionario(String nome, String cpf, String matricula, String email, Cargo cargo, LocalDate dataAdmissao) {
        super(nome, cpf, email);
        this.cargo = cargo; 
        this.matricula = matricula;
        this.dataAdmissao = dataAdmissao;
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

	public LocalDate getDataAdmissao() {
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
		return "Funcionario [matricula=" + matricula + ", cargo=" + cargo + ", dataAdmissao=" + dataAdmissao
				+ ", beneficios=" + beneficios + ", status=" + status + ", nome=" + nome + ", cpf=" + cpf + ", email="
				+ email + "]";
	}


}
