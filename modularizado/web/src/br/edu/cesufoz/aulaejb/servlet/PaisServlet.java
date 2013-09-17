package br.edu.cesufoz.aulaejb.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.cesufoz.aulaejb.entity.Pais;
import br.edu.cesufoz.aulaejb.service.PaisServiceRemote;

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
		Pais pais = new Pais(null, "Pais "+System.nanoTime());
		pais = this.paisServiceRemote.insert(pais);
		response.getWriter().write("Pais inserido com sucesso! "+pais);
		
		//final List<Pais> paises = this.paisServiceRemote.listByFilters(null);
		//response.getWriter().write(paises.toString());
		
		response.getWriter().flush();
	}
}