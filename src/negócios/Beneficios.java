package negócios;

import java.time.LocalDate;

public class Beneficios {
	
	public enum TipoBeneficio {
	    VALE_REFEICAO,
	    VALE_TRANSPORTE,
	    PLANO_SAUDE,
	    PLANO_DENTAL,
	    AUXILIO_CRECHE
	} 

	private TipoBeneficio tipo;
	private Double valor;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	
	public Beneficios(TipoBeneficio tipo, double valor, LocalDate dataInicio, LocalDate dataFim) {	
		this.tipo = tipo;
		this.valor = valor;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public TipoBeneficio getTipo() {
		return tipo;
	}

	public void setTipo(TipoBeneficio tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	
}
