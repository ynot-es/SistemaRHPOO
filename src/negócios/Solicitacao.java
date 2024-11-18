package negócios;

import java.time.LocalDate;

public class Solicitacao {
	public enum tipoSolicitacao{
		afastamento, promocao, demissao;
	}
	
	tipoSolicitacao solicitacao;
	Funcionario solicitante;
	LocalDate data;
	int diasAfastamento;
	
	public Solicitacao(tipoSolicitacao solicitacao, Funcionario solicitante, LocalDate data, int diasAfastamento) {
		this.solicitacao = solicitacao;
		this.solicitante = solicitante;
		this.data = data;
		this.diasAfastamento = diasAfastamento;
	}
	
	public tipoSolicitacao getSolicitacao() {
		return solicitacao;
	}

	public LocalDate getData() {
		return data;
	}

	public int getDiasAfastamento() {
		return diasAfastamento;
	}

	public Funcionario getSolicitante() {
		return solicitante;
	}

}
