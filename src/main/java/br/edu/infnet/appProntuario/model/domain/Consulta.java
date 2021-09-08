package br.edu.infnet.appProntuario.model.domain;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Consulta extends Pedido {

	private String dataMarcada;
	private int horaMarcada;  //Exibir uma lista de horarios disponiveis
	private String convenio;
	
	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
	public Consulta(String descricao, float valor, boolean planoDeSaude, String dataMarcada) throws ParseException {
		
		super(descricao, valor, planoDeSaude);
		//this.dataMarcada = dataMarcada.formatted(formatoData);
			
	}
	
//	@Override
//	public String toString() {
//		
//	
//		StringBuilder sb = new StringBuilder();
//		sb.append(super.toString()); //mãe
//		sb.append(";");
//		sb.append(this.dataMarcada);
//		sb.append(";");
//		sb.append(this.horaMarcada);
//		sb.append(";");
//		sb.append(this.convenio);
//		sb.append(";");
//		sb.append(calcularValorServico());
//		
//		return sb.toString();
//	}

	public String obterConsulta() {
		return String.format("CONSULTA \r Data marcada: %s \r Convênio: %s \r Valor R$: %s\r\r",
				this.dataMarcada,
				this.convenio,
				this.calcularValorServico()
				);
	}



	public String getDataMarcada() {
		return dataMarcada;
	}

	public void setDataMarcada(String dataMarcada) {
		this.dataMarcada = dataMarcada;
	}

	public int getHoraMarcada() {
		return horaMarcada;
	}

	public void setHoraMarcada(int horaMarcada) {
		this.horaMarcada = horaMarcada;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	@Override
	public float calcularValorServico() {
		
		float valorPeloPlano = 0;
		if(this.isPlanoDeSaude()) {
			valorPeloPlano = 60;
			return valorPeloPlano;
		}
		
		return  this.getValor();
		
	}
	
	
}
