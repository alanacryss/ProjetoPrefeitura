package br.com.integrador.negocio;

import javax.ejb.EJB;

import br.com.integrador.dao.GenericDAO;
import br.com.integrador.dao.PersistDB;

@SuppressWarnings( "rawtypes")
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
