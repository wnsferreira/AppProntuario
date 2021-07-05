package br.edu.infnet.appProntuario.model.domain;

public class Paciente {
	private String nome;
	private String sobrenome;
	private String email;
	
	
	public Paciente(String nome, String sobrenome, String email) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.sobrenome);
		sb.append(";");
		sb.append(this.email);
		
		return sb.toString();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
