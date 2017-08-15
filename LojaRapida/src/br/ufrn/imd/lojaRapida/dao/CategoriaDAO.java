package br.ufrn.imd.lojaRapida.dao;

import javax.ejb.Stateless;

import br.ufrn.imd.lojaRapida.dominio.Categoria;

/**
 * Respons�vel por executar o acesso a dados da Entidade Categoria.
 * @author Usuario
 *
 */

@Stateless
public class CategoriaDAO extends GenericDAO<Categoria>{

	@Override
	public Class<Categoria> getClassType() {
		return Categoria.class;
	}
	
	

}
