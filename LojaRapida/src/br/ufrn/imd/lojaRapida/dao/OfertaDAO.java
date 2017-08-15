
package br.ufrn.imd.lojaRapida.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufrn.imd.lojaRapida.dominio.Oferta;


/**
 * Respons�vel por executar o acesso a dados da Entidade Categoria.
 * @author Usuario
 *
 */
@Stateless
public class OfertaDAO extends GenericDAO<Oferta>{

	@Override
	public Class<Oferta> getClassType() {
		return Oferta.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Oferta> findAllByProdutoId(Integer produto){
		
		String jpql = "from Oferta o where o.produto.id = :produto";
		EntityManager em = getEm();
		Query q = em.createQuery(jpql);
		q.setParameter("produto", produto);
		
		List<Oferta> retorno = null;
		
		try {
			retorno = q.getResultList();
		} catch (Exception e) {
			retorno = null;
		}
		
		return retorno;
	}
	
	

}