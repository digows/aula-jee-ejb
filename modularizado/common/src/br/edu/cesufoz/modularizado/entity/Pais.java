package br.edu.cesufoz.modularizado.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Entity implementation class for Entity: Pais
 */
@Entity
@NamedQueries({
		@NamedQuery(name="pais.listByFilters", query="SELECT p FROM Pais p " +
													  "WHERE LOWER(p.nome) LIKE '%' || LOWER(:filter) || '%' OR :filter = NULL")
	}
)
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Calendar dataCriacao;
	private Calendar dataAlteracao;

	public Pais() {
	}

	public Pais(Long id) {
		this.id = id;
	}
	
	public Pais(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nome=" + nome + "]";
	}

	@PreUpdate
	@PrePersist
	private void refresh() {
		if (id == null) {
			this.setDataCriacao(Calendar.getInstance());
		}
		this.setDataAlteracao(Calendar.getInstance());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
}
