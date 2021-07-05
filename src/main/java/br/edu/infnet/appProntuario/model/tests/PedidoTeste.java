package br.edu.infnet.appProntuario.model.tests;

import java.text.ParseException;

import br.edu.infnet.appProntuario.model.domain.Atendimento;
import br.edu.infnet.appProntuario.model.domain.Consulta;
import br.edu.infnet.appProntuario.model.domain.Exame;

public class PedidoTeste {

	public static void main(String[] args) throws ParseException {
				
		Exame exm = new Exame("Exame de Sangue", 40, true);
		exm.setHora(9);
		exm.setResultado("dentro dos parâmetros");
		exm.setTipo("A+");		
		System.out.println("Exame: " + exm);
		
		Atendimento atd = new Atendimento("fisioterapia", 55, false);
		atd.setEspecializacao("Medico");
//		atd.setHorariosdisponiveis(14);
		System.out.println("Atendimento: " + atd);
		
		Consulta cons = new Consulta("Pediatra", 150 , false, "20/08/2021");
		//cons.setDataMarcada(22/08/2021);
		cons.setHoraMarcada(15);
		System.out.println("Consulta: " + cons);

	}

}
