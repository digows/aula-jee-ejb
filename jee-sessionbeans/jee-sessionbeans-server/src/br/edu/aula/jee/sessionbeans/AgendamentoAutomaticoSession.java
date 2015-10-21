package br.edu.aula.jee.sessionbeans;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class AgendamentoAutomaticoSession {

	// Em uma data específica
	@Schedule(second = "10", minute = "53", hour = "19", persistent=false)
	public void dataEspecifica() {
		System.out.println("dataEspecifica");
	}

	// Em uma lista de tempo
	@Schedule(second = "1,10", minute = "*", hour = "*", persistent=false)
	public void aCada1e10Segundos() {
		System.out.println("aCada1e10Segundos");
	}

	// Repetir a cada 5 segundos
	@Schedule(second = "*/5", minute = "*", hour = "*", persistent=false)
	public void aCada5Segundos() {
		System.out.println("aCada5Segundos");
	}

	// Repetir a cada 10 segundos, começando de 30
	@Schedule(second = "30/10", minute = "*", hour = "*", persistent=false)
	public void aCada10SegundosComecando30() {
		System.out.println("aCada10SegundosComecando30");
	}
}