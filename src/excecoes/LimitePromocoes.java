package excecoes;

public class LimitePromocoes extends Exception {
	public LimitePromocoes(String cargo) {
		super("O cargo máximo que esse funcionário pode ser promovido foi atingido (" + cargo + ")");
	}
}
