package negócios;

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
	private Data dataInicio;
	private Data dataFim;
	
	public Beneficios(TipoBeneficio tipo, double valor, Data dataInicio, Data dataFim) {	
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

	public Data getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Data dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Data getDataFim() {
		return dataFim;
	}

	public void setDataFim(Data dataFim) {
		this.dataFim = dataFim;
	}
	
	
}
