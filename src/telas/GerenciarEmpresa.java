package telas;

import negócios.Empresa;

public class GerenciarEmpresa {

	public static void main(String[] args) {
		Empresa minhaEmpresa = new Empresa("Empresa de esportes", null);
		TelaInicial telaInicial = new TelaInicial(minhaEmpresa);
		telaInicial.iniciar();
	}

}
