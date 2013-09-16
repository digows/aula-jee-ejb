package br.edu.cesufoz.aulaejb.service;

import java.util.List;

import javax.ejb.Remote;

import br.edu.cesufoz.aulaejb.entity.Pais;

@Remote
public interface PaisServiceRemote {
	public Pais insert( Pais pais );
	public List<Pais> listByFilters( String filter );
}
