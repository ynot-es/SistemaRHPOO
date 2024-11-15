package negócios;

import java.time.LocalDate;

public class ContraCheque {
	private Funcionario funcionario;
	private LocalDate dataEmissao;
	private Double total;
	
	public ContraCheque(Funcionario funcionario, LocalDate dataEmissao, double total){
		this.funcionario = funcionario;
		this.dataEmissao = dataEmissao;
		this.setTotal(total);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}
