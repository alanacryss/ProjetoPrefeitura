package br.ufrn.imd.lojaRapida.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufrn.imd.lojaRapida.dominio.Venda;

@Stateless
public class VendaDAO extends GenericDAO<Venda>{

	@Override
	public Class<Venda> getClassType() {
		return Venda.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> findAllByClienteId(Integer cliente){
		
		String jpql = "from Venda v where v.cliente.id = :cliente";
		EntityManager em = getEm();
		Query q = em.createQuery(jpql);
		q.setParameter("cliente", cliente);
		
		List<Venda> retorno = null;
		
		try {
			retorno = q.getResultList();
		} catch (Exception e) {
			retorno = null;
		}
		
		return retorno;
	}

}
