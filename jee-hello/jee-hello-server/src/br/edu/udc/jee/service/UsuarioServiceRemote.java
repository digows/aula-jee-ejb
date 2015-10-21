package br.edu.udc.jee.service;

import java.util.List;

import javax.ejb.Remote;

import br.edu.udc.jee.entity.Usuario;

@Remote
public interface UsuarioServiceRemote {
	public List<Usuario> listarUsuarios();
}
