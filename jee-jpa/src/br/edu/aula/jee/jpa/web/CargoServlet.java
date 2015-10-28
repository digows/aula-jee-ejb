package br.edu.aula.jee.jpa.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.aula.jee.jpa.entity.Cargo;
import br.edu.aula.jee.jpa.service.CargoService;

/**
 * Servlet implementation class CargoServlet
 */
@WebServlet("/cargo")
public class CargoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CargoService cargoService;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("m");
		
		if ( method == null ) method = "insert"; 	
		
		switch ( method ) {
			case "insert": {
				final Cargo cargo = new Cargo();
				cargo.setNome("Nome");
				
				this.cargoService.save(cargo);
			}
			break;
			case "remove": {
				final String cargoId = request.getParameter("id");
				this.cargoService.remove( Long.valueOf(cargoId) );
			}
			break;
		}
		
		final List<Cargo> cargos = this.cargoService.list();
		
		for (Cargo c : cargos) {
			response.getOutputStream().println( c.toString() );			
		}
	}
}
