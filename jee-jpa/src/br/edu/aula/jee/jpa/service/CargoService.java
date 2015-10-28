package br.edu.aula.jee.jpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.aula.jee.jpa.entity.Cargo;

/**
 * Session Bean implementation class Bootstrap
 */
@Stateless
public class CargoService {
	
	/**
	 * 
	 */
	@PersistenceContext
    private EntityManager em;
	
	/**
	 * 
	 */
	public Cargo save( Cargo cargo ) {
		this.em.merge( cargo );
		return cargo;
	}
	
	/**
	 * 
	 */
	public void remove( long cargoId ) {
		final Cargo cargo = em.find(Cargo.class, cargoId); 
		if ( cargo != null ) {
			this.em.remove( cargo );
		}
	}
	
	/**
	 * 
	 */
	public List<Cargo> list() {
		return this.em.createQuery("FROM Cargo c", Cargo.class).getResultList();
	}
}
