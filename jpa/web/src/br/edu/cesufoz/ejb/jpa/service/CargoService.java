package br.edu.cesufoz.ejb.jpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.cesufoz.ejb.jpa.entity.Cargo;

/**
 * Session Bean implementation class CargoService
 */
@Stateless
public class CargoService implements CargoServiceLocal {
	
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
		this.em.remove( em.find(Cargo.class, cargoId) );
	}
	
	/**
	 * 
	 */
	public List<Cargo> list() {
		return this.em.createQuery("FROM Cargo c", Cargo.class).getResultList();
	}
}
