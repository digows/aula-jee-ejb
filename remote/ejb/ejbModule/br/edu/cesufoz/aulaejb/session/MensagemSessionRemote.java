package br.edu.cesufoz.aulaejb.session;

import javax.ejb.Remote;

@Remote
public interface MensagemSessionRemote {
	public String dizerOlaMundo(String nome);
	public Mensagem getMensagem(String conteudo);
}
