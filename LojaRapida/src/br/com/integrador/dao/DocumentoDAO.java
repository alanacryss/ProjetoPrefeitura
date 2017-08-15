package br.com.integrador.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.integrador.dominio.Documento;

public class DocumentoDAO extends GenericDAO<Documento> {

	@Override
	public Class<Documento> getClassType() {
		return Documento.class;
	}
	
	public Documento buscarPorId(int id) {
		String jpql = "from Documento c where c.id = :id";
		EntityManager em = getEm();
		Query q = em.createQuery(jpql);
		q.setParameter("id", id);
		
		Documento retorno = null;
		
		try {
			retorno = (Documento) q.getSingleResult();
		} catch (Exception e) {
			retorno = null;
		}
		
		return retorno;
	}
}
