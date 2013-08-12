package br.edu.cesufoz.aulaejb.quick;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UsuarioSessionRemote usuarioSessionRemote;
	@EJB
	private UsuarioSessionLocal usuarioSessionLocal;
	
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
						throws ServletException, IOException {
		this.usuarioSessionRemote.relatorio();
		this.usuarioSessionLocal.salvar();
	}
}
