import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.udc.jee.service.UsuarioServiceRemote;

public class Main {

	public static void main(String[] args) throws NamingException {

		final Properties properties = new Properties();
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		final Context context = new InitialContext(properties);
		final String moduleName = "jee-hello";
		final String beanName = "UsuarioService";
		final String viewClassName = "br.edu.udc.jee.service.UsuarioServiceRemote";
		final String jndi = "ejb:/"+moduleName+"/"+beanName+"!"+viewClassName;
		final UsuarioServiceRemote usuarioService = (UsuarioServiceRemote) context.lookup(jndi);
		System.out.println( usuarioService.listarUsuarios() );
	}
}
