package br.com.integrador.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.integrador.dominio.Notificacao;
import br.com.integrador.enums.PrioridadeNotificacao;

public class NotificacaoDAO extends GenericDAO<Notificacao> {

	@Override
	public Class<Notificacao> getClassType() {
		return Notificacao.class;
	}
	
	//Metodo que ira realizar a busca de notificações pela prioridade
	public Notificacao buscarPorPrioridade(PrioridadeNotificacao prioridade) {
		String jpql = "from Notificacao c where c.prioridade = :" + prioridade;
		EntityManager em = getEm();
		Query q = em.createQuery(jpql);
		q.setParameter("prioridade", prioridade);
		
		Notificacao retorno = null;
		
		try {
			retorno = (Notificacao) q.getSingleResult();
		} catch (Exception e) {
			retorno = null;
		}
		
		return retorno;
	}
}
