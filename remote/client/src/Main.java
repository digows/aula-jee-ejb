import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.cesufoz.aulaejb.session.Mensagem;
import br.edu.cesufoz.aulaejb.session.MensagemSession;
import br.edu.cesufoz.aulaejb.session.MensagemSessionRemote;

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
        final String appName = "";
        //Modulo do EAR (ejb, war, jar)
        final String moduleName = "ejb-remote.ejb";
        // JBoss AS7 possibilita adicionar nomes customizados.
        final String distinctName = "";
        //Nome da implementacao EJB
        final String beanName = MensagemSession.class.getSimpleName();
        //Nome completo da interface remota
        final String viewClassName = MensagemSessionRemote.class.getName();
        final String componentName = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        
        //faz o lookup
        final MensagemSessionRemote mensagemSessionRemote = (MensagemSessionRemote) context.lookup(componentName);
		final String conteudo = mensagemSessionRemote.dizerOlaMundo("Rodrigo P. Fraga");
		System.out.println(conteudo);
		
		final Mensagem mensagem = mensagemSessionRemote.getMensagem(conteudo);
		System.out.println(mensagem);
	}
}
