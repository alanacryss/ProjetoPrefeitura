package br.com.integrador.controller;

import javax.faces.bean.ManagedBean;

import br.com.integrador.dominio.Notificacao;
import br.com.integrador.enums.PrioridadeNotificacao;
import br.com.integrador.negocio.CrudService;

@ManagedBean
public class NotificacaoMBean {

	private Notificacao not = new Notificacao();
	private PrioridadeNotificacao prioridade;
	
	public void atualizarNotificacao() {
		new CrudService().update(not);
		not = new Notificacao();
	}
	
	public void removerNotificacao() {
		new CrudService().delete(not);
	}
	
	public Notificacao getNot() {
		return not;
	}
	
	public void setNot(Notificacao not) {
		this.not = not;
	}
	
	public PrioridadeNotificacao getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(PrioridadeNotificacao prioridade) {
		this.prioridade = prioridade;
	}
	
	
}
