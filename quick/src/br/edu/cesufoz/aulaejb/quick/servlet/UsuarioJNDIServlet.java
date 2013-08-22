package br.edu.cesufoz.aulaejb.quick.servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.cesufoz.aulaejb.quick.session.UsuarioSessionRemote;

/**
 * 
 */
@WebServlet("/usuario/jndi")
public class UsuarioJNDIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
						throws ServletException, IOException {
		try {
			
			final Context context = new InitialContext();
			
			//EAR
	        final String appName = "";
	        //Modulo do EAR (ejb, war, jar)
	        final String moduleName = "ejb-quick.web";
	        // JBoss AS7 possibilita adicionar nomes customizados.
	        final String distinctName = "";
	        //Nome da implementacao EJB
	        final String beanName = "UsuarioSession";
	        //Nome completo da interface remota
	        final String viewClassName = UsuarioSessionRemote.class.getName();
	        final String componentName = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
	        
	        //faz o lookup
	        final UsuarioSessionRemote usuarioSessionRemote = (UsuarioSessionRemote) context.lookup(componentName);
			usuarioSessionRemote.relatorio();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
