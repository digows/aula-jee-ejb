package br.edu.cesufoz.aulaejb.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.cesufoz.aulaejb.session.PaisServiceRemote;

/**
 * Servlet implementation class PaisServlet
 */
@WebServlet("/pais")
public class PaisServlet extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7952780687870167894L;
	
	@EJB
	private PaisServiceRemote paisServiceRemote;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String mensagem = paisServiceRemote.dizerOlaMundo();
		response.getWriter().write(mensagem);
		response.getWriter().flush();
	}

}
