package br.edu.cesufoz.ejb.jpa.service.bmt;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import br.edu.cesufoz.ejb.jpa.entity.Cargo;

/**
 * Session Bean implementation class CargoService
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class BMTService implements BMTServiceRemote {

	/**
	 * 
	 */
	@PersistenceContext
	private EntityManager em;
	
	@Resource 
	private UserTransaction tx;
	
	public void insertSemCommit() throws Exception {
		tx.begin();
		
		Cargo c = new Cargo();
		c.setNome("Meu Cargo de Tx");
		
		em.persist( c );
	}
	public void rollbackTest() throws Exception {
		tx.begin();
		
		Cargo c = new Cargo();
		c.setNome("Meu Cargo de Tx");
		em.persist( c );
		em.persist( c );
		em.persist( c );
		
		tx.rollback();
	}
	public void transactionOK() throws Exception {
		tx.begin();
		
		Cargo c = new Cargo();
		c.setNome("Meu Cargo de Tx");
		
		em.persist( c );
		tx.commit();
	}
	/**
	 * 
	 */
	public List<Cargo> list() {
		return this.em.createQuery("FROM Cargo c", Cargo.class).getResultList();
	}
}
