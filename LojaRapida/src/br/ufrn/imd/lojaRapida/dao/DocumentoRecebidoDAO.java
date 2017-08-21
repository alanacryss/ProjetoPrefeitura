package br.ufrn.imd.lojaRapida.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufrn.imd.lojaRapida.dominio.DocumentoRecebido;

@Stateless
public class DocumentoRecebidoDAO extends GenericDAO<DocumentoRecebido> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Class<DocumentoRecebido> getClassType() {
		return DocumentoRecebido.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<DocumentoRecebido> buscarPorId(int id) {
		String jpql = "from DocumentoRecebido d where d.id = :id";
		EntityManager em = getEm();
		Query q = em.createQuery(jpql);
		q.setParameter("id", id);
		
		List<DocumentoRecebido> retorno = null;
		
		try {
			retorno = q.getResultList();
		} catch (Exception e) {
			retorno = null;
		}
		
		return retorno;
	}
}
