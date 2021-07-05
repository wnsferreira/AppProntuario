package br.edu.infnet.appProntuario.model.domain;

import br.edu.infnet.appProntuario.model.exceptions.HonoraiosNaoPreenchidosException;

public abstract class Pedido {
	
	private String descricao;
	private float valor;
	private float valorPlanoSaude;
	private boolean planoDeSaude;
		
	
	public Pedido( String descricao,float valor, boolean planoDeSaude) {
	
		this.descricao = descricao;
		this.valor =valor;
		this.planoDeSaude = planoDeSaude;
	}
	
	
	public String solicitarPedido() throws HonoraiosNaoPreenchidosException {
		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.planoDeSaude?"S":"N");
		sb.append(";");
		sb.append(this.calcularValorServico());
		sb.append("\r\n");
		
		return sb.toString();
	}
	
	@Override
	public String toString()  {
		
					
		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.valor);
		sb.append(";");
		sb.append(this.planoDeSaude ? "S" : "N");
		sb.append(";");
		sb.append(this.valorPlanoSaude);		
		
		return sb.toString();
	}
	
	public abstract float calcularValorServico() throws HonoraiosNaoPreenchidosException;

	public String getDescricao() {
		return descricao;
	}


	public float getValor() {
		return valor;
	}


	public float getValorPlanoSaude() {
		return valorPlanoSaude;
	}


	public boolean isPlanoDeSaude() {
		return planoDeSaude;
	}

	
	
}
