package telas;

import java.time.LocalDate;

import negócios.Empresa;
import negócios.Endereco;

public class GerenciarEmpresa {

	public static void main(String[] args) {
		Empresa minhaEmpresa = new Empresa("Empresa de esportes", LocalDate.now());
		TelaInicial telaInicial = new TelaInicial(minhaEmpresa);
		telaInicial.iniciar();
	}
}
