package excecoes;

public class SalarioBaixoException extends Exception{
	private double salario;
	public SalarioBaixoException(double s){
		super("O salário: R$ " + s + " está abaixo do mínimo (R$ 1412)");
		this.salario = s;
	}
	
	public double getSalario() {
		return salario;
	}
}
