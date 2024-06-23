package br.edu.cesarschool.next.poo.projetoreferencia.utils;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Registro implements Serializable {
	private LocalDateTime dhInclusao;
	private LocalDateTime dhUltimaAtualizacao;
	public Registro() {		
	}
	public LocalDateTime getDhUltimaAtualizacao() {
		return dhUltimaAtualizacao;
	}
	void setDhUltimaAtualizacao(LocalDateTime dhUltimaAtualizacao) {
		this.dhUltimaAtualizacao = dhUltimaAtualizacao;
	}
	
	void setDhInclusao(LocalDateTime dhInclusao) {
		this.dhInclusao = dhInclusao;
	}
	public LocalDateTime getDhInclusao() {
		return dhInclusao;
	}
	public abstract String getIdUnico();
}
