package br.edu.aula.jee.sessionbeans;

import javax.ejb.Singleton;

@Singleton
public class SingletonSession implements Termometro {
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
