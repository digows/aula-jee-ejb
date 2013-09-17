package br.edu.cesufoz.modularizado.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.cesufoz.modularizado.entity.Pais;
import br.edu.cesufoz.modularizado.service.PaisServiceRemote;

/**
 * Session Bean implementation class PaisService
 */
@Stateless
public class PaisService implements PaisServiceRemote {

	/**
	 * 
	 */
	@PersistenceContext
    private EntityManager em;
	
	/**
	 * 
	 */
	@Override
	public Pais insert( Pais pais ) {
		this.em.persist( pais );
		return pais;
	}
	
	@Override
	public List<Pais> listByFilters( String filter ) {
		final TypedQuery<Pais> query = this.em.createNamedQuery("pais.listByFilters", Pais.class);
		query.setParameter("filter", filter);
		return query.getResultList();
	}
}
