package br.edu.cesufoz.aulaejb.sessionbeans.singleton;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Session Bean implementation class ScheduleSingletonSession
 */
@Startup
@Singleton
public class StartupSingletonSession {
	public enum Estado{ PRE, INICIADO, ENCERRANDO };
	
	private Estado estadoAtual = Estado.PRE;
	
    @PostConstruct
    public void initialize() {
    	System.out.println("\n\nEstado atual: "+estadoAtual);
        this.estadoAtual = Estado.INICIADO;
        System.out.println("Estado atual: "+estadoAtual);
    }
    @PreDestroy
    public void terminate() {
    	System.out.println("\n\nEstado atual: "+estadoAtual);
        this.estadoAtual = Estado.ENCERRANDO;
        System.out.println("Estado atual: "+estadoAtual);
    }
}
