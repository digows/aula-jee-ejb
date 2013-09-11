package br.edu.cesufoz.ejb.jpa.service.cmt;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.cesufoz.ejb.jpa.entity.Cargo;

/**
 * Session Bean implementation class CargoService
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NEVER)
public class CMTService implements CMTServiceRemote {

	/**
	 * 
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void rollbackTest() {
		Cargo cargo = new Cargo();
		cargo.setNome("Cargo 1");
		this.em.persist(cargo);

		cargo = new Cargo();
		cargo.setNome("Cargo 2");
		this.em.persist(cargo);

		cargo = new Cargo();
		cargo.setNome("Cargo 3");
		this.em.persist(cargo);

		// Rollback
		throw new IllegalAccessError("Nao foi possivel inserir");
	}
	
	/**
	 * 
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void requiredToRequireNewTest() {
		System.out.println("requiredToRequireNewTest");
		this.requireNewTest();
	}
	
	/**
	 * 
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	private void requireNewTest() {
		System.out.println("requireNewTest");
	}
	
	/**
	 * 
	 */
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void mandatoryTest() {
		System.out.println("mandatoryTest");
	}
	
	/**
	 * 
	 */
	public List<Cargo> list() {
		return this.em.createQuery("FROM Cargo c", Cargo.class).getResultList();
	}
}
