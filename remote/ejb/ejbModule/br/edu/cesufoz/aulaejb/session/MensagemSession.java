package br.edu.cesufoz.aulaejb.session;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class MensagemSession
 */
@Stateless
public class MensagemSession implements MensagemSessionRemote {

	@Override
	public String dizerOlaMundo(String nome) {
		return "Ola Mundo, "+nome;
	}
}
