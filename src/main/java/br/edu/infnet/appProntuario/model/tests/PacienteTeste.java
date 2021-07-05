package br.edu.infnet.appProntuario.model.tests;

import br.edu.infnet.appProntuario.model.domain.Paciente;

public class PacienteTeste {

	public static void main(String[] args) {
		
		Paciente pct = new Paciente("Paulo", "Silva", "paulo@gmail.com");
		
		System.out.println("Paciente: " + pct);

	}

}
