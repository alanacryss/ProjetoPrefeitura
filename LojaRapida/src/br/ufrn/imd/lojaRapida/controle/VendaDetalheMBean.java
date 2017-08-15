package br.ufrn.imd.lojaRapida.controle;

import javax.faces.bean.ManagedBean;

import br.ufrn.imd.lojaRapida.dao.VendaDAO;
import br.ufrn.imd.lojaRapida.dominio.Venda;

@ManagedBean
public class VendaDetalheMBean {
	
	private Venda venda;

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public String selecionar(Venda venda) {
		System.out.println(venda);
		this.venda = venda;
		return "/admin/vendaDetalhe";
	}
	
	public String selecionar2(Venda venda) {
		this.venda = venda;
		return "/cliente/compra";
	}
	
	public String selecionar3(Integer idVenda) {
		System.out.println("Selecionar 3 - "+venda);
		VendaDAO dao = new VendaDAO();
		this.venda = dao.findByPrimaryKey(idVenda);
		dao.close();
		return "/admin/vendaDetalhe";
	}

}
