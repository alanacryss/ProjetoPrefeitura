package br.ufrn.imd.lojaRapida.controle;

import javax.faces.bean.ManagedBean;

import br.ufrn.imd.lojaRapida.dominio.Notificacao;
import br.com.integrador.enums.PrioridadeNotificacao;
import br.ufrn.imd.lojaRapida.negocio.CrudService;

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
