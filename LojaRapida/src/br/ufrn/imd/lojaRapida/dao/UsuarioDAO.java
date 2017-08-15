package br.ufrn.imd.lojaRapida.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufrn.imd.lojaRapida.dominio.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {

	@Override
	public Class<Usuario> getClassType() {
		return Usuario.class;
	}
	
	public Usuario buscarPorEmailESenha(String email, String senha) {
		String jpql = "from Usuario c where c.email = :email and c.senha = :senha";
		EntityManager em = getEm();
		Query q = em.createQuery(jpql);
		q.setParameter("email", email);
		q.setParameter("senha", senha);
		
		Usuario retorno = null;
		
		try {
			retorno = (Usuario) q.getSingleResult();
		} catch (Exception e) {
			retorno = null;
		}
		
		return retorno;
	}
}
