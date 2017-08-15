package br.com.integrador.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.integrador.dao.PersistDB;
import br.com.integrador.dominio.Documento;
import br.com.integrador.enums.PersistEnum;
import br.ufrn.imd.lojaRapida.dao.Database;

public class GenericDAO<T extends PersistDB> {

	protected static EntityManager em;

	@SuppressWarnings("unchecked")
	public T castGeneric(PersistDB obj) {
		return (T) obj;
	}

	public void change(T c, PersistEnum op) {
		EntityManager em = getEm();
		// em.getTransaction().begin();

		if (!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		//em.close();

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

	public void create(T c) {
		change(c, PersistEnum.INSERIR);
	}

	public void update(T c) {
		change(c, PersistEnum.ALTERAR);
	}

	public void delete(T c) {
		change(c, PersistEnum.REMOVER);
	}

	// IMPLEMENTAR
	@SuppressWarnings("unchecked")
	public List<T> buscarDocPorId(String coluna, Integer id) {
		String tabela = getClassType().getSimpleName();
		String jpql = "from " + tabela + " where " + coluna + " = :valor";
		EntityManager em = getEm();
		Query q = em.createQuery(jpql);
		q.setParameter("valor", +id);
		List<T> retorno = q.getResultList();
		return retorno;
	}

	public List<T> buscarTodosDoc() {
		List<T> retorno = new ArrayList<>();
		return retorno;
	}

	public List<T> buscarDocPorTipo(Documento tipo) {
		List<T> retorno = new ArrayList<>();
		return retorno;
	}

	public List<T> buscarUsuarioPorId(int id) {
		List<T> retorno = new ArrayList<>();
		return retorno;
	}

	public Class<T> getClassType() {
		return this.getClassType();
	}

	public EntityManager getEm() {

		if (em == null) {
			em = Database.getInstance().getEntityManager();
		} else if (!em.isOpen()) {
			em = Database.getInstance().getEntityManager();
		}

		return em;
	}

	public void close() {

	}
}
