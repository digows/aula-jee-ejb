package br.edu.cesufoz.aulaejb.sessionbeans.stateless;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.edu.cesufoz.aulaejb.sessionbeans.IContador;

@Remote
@Stateless
public class StatelessSession implements IContador {
	
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
