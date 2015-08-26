package br.edu.cesufoz.modularizado.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.cesufoz.modularizado.entity.Pais;
import br.edu.cesufoz.modularizado.service.PaisServiceRemote;

@ViewScoped
@ManagedBean
public class PaisController 
{
	private PaisServiceRemote paisServiceRemote;
	private Pais pais = new Pais();
	private List<Pais> paises;
	
	public PaisController() throws NamingException {
		final Context context = new InitialContext();
		
		//EAR
        final String appName = "ejb-modularizado.ear";
        //Modulo do EAR (ejb, war, jar)
        final String moduleName = "ejb-modularizado.ejb";
        // JBoss AS7 possibilita adicionar nomes customizados.
        final String distinctName = "";
        //Nome da implementacao EJB
        final String beanName = "PaisService";
        //Nome completo da interface remota
        final String viewClassName = PaisServiceRemote.class.getName();
        final String componentName = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        
        //faz o lookup
        this.paisServiceRemote = (PaisServiceRemote) context.lookup(componentName);
	}
	
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
