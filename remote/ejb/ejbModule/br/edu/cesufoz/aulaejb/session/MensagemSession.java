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
	
	@Override
	public Mensagem getMensagem(String conteudo) {
		final Mensagem mensagem = new Mensagem();
		mensagem.conteudo = conteudo;
		return mensagem;
	}
}
