package br.ufrn.imd.lojaRapida.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.ufrn.imd.lojaRapida.dominio.Usuario;

@Stateless
//@ManagedBean
public class UsuarioDAO extends GenericDAO<Usuario> {
	
	//@Inject
	//private Usuario usuario = new Usuario();
	
//	@PersistenceContext(unitName="loja")
//	private EntityManager em;

	@Override
	public Class<Usuario> getClassType() {
		return Usuario.class;
	}
	
	public Usuario buscarPorEmailESenha(String email, String senha) {
//		String jpql = "from Usuario c where c.email = :email and c.senha = :senha";
//		EntityManager em = getEm(); 
//		
//		Query q = em.createQuery(jpql);
//		q.setParameter("email", email);
//		q.setParameter("senha", senha);
		
		
		//Usuario retorno = null;
		
		List<Usuario> us = findAll();
		
		for(Usuario u : us){
			if(u.getEmail().equals(email) && u.getSenha().equals(senha)){
				return u;
			}
		}
		return null;
				
		
//		try {
//			retorno = (Usuario) q.getSingleResult();
//		} catch (Exception e) {
//			System.out.println("Usuario erro:" + e.getMessage());
//			retorno = null;
//		}
//		
//		return retorno;
	}
}
