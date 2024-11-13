package negócios;

public class Pessoa {
	protected String nome;
	protected String cpf;
	protected String email;
	protected Endereco endereco;
	
	public Pessoa(String nome, String cpf, String email) {
		this.nome= nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	
	public void setEndereco(Endereco novoEndereco) {
		this.endereco = novoEndereco;
	}
	
    public String getNome() {
        return nome;  
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
	@Override
	public String toString() {
		return "Pessoa [nome:" + this.getNome() + ", cpf:" + this.getCpf() + ", email:"+this.getEmail()+"]";
	}
}

