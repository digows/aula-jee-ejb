package br.edu.cesufoz.modularizado.service;

import java.util.List;

import javax.ejb.Remote;

import br.edu.cesufoz.modularizado.entity.Pais;

@Remote
public interface PaisServiceRemote {
	public Pais insert( Pais pais );
	public List<Pais> listByFilters( String filter );
}
