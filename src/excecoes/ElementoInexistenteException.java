package excecoes;

public class ElementoInexistenteException extends Exception {
	public ElementoInexistenteException(){
		super("O elemento que procura não existe");
	}
}
