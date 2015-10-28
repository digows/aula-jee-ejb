package br.edu.cesufoz.ejb.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Entity implementation class for Entity: Cargo
 * 
 */
@Entity
public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Calendar dataCriacao;
	private Calendar dataAlteracao;
	
	public Cargo() {
	}
	
	public Cargo( Long id ) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao +"]";
	}

	@PreUpdate
	@PrePersist
	private void refresh() {
		if (id == null) {
			this.setDataCriacao(Calendar.getInstance());
		}
		this.setDataAlteracao(Calendar.getInstance());
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataAlteracao() {
		return this.dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
}