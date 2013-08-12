package br.edu.cesufoz.aulaejb.quick;

import javax.ejb.Local;

@Local
public interface UsuarioSessionLocal {
	
	public void salvar();
	public void remove();
	public void list();
}