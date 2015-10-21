package br.edu.udc.jee.entity;

import java.io.Serializable;
import java.util.Calendar;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 3794642318245205660L;
	
	private String email;
	private String nome;
	private Calendar dataCriacao; 
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getCriacao() {
		return dataCriacao;
	}
	public void setCriacao(Calendar dataNascimento) {
		this.dataCriacao = dataNascimento;
	}
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nome=" + nome + "]";
	}
}
