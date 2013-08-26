package br.edu.cesufoz.aulaejb.sessionbeans.singleton;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class ScheduleSingletonSession
 */
@Singleton
public class ScheduleSingletonSession {
	
	@Schedule(second="1", minute="45",hour="0")
	public void dataEspecifica() {
		System.out.println("dataEspecifica: Execucao agendada");
	}
	
	@Schedule(second="*/5", minute="*",hour="*")
	public void aCada5Segundos() {
		System.out.println("aCada5Segundos");
	}
	
	@Schedule(second="30/10", minute="*",hour="*")
	public void aCada5SegundosComecando30() {
		System.out.println("aCada10SegundosComecando30");
	}
	
	@Schedule(second="1,10",minute="*",hour="*")
	public void aCada1e10Segundos() {
		System.out.println("aCada1e10Segundos");
	}
}