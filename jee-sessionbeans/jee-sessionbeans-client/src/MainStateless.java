import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.aula.jee.sessionbeans.Contador;

public class MainStateless {

	public static void main(String[] args) throws NamingException {

		final Properties properties = new Properties();
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		final Context context = new InitialContext(properties);
		final String moduleName = "jee-sessionbeans-server";
		final String beanName = "StatelessSession";
		final String viewClassName = "br.edu.aula.jee.sessionbeans.Contador";
		final String jndi = "ejb:/"+moduleName+"/"+beanName+"!"+viewClassName;
		final Contador stateless = (Contador) context.lookup(jndi);
		
		stateless.setValor(10);
		stateless.setValor(10);
		System.out.println( stateless.getValor() );
	}
}