package br.edu.aula.jee.sessionbeans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class StartupSingletonSession {
	public enum Estado{ PRE, INICIADO, ENCERRANDO };
	
	private Estado estadoAtual = Estado.PRE;
	
	@EJB
	private Termometro termometro;
	
	public StartupSingletonSession() {
		System.out.println("Termometro deve ser nulo: "+ termometro );
	}
	
    @PostConstruct
    public void initialize() {
    		System.out.println("Termometro deve ter instancia: "+ termometro );
    		System.out.println("\n\nEstado atual: "+estadoAtual);
        this.estadoAtual = Estado.INICIADO;
        System.out.println("Estado atual: "+estadoAtual);
    }
    @PreDestroy
    public void destroy() {
    	System.out.println("\n\nEstado atual: "+estadoAtual);
        this.estadoAtual = Estado.ENCERRANDO;
        System.out.println("Estado atual: "+estadoAtual);
    }
}
