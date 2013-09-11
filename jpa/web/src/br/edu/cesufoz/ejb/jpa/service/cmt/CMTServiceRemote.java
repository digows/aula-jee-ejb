package br.edu.cesufoz.ejb.jpa.service.cmt;

import java.util.List;

import javax.ejb.Remote;

import br.edu.cesufoz.ejb.jpa.entity.Cargo;

/**
 * Session Bean implementation class CargoService
 */
@Remote
public interface CMTServiceRemote {
	public void rollbackTest();
	public void requiredToRequireNewTest();
	public void mandatoryTest();
	public List<Cargo> list();
}
