package br.edu.cesufoz.aulaejb.session;

import java.util.Calendar;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class PaisService
 */
@Stateless
public class PaisService implements PaisServiceRemote {

	/**
	 * 
	 */
	@Override
	public String dizerOlaMundo() {
		return "Olá Mundo. Agora é: "+Calendar.getInstance().getTime();
	}

}
