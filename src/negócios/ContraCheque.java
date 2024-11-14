package negócios;

public class ContraCheque {
	private Funcionario funcionario;
	private Data dataEmissao;
	private Double total;
	
	public ContraCheque(Funcionario funcionario, Data dataEmissao, double total){
		this.funcionario = funcionario;
		this.dataEmissao = dataEmissao;
		this.total = total;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Data getDataEmissao() {
		return dataEmissao;
	}

	public Double getTotal() {
		return total;
	}
	
	
}
