package br.ufrn.imd.lojaRapida.dao;

import javax.ejb.Stateless;

import br.ufrn.imd.lojaRapida.dominio.Produto;

/**
 * Respons�vel por executar o acesso a dados da Entidade Categoria.
 * @author Usuario
 *
 */
@Stateless
public class ProdutoDAO extends GenericDAO<Produto>{

	@Override
	public Class<Produto> getClassType() {
		return Produto.class;
	}
	
	

}
