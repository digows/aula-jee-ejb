package br.edu.cesufoz.ejb.jpa.service.bmt;

import java.util.List;

import javax.ejb.Remote;

import br.edu.cesufoz.ejb.jpa.entity.Cargo;

/**
 * Session Bean implementation class CargoService
 */
@Remote
public interface BMTServiceRemote {
	public void insertSemCommit() throws Exception;
	public void rollbackTest() throws Exception;
	public void transactionOK() throws Exception;
	public List<Cargo> list();
}
