package excecoes;

public class ChaveDuplicadaException extends Exception{
	public ChaveDuplicadaException(String chave) {
		super("A chave " + chave + " já existe");
	}
	public ChaveDuplicadaException(double chave) {
		super("A chave " + chave + " já existe");
	}
}
