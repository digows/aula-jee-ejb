import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.cesufoz.aulaejb.entity.Pais;
import br.edu.cesufoz.aulaejb.service.PaisServiceRemote;

public class Main {
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
        final PaisServiceRemote paisServiceRemote = (PaisServiceRemote) context.lookup(componentName);
        
        //Pais p = paisServiceRemote.insert( new Pais(null, "Meu Pais "+System.nanoTime()) );
        //System.out.println("Pais inserido: "+ p );
        
        final List<Pais> paises = paisServiceRemote.listByFilters(null);
        System.out.println("Size: "+paises.size()+" - "+paises);
	}
}
