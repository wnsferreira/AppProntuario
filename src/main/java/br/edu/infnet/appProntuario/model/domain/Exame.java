package br.edu.infnet.appProntuario.model.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Exame extends Pedido {

	private String tipoExame;
	private LocalDateTime data;
	private String resultado;
	private String particular;
	
	public Exame() {
	}
	
	public Exame(String descricao, float valor, boolean planoDeSaude) {
		super(descricao, valor, planoDeSaude);
		
	}
	
	@Override
	public float calcularValorServico() {
				
		float valorPeloPlano = 0;
		if(this.isPlanoDeSaude()) {
			valorPeloPlano = 20;
			return valorPeloPlano;
		}
		
		return  this.getValor();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()); //mãe
		sb.append(";");
		sb.append(this.tipoExame);
		sb.append(";");
		sb.append(this.data);
		sb.append(";");
//		sb.append(this.horario);
//		sb.append(";");
		sb.append(this.resultado);
		sb.append(";");
		sb.append(calcularValorServico());
		
		return sb.toString();
	}
	
	public String getTipo() {
		return tipoExame;
	}
	public void setTipo(String tipo) {
		this.tipoExame = tipo;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
//	public int getHora() {
//		return horario;
//	}
//	public void setHora(int hora) {
//		this.horario = hora;
//	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}
	
	
	
}
