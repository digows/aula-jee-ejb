import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.cesufoz.aulaejb.session.Mensagem;
import br.edu.cesufoz.aulaejb.session.MensagemSession;
import br.edu.cesufoz.aulaejb.session.MensagemSessionRemote;

public class MainHttpRemotingAcesss {
	public static void main(String[] args) throws NamingException {
		
		final Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		properties.put("jboss.naming.client.ejb.context", true);
		Context context = new InitialContext(properties);
		
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
        final String componentName = appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.out.println( componentName );
		
		final MensagemSessionRemote mensagemSession = (MensagemSessionRemote) context.lookup( componentName );
		
		final String conteudo = mensagemSession.dizerOlaMundo("Rodrigo P. Fraga");
		System.out.println(conteudo);
		
		final Mensagem mensagem = mensagemSession.getMensagem(conteudo);
		System.out.println(mensagem);
	}
}
