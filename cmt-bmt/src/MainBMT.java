import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import br.edu.cesufoz.ejb.jpa.service.bmt.BMTService;
import br.edu.cesufoz.ejb.jpa.service.bmt.BMTServiceRemote;

public class MainBMT {
	public static void main(String[] args) throws Exception {
		
		final Properties properties = new Properties();
		//possibilita o acesso ao namespace "ejb:"
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(properties);
		
        final String componentName = "ejb:/ejb-jpa.web//" + BMTService.class.getSimpleName() + "!" + BMTServiceRemote.class.getName();
        
        //faz o lookup
        final BMTServiceRemote service = (BMTServiceRemote) context.lookup(componentName);
        
        try {
            service.insertSemCommit();
		} catch (Exception e) {
            System.out.println("insertSemCommit OK");
		}
        System.out.println( service.list() );
        
        service.rollbackTest();
        System.out.println( service.list() );
        System.out.println("rollbackTest OK");
        
        service.transactionOK();
        System.out.println( service.list() );
        System.out.println("transactionOK OK");
	}
}
