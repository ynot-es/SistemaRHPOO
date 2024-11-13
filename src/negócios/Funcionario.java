package negócios;

public class Funcionario extends Pessoa {
	
	private Cargo cargo;
	private double salario;
	
    public Funcionario(String nome, String cpf, String email, Cargo cargo) {
        super(nome, cpf, email);
        this.cargo = cargo;
        this.salario = cargo.getSalarioBase(); 
    }
    
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario [nome:" + this.getNome() + ", cpf:" + this.getCpf() + ", cargo:" + this.getCargo()+", nome:" + this.getNome() + ", salario=" + this.getSalario() + "]";
    }
}
