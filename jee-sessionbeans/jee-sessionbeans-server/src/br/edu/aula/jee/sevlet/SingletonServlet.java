package br.edu.aula.jee.sevlet;

import java.io.IOException;
import java.util.Random;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.aula.jee.sessionbeans.Termometro;

/**
 * Servlet implementation class SingletonServlet
 */
@WebServlet("/singleton")
public class SingletonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Termometro termometro;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Temperatura atual: "+this.termometro.getTemperatura());
		this.termometro.setTemperatura( new Random().nextFloat() );
	}
}
