package negócios;

public class Cargo {
    private String titulo;          
    private double salario;
    private Departamento departamento;
    private Cargo pai = null;

    public Cargo(String titulo, Double salario, Departamento departamento) {
        this.titulo = titulo;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
    public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Cargo getPai() {
		return pai;
	}


	public void setPai(Cargo pai) {
		this.pai = pai;
	}

	@Override
	public String toString() {
		return "Cargo [titulo=" + titulo + ", salario=" + salario + "]";
	}

	

}
