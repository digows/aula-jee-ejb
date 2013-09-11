package br.edu.cesufoz.ejb.jpa.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.cesufoz.ejb.jpa.entity.Cargo;
import br.edu.cesufoz.ejb.jpa.service.CargoServiceLocal;

/**
 * Servlet implementation class CargoServlet
 */
@WebServlet("/cargo")
public class CargoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CargoServiceLocal jpaSampleLocal;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("m");
		final String cargoId = request.getParameter("id");
		
		if ( method == null ) method = "insert"; 	
		
		switch ( method ) {
			case "insert": {
				final Cargo cargo = new Cargo();
				cargo.setNome("Nome");
				cargo.setDescricao("Desricao ");
				
				jpaSampleLocal.save(cargo);
			}
			break;
			case "remove": {
				jpaSampleLocal.remove( Long.valueOf(cargoId) );
			}
			break;
		}
		
		final List<Cargo> cargos = this.jpaSampleLocal.list();
		
		for (Cargo c : cargos) {
			response.getOutputStream().println( c.toString() );			
		}
	}
}
