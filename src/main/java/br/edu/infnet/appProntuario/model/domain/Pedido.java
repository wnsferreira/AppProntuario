package br.edu.infnet.appProntuario.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.edu.infnet.appProntuario.model.exceptions.HonoraiosNaoPreenchidosException;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pedido {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private float valor;
	private float valorPlanoSaude;
	private boolean planoDeSaude;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@ManyToMany(mappedBy = "pedidos")
	private List<Prontuario> prontuarios;
		
	public Pedido() {
		
	}
	
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
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<Prontuario> prontuarios) {
		this.prontuarios = prontuarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setValorPlanoSaude(float valorPlanoSaude) {
		this.valorPlanoSaude = valorPlanoSaude;
	}

	public void setPlanoDeSaude(boolean planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
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
