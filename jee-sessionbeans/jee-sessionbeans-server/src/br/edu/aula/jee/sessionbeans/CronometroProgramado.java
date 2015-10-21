package br.edu.aula.jee.sessionbeans;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Stateless
public class CronometroProgramado {
	
	@Resource
	private TimerService timerService;
	
	@PostConstruct
	public void postConstruct(){
		System.out.println("\n\n\n\n\n--------------");
		final long duration = 6000;
		final Timer timer = timerService.createSingleActionTimer(duration, new TimerConfig());
		System.out.println( timer );
	}
	
	@Timeout
	public void timeout( Timer timer ) {
		System.out.println("TimerBean: timeout occurred");
	}

}
