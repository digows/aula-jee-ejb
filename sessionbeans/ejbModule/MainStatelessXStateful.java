import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.cesufoz.aulaejb.sessionbeans.IContador;
import br.edu.cesufoz.aulaejb.sessionbeans.stateful.StatefulSession;
import br.edu.cesufoz.aulaejb.sessionbeans.stateless.StatelessSession;

public class MainStatelessXStateful {
	public static void main(String[] args) throws NamingException {
		
		final Properties properties = new Properties();
		//necessario para o JBoss remoting 
		properties.put("jboss.naming.client.ejb.context", true);
		//possibilita o acesso ao namespace "ejb:"
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		//factory do contexto JNDI
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		//endereco do servidor
		properties.put(Context.PROVIDER_URL, "remote://localhost:4447");
		//credenciais para acesso
		properties.put(Context.SECURITY_PRINCIPAL, "app");
		properties.put(Context.SECURITY_CREDENTIALS, "app123");
		final Context context = new InitialContext(properties);
		
		callStateful(context);
		callStateless(context);
	}

	private static void callStateful( Context context ) throws NamingException {
		//EAR
        final String appName = "";
        //Modulo do EAR (ejb, war, jar)
        final String moduleName = "ejb-sessionbeans.ejb";
        // JBoss AS7 possibilita adicionar nomes customizados.
        final String distinctName = "";
        //Nome da implementacao EJB
        final String beanName = StatefulSession.class.getSimpleName();
        //Nome completo da interface remota
        final String viewClassName = IContador.class.getName();
        final String componentName = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName+"?stateful";
        
        //faz o lookup
        System.out.println("APP-STATEFUL-----------------------");
        IContador contadorSessionRemote = (IContador) context.lookup(componentName);
        contadorSessionRemote.setValor(10);
        System.out.println("STATEFUL: "+contadorSessionRemote.getValor());
        contadorSessionRemote.setValor(10);
        System.out.println("STATEFUL: "+contadorSessionRemote.getValor());
        contadorSessionRemote.setValor(10);
        System.out.println("STATEFUL: "+contadorSessionRemote.getValor());
        
        contadorSessionRemote = (IContador) context.lookup(componentName);
        contadorSessionRemote.setValor(10);
        System.out.println("STATEFUL: "+contadorSessionRemote.getValor());
        contadorSessionRemote.setValor(10);
        System.out.println("STATEFUL: "+contadorSessionRemote.getValor());
        contadorSessionRemote.setValor(10);
        System.out.println("STATEFUL: "+contadorSessionRemote.getValor());
	}
	
	private static void callStateless( Context context ) throws NamingException {
		
		//EAR
		final String appName = "";
		//Modulo do EAR (ejb, war, jar)
		final String moduleName = "ejb-sessionbeans.ejb";
		// JBoss AS7 possibilita adicionar nomes customizados.
		final String distinctName = "";
		//Nome da implementacao EJB
		final String beanName = StatelessSession.class.getSimpleName();
		//Nome completo da interface remota
		final String viewClassName = IContador.class.getName();
		final String componentName = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
		
        //faz o lookup
		System.out.println("APP-STATELESS-----------------------");
		IContador contadorSessionRemote = (IContador) context.lookup(componentName);
        contadorSessionRemote.setValor(10);
        System.out.println("STATELESS: "+contadorSessionRemote.getValor());
        contadorSessionRemote.setValor(10);
        System.out.println("STATELESS: "+contadorSessionRemote.getValor());
        contadorSessionRemote.setValor(10);
        System.out.println("STATELESS: "+contadorSessionRemote.getValor());
        
        contadorSessionRemote = (IContador) context.lookup(componentName);
        contadorSessionRemote.setValor(10);
        System.out.println("STATELESS: "+contadorSessionRemote.getValor());
        contadorSessionRemote.setValor(10);
        System.out.println("STATELESS: "+contadorSessionRemote.getValor());
        contadorSessionRemote.setValor(10);
        System.out.println("STATELESS: "+contadorSessionRemote.getValor());
	}
}
