package br.edu.aula.jee.jpa.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.aula.jee.jpa.entity.Departamento;

/**
 */
@Stateless
public class DepartamentoService {
	
	/**
	 * 
	 */
	@PersistenceContext
    private EntityManager em;
	
	public Departamento insert( Departamento departamento ) {
		this.em.persist(departamento);
		return departamento;
	}
	
	public Departamento findById( Long departamentoId ) {
		return this.em.find(Departamento.class, departamentoId);
	}
}
