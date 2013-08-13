package br.edu.cesufoz.aulaejb.quick;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class UsuarioSession
 */
@Stateless
public class UsuarioSession implements 
							UsuarioSessionRemote, 
							UsuarioSessionLocal {
    
    @Override
    public void salvar() {
    	System.out.println("Usuario Salvo com sucesso. ");
    }

	@Override
	public void remove() {
		System.out.println("Usuario removido com sucesso.");
	}

	@Override
	public void list() {
		System.out.println("Listando usuarios...");
	}

	@Override
	public void relatorio() {
		System.out.println("Relatórios de usuários.");
	}
}
