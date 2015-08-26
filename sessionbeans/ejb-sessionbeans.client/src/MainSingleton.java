import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.cesufoz.aulaejb.sessionbeans.singleton.ISingletonSession;
import br.edu.cesufoz.aulaejb.sessionbeans.singleton.SingletonSession;

public class MainSingleton {
	public static void main(String[] args) throws NamingException {
		
		final Properties properties = new Properties();
		//possibilita o acesso ao namespace "ejb:"
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(properties);
		
		//EAR
        final String appName = "";
        //Modulo do EAR (ejb, war, jar)
        final String moduleName = "ejb-sessionbeans.ejb";
        // JBoss AS7 possibilita adicionar nomes customizados.
        final String distinctName = "";
        //Nome da implementacao EJB
        final String beanName = SingletonSession.class.getSimpleName();
        //Nome completo da interface remota
        final String viewClassName = ISingletonSession.class.getName();
        final String componentName = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.out.println( componentName );
        
        //faz o lookup
        ISingletonSession singletonSession = (ISingletonSession) context.lookup(componentName);
        singletonSession.setTemperatura(10);
        System.out.println("Temp:"+ singletonSession.getTemperatura() );
        
        singletonSession = (ISingletonSession) context.lookup(componentName);
        System.out.println("Temp:"+ singletonSession.getTemperatura() );
        singletonSession.setTemperatura(20);
        System.out.println("Temp:"+ singletonSession.getTemperatura() );
        
        singletonSession = (ISingletonSession) context.lookup(componentName);
        System.out.println("Temp:"+ singletonSession.getTemperatura() );
        singletonSession.setTemperatura(50);
        System.out.println("Temp:"+ singletonSession.getTemperatura() );
        
        singletonSession = (ISingletonSession) context.lookup(componentName);
        System.out.println("Temp:"+ singletonSession.getTemperatura() );
	}
}
