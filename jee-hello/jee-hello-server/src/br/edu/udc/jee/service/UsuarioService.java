package br.edu.udc.jee.service;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

import br.edu.udc.jee.entity.Usuario;

@Stateless
public class UsuarioService implements UsuarioServiceLocal, UsuarioServiceRemote {
	
	private static List<Usuario> usuarios = new LinkedList<>();
	
	@Override
	public Usuario inserirUsuario( Usuario usuario ) {
		usuario.setCriacao( Calendar.getInstance() );
		usuarios.add(usuario);
		return usuario;
	}

	@Override
	public Usuario alterarUsuario( Usuario usuario ) {
		System.out.println("Usuario "+usuario.getNome()+" ALTERADO com sucesso!");
		return usuario;
	}

	@Override
	public void removerUsuario( Usuario usuario ) {
		System.out.println("Usuario "+usuario.getNome()+" REMOVIDO com sucesso!");
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarios;
	}
}
