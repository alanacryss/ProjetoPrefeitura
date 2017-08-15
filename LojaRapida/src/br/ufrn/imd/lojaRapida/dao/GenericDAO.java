package br.ufrn.imd.lojaRapida.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class GenericDAO <T extends PersistDB> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="loja")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public T castGeneric(PersistDB obj){
		
		return (T) obj;
	}
	
	private void change(T c, OperacaoDatabase op){
		
		switch (op) {
			case INSERIR:
				em.persist(c);
				break;
			case ALTERAR:
				em.merge(c);
				break;
			case REMOVER:
				em.remove(c);
				break;
		}
		
		
	}

		
	public void close(){
		
	}
	
	
	public void create(T c){
		change(c, OperacaoDatabase.INSERIR);
	}
	public void update(T c){
		change(c, OperacaoDatabase.ALTERAR);
	}
	public void delete(T c){
		change(c, OperacaoDatabase.REMOVER);
	}
	
	public T findByPrimaryKey(int id){
		T c = em.find(getClassType(), id);
		return c;
	}
	
	public List<T> findAll(){
		CriteriaBuilder builder = getEm().getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getClassType());
		TypedQuery<T> typedQuery = getEm().createQuery(query.select(query.from(getClassType())));
		List<T> c = typedQuery.getResultList();
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAllLike(String coluna,String valor){
		String tabela = getClassType().getSimpleName();
		String jpql = "from "+tabela+ " where "+coluna+" like :valor";
		Query q = em.createQuery(jpql);
		q.setParameter("valor", "%"+valor+"%");
		List<T> retorno = q.getResultList();
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAllById(String coluna,Integer id){
		String tabela = getClassType().getSimpleName();
		String jpql = "from "+tabela+ " where "+coluna+" = :valor";
		Query q = em.createQuery(jpql);
		q.setParameter("valor", +id);
		List<T> retorno = q.getResultList();
		return retorno;
	}
	
	public Class<T> getClassType() {
		return this.getClassType();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}

enum OperacaoDatabase {
	INSERIR,ALTERAR,REMOVER;
}

