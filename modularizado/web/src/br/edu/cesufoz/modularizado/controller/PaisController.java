package br.edu.cesufoz.modularizado.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.cesufoz.modularizado.entity.Pais;
import br.edu.cesufoz.modularizado.service.PaisServiceRemote;

@ViewScoped
@ManagedBean
public class PaisController 
{
	@EJB
	private PaisServiceRemote paisServiceRemote;
	private Pais pais = new Pais();
	private List<Pais> paises;
	
	//
	public String changeToList() {
		return "/pais/pais-list.jsf?faces-redirect=true";
	}
	public void listByFilters( String filter ) {
		this.paises = this.paisServiceRemote.listByFilters(filter);
	}
	
	//
	public String changeToInsert() {
		return "/pais/pais-form.jsf?faces-redirect=true";
	}
	public String insert() {
		this.paisServiceRemote.insert(pais);
		return "/pais/pais-list.jsf?faces-redirect=true";
	}
	
	//
	public PaisServiceRemote getPaisServiceRemote() {
		return paisServiceRemote;
	}
	public void setPaisServiceRemote(PaisServiceRemote paisServiceRemote) {
		this.paisServiceRemote = paisServiceRemote;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public List<Pais> getPaises() {
		return paises;
	}
	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}
}
