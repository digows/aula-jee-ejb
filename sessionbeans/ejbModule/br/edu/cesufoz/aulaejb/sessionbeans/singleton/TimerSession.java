package br.edu.cesufoz.aulaejb.sessionbeans.singleton;

import javax.ejb.Singleton;

/**
 * Session Bean implementation class TimerSession
 */
@Singleton
public class TimerSession {
	
	//@Schedule(second="*/1", minute="*",hour="*", persistent=false)
	public void timer() {
		System.out.println("Timer!");
	}
}
