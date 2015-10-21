package br.edu.aula.jee.sessionbeans;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote
@Stateless
public class StatelessSession implements Contador {
	
	private int valor;
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor += valor;
	}
}
