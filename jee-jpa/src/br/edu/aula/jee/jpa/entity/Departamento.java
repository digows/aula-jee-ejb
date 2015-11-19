package br.edu.aula.jee.jpa.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Cargo
 */
@Entity
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=true)
	private Departamento departamentoSuperior;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="departamentoSuperior")
	private Set<Departamento> subDepartamentos;
	
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
	public Departamento getDepartamentoSuperior() {
		return departamentoSuperior;
	}
	public void setDepartamentoSuperior(Departamento departamentoSuperior) {
		this.departamentoSuperior = departamentoSuperior;
	}
	public Set<Departamento> getSubDepartamentos() {
		return subDepartamentos;
	}
	public void setSubDepartamentos(Set<Departamento> subDepartamentos) {
		this.subDepartamentos = subDepartamentos;
	}
}