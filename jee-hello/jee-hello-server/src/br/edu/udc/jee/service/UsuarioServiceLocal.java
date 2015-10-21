package br.edu.udc.jee.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.udc.jee.entity.Usuario;

@Local
public interface UsuarioServiceLocal {
	public Usuario inserirUsuario( Usuario usuario );
	public Usuario alterarUsuario( Usuario usuario );
	public void removerUsuario( Usuario usuario );
	public List<Usuario> listarUsuarios();
}
