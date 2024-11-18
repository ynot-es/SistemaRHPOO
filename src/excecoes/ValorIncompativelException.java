package excecoes;

public class ValorIncompativelException extends Exception {
	public ValorIncompativelException(Number val) {
		super("O valor: " + val + " não pode ser passado como parametro para esse método.");
	}
}
