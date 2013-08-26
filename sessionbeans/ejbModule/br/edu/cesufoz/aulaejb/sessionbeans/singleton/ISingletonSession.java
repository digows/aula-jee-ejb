package br.edu.cesufoz.aulaejb.sessionbeans.singleton;

import javax.ejb.Remote;

/**
 * Session Bean
 */
@Remote
public interface ISingletonSession {
	public float getTemperatura();
	public void setTemperatura(float temperatura);
}
