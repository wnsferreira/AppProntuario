package br.edu.infnet.appProntuario.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.appProntuario.model.exceptions.HonoraiosNaoPreenchidosException;


@Entity
public class Atendimento extends Pedido {
	
	private String especializacao;
	private String nomeProfissional;
	private float honorario;
	private float tempoAtendimento;
	
	public Atendimento() {
		
	}
	
	public Atendimento(String descricao, float valor, boolean planoDeSaude) {
		super(descricao, valor, planoDeSaude);
		
	}

	public String obterAtendimento() throws HonoraiosNaoPreenchidosException {
		return String.format("ATENDIMENTO \r Profissional: %s \r Nome do profissional: %s\r Tempo de atendimento: %.2f h\r Honoraio/hora: R$: %s\r Total: R$: %s \r\r",
				this.especializacao,
				this.nomeProfissional,
				this.tempoAtendimento,
				this.honorario,
				this.calcularValorServico()
				);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ATENDIMENTO\r");
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.especializacao);
		sb.append(";");
		sb.append(this.nomeProfissional);
		sb.append(";");
		sb.append(this.tempoAtendimento);
		sb.append(";");
		sb.append(this.honorario);
		sb.append(";");
		//sb.append(calcularValorServico());
		
		return sb.toString();
	}

		
	
	@Override
	public float calcularValorServico() throws HonoraiosNaoPreenchidosException {
		
		if(this.honorario == 0) {
			throw new HonoraiosNaoPreenchidosException("O valor do honorário não pode ser zero.");
		}if(this.honorario <= 0) {
			throw new HonoraiosNaoPreenchidosException("O valor do honorário não pode ser negativo!");
		}
		
		return this.getHonorario()*this.getTempoAtendimento();
	}
	
	public float getTempoAtendimento() {
		return tempoAtendimento;
	}


	public void setTempoAtendimento(float tempoAtendimento) {
		this.tempoAtendimento = tempoAtendimento;
	}


	public String getEspecializacao() {
		return especializacao;
	}
	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}
	
	public String getNomeProfissional() {
		return nomeProfissional;
	}


	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}


	public float getHonorario() {
		return honorario;
	}
	public void setHonorario(float honorario) {
		this.honorario = honorario;
	}
	
	
	
}
