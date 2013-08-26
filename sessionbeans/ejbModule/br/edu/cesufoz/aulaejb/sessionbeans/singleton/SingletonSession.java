package br.edu.cesufoz.aulaejb.sessionbeans.singleton;

import javax.ejb.Singleton;

/**
 * Session Bean
 */
@Singleton
public class SingletonSession implements ISingletonSession {
	private float temperatura = 0;
	@Override
	public float getTemperatura() {
		return temperatura;
	}
	@Override
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
}
