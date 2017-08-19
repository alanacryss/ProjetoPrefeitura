package br.ufrn.imd.lojaRapida.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufrn.imd.lojaRapida.dominio.Documento;

@Stateless
public class DocumentoDAO extends GenericDAO<Documento> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Class<Documento> getClassType() {
		return Documento.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Documento> buscarPorId(int id) {
		String jpql = "from Documento d where d.id = :id";
		EntityManager em = getEm();
		Query q = em.createQuery(jpql);
		q.setParameter("id", id);
		
		List<Documento> retorno = null;
		
		try {
			retorno = q.getResultList();
		} catch (Exception e) {
			retorno = null;
		}
		
		return retorno;
	}
}
