package br.edu.cesufoz.aulaejb.session;

import javax.ejb.Remote;

@Remote
public interface PaisServiceRemote {
	public String dizerOlaMundo();
}
