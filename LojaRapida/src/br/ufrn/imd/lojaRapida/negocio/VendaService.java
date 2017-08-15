package br.ufrn.imd.lojaRapida.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.lojaRapida.dao.ClienteDAO;
import br.ufrn.imd.lojaRapida.dao.ItemVendaDAO;
import br.ufrn.imd.lojaRapida.dao.VendaDAO;
import br.ufrn.imd.lojaRapida.dominio.Cliente;
import br.ufrn.imd.lojaRapida.dominio.ItemVenda;
import br.ufrn.imd.lojaRapida.dominio.Produto;
import br.ufrn.imd.lojaRapida.dominio.Venda;

/**
 * Entidade da camada de negócio (business layer).
 * 
 * @author gleydson
 *
 */
public class VendaService {

	public Venda fecharCarrinho(Cliente cliente, List<Produto> itens, Double valorTotal) throws Exception {

		if (cliente == null) {
			throw new Exception("Cliente não informado!");
		}

		if (itens.size() == 0) {
			throw new Exception("Carrinho vazio. Não há itens para fechar venda.");
		}

		Venda venda = new Venda();
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		VendaDAO vendaDAO = new VendaDAO();
		ClienteDAO clienteDAO = new ClienteDAO();

		try {

			venda.setData(new java.util.Date());

			venda.setCliente(cliente);

			List<ItemVenda> carrinho = new ArrayList<ItemVenda>();

			for (Produto produto : itens) {
				ItemVenda item = new ItemVenda();
				item.setProduto(produto);
				item.setPreco(produto.getPreco());
				System.out.println(item);
				itemVendaDAO.create(item);
				carrinho.add(item);
			}

			venda.setItens(carrinho);

			venda.setTotal(valorTotal);

			vendaDAO.create(venda);

			venda.setCliente(clienteDAO.findByPrimaryKey(venda.getCliente().getId()));

			itens = new ArrayList<Produto>();
			valorTotal = 0.0;
			
			return venda;

		} finally {
			itemVendaDAO.close();
			vendaDAO.close();
			clienteDAO.close();
		}

	}

}