package negócios;

abstract class Pessoa {
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	
	public Pessoa(String nome, String cpf,String email) {
		this.nome= nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public void AtualizarDados(String nome, String email) {
		this.nome =  nome;
		this.email = email;
	}
	
}

