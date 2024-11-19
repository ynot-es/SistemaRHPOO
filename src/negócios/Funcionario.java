package negócios;

import java.time.LocalDate;

import excecoes.ChaveDuplicadaException;
import repositório.ISolicitacoesRepository;

public abstract class Funcionario extends Pessoa{

	public enum StatusFuncionario{
		ativo, ferias, afastado;
	}

	private String matricula;
    private Cargo cargo;
    private LocalDate dataAdmissao;

	private StatusFuncionario status; // ativo, férias, afastado
    
    public Funcionario(String nome, String cpf, String email, String matricula, Cargo cargo, LocalDate dataAdmissao, StatusFuncionario status) {
		super(nome, cpf, email);
		this.setCargo(cargo);
		this.matricula = matricula;
		this.dataAdmissao = dataAdmissao;
		this.status = status;
	}
    
	public abstract void pedirDemissao() throws ChaveDuplicadaException;
    
    public abstract void pedirAfastamento(int dias) throws ChaveDuplicadaException;

	public String getMatricula() {
		return matricula;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	
    public StatusFuncionario getStatus() {
		return status;
	}

	public void setStatus(StatusFuncionario status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Funcionario [matricula=" + getMatricula() + ", cargo=" + getCargo() + ", dataAdmissao=" + getDataAdmissao()
				+ ", status=" + status + ", nome=" + nome + ", cpf=" + cpf + ", email="
				+ email + "]";
	}
}
