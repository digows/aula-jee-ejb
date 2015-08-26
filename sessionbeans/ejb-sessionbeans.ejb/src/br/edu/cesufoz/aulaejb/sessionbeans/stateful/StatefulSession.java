package br.edu.cesufoz.aulaejb.sessionbeans.stateful;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import br.edu.cesufoz.aulaejb.sessionbeans.IContador;

@Remote
@Stateful
public class StatefulSession implements IContador {
	
	private int valor;
	
	@Override
	public int getValor() {
		return valor;
	}
	
	@Override
	public void setValor(int valor) {
		this.valor += valor;
	}
}

