package negócios;

import java.util.List;

public class FolhaPagamento {
	private int mes;
	private int ano;
	private List<ContraCheque> contraCheques;
	private Double totalGasto;
	
	public FolhaPagamento(int mes, int ano, List<ContraCheque> contraCheques, Double totalGasto) {
		this.mes =  mes;
		this.ano = ano;
		this.contraCheques = contraCheques;
		this.totalGasto = totalGasto;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public List<ContraCheque> getContraCheques() {
		return contraCheques;
	}

	public Double getTotalGasto() {
		return totalGasto;
	}
	
}
