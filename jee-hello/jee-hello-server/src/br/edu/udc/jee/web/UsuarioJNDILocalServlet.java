package br.edu.udc.jee.web;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.udc.jee.service.UsuarioServiceLocal;

/**
 * 
 */
@WebServlet("/usuario/jndi/local")
public class UsuarioJNDILocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
						throws ServletException, IOException {
		try {
			final Context context = new InitialContext();
			final String ejb = "UsuarioService";
			final String interfaceLocal = "br.edu.udc.jee.service.UsuarioServiceLocal";
			final String jndi = "java:module/"+ejb+"!"+interfaceLocal;
			
	        //faz o lookup
			final UsuarioServiceLocal usuarioServiceLocal = (UsuarioServiceLocal) context.lookup(jndi);
	        System.out.println( usuarioServiceLocal.listarUsuarios() );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
