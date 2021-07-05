package br.edu.infnet.appProntuario.model.tests;

import br.edu.infnet.appProntuario.model.domain.Paciente;
import br.edu.infnet.appProntuario.model.domain.Prontuario;

public class ProntuarioTeste {

	public static void main(String[] args) {
		
		Paciente pac = new Paciente("Joao", "silva", "joao@gmail");
		//System.out.println(pac);
		
		Prontuario pront = new Prontuario("Sangue","dipirona","paciente regular");
		pront.setPaciente(pac);
		System.out.println("Prontuario 1: " + pront);
 
		Prontuario pront2 = new Prontuario("Urina","dipirona","paciente regular");
		pront2.setPaciente(pac);
		System.out.println("Prontuario 2: " + pront2);
	}

}
