package negócios;

public class Departamento {
	private String nome;
	private String codigo;
	private Gerente gerente;
	
	public Departamento(String nome, String codigo, Gerente gerente) {
		this.nome = nome;
		this.codigo = codigo;
		this.gerente = gerente;
	}

	public Gerente getGestor() {
		return gerente;
	}

	public void setGestor(Gerente gerente) {
		this.gerente = gerente;
	}


	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}
}
