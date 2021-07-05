package br.edu.infnet.appProntuario.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Prontuario {
	private String descricao;
	private String receitas;
	private String relatorio;
	private Paciente paciente;
	private LocalDateTime dataRegistro;
	
	
	public Prontuario() {
		dataRegistro = LocalDateTime.now();
	}
		
	public Prontuario(String descricao, String receitas, String relatorio) {
		this();
		this.descricao = descricao;
		this.receitas = receitas;
		this.relatorio = relatorio;
	}
	
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return String.format("%s;%s;%s;%s;%s",
				this.descricao,
				this.receitas,
				this.relatorio,
				this.paciente,
				this.dataRegistro.format(formato)
				);
		
	}
	
	public String obterProntuario() {
		return String.format("PRONTUARIO \r Paciente %s %s \r Atendido no dia %s.\r\r",
				this.paciente.getNome(),
				this.paciente.getSobrenome(),
				this.dataRegistro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
				);
	}
	
	public String getExame() {
		return descricao;
	}

	public void setExame(String exame) {
		this.descricao = exame;
	}

	public String getReceitas() {
		return receitas;
	}

	public void setReceitas(String receitas) {
		this.receitas = receitas;
	}

	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
}
