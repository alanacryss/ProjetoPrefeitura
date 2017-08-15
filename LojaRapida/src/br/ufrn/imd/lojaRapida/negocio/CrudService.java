package br.ufrn.imd.lojaRapida.negocio;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufrn.imd.lojaRapida.dao.GenericDAO;
import br.ufrn.imd.lojaRapida.dao.PersistDB;

/**
 * Entidade da camada de negócio (business layer).
 * 
 * @author gleydson
 *
 */
@SuppressWarnings("rawtypes")
@Stateless
public class CrudService {

	@EJB
	private GenericDAO dao;

	public void create(PersistDB entity) {
		dao.create(entity);
	}

	public void delete(PersistDB entity) {
		dao.delete(entity);
	}

	public void update(PersistDB entity) {
		dao.update(entity);
	}
}

