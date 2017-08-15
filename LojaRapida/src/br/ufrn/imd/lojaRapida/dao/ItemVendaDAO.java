package br.ufrn.imd.lojaRapida.dao;

import javax.ejb.Stateless;

import br.ufrn.imd.lojaRapida.dominio.ItemVenda;

@Stateless
public class ItemVendaDAO extends GenericDAO<ItemVenda>{

	@Override
	public Class<ItemVenda> getClassType() {
		return ItemVenda.class;
	}

}
