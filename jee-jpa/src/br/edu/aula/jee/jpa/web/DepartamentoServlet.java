package br.edu.aula.jee.jpa.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.aula.jee.jpa.entity.Departamento;
import br.edu.aula.jee.jpa.service.DepartamentoService;

/**
 * Servlet implementation class CargoServlet
 */
@WebServlet("/departamento")
public class DepartamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DepartamentoService departamentoService;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Departamento diretoria = new Departamento();
		diretoria.setNome("Diretoria");
		this.departamentoService.insert(diretoria);
		
		Departamento financeiro = new Departamento();
		financeiro.setDepartamentoSuperior(diretoria);
		financeiro.setNome("Financeiro");
		this.departamentoService.insert(financeiro);

		//-----------
		diretoria = this.departamentoService.findById(diretoria.getId());
		System.out.println(diretoria.getNome());
		diretoria.getSubDepartamentos().forEach( 
			sub -> System.out.println(sub.getNome()) 
		);
		
		financeiro = this.departamentoService.findById(financeiro.getId());
		System.out.println(financeiro.getNome());
		System.out.println(financeiro.getDepartamentoSuperior().getNome());
		
	}
}
