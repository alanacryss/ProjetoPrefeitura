package br.ufrn.imd.lojaRapida.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufrn.imd.lojaRapida.dominio.Cliente;

@Stateless
public class ClienteDAO extends GenericDAO<Cliente>{
	

	@Override
	public Class<Cliente> getClassType() {
		return Cliente.class;
	}
	
	public Cliente findByEmailAndSenha(String email,String senha){
		String jpql = "from Cliente c where c.email = :email and c.senha = :senha";
		EntityManager em = getEm();
		Query q = em.createQuery(jpql);
		q.setParameter("email", email);
		q.setParameter("senha", senha);
		
		Cliente retorno = null;
		
		try {
			retorno = (Cliente) q.getSingleResult();
		} catch (Exception e) {
			retorno = null;
		}
		
		return retorno;
	}

}
