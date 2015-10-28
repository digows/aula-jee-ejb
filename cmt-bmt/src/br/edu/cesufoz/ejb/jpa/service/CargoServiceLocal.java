package br.edu.cesufoz.ejb.jpa.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.cesufoz.ejb.jpa.entity.Cargo;

@Local
public interface CargoServiceLocal {
	public Cargo save( Cargo cargo );
	public List<Cargo> list();
	public void remove( long cargoId );
}
