package negócios;

public class Cargo {
    private String titulo;          
    private double salario;
    private Departamento departamento;

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

	@Override
    public String toString() {
        return "Cargo{" +
                "titulo=" + this.titulo + '\'' +
                ", salario=" + this.salario;
    }

}
