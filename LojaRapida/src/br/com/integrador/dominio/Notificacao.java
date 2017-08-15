package br.com.integrador.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.integrador.dao.PersistDB;
import br.com.integrador.enums.PrioridadeNotificacao;

@Entity
public class Notificacao implements PersistDB {

	@Id
	@GeneratedValue
	private int id;
	private String descricao;
	private PrioridadeNotificacao prioridade;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public PrioridadeNotificacao getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(PrioridadeNotificacao prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public int getId() {
		return 0;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	
}
