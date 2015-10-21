package br.edu.udc.jee.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.udc.jee.entity.Usuario;
import br.edu.udc.jee.service.UsuarioServiceLocal;
import br.edu.udc.jee.service.UsuarioServiceRemote;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioServiceLocal usuarioServiceLocal;
	@EJB
	private UsuarioServiceRemote usuarioServiceRemote;

	protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final Usuario usuario = new Usuario();
		usuario.setNome("Usuario - "+System.currentTimeMillis());
		usuario.setEmail("usuario@email.com");
		this.usuarioServiceLocal.inserirUsuario( usuario );
		
		final List<Usuario> usuarios = this.usuarioServiceRemote.listarUsuarios();
		for ( Usuario usuarioSalvo : usuarios ) {
			response.getWriter().println("<h1>"+usuarioSalvo+"</h1>" );
		}
		
	}
}
