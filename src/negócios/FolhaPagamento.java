package negócios;

import java.util.List;

import excecoes.ValorIncompativelException;

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

	public void IncrementarValor(double valor) throws ValorIncompativelException {
		if(valor > 0) {
			totalGasto += valor;
		}
		else {
			throw new ValorIncompativelException(valor);
		}
	}
	
	@Override
	public String toString() {
		return "FolhaPagamento [mes=" + mes + ", ano=" + ano + ", contraCheques=" + contraCheques + ", totalGasto="
				+ totalGasto + "]";
	}
	
	
	
}
