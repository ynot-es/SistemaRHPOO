package negócios;

abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected String email;
	protected Endereco endereco;
	
	public Pessoa(String nome, String cpf, String email) {
		this.nome= nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public void AtualizarDados(String nome, String email) {
		this.nome =  nome;
		this.email = email;
	}
	
	public void AtualizarEndereco(Endereco novoEndereco) {
		this.endereco = novoEndereco;
	}
	
}

