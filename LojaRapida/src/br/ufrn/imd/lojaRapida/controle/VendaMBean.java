package br.ufrn.imd.lojaRapida.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;

import br.ufrn.imd.lojaRapida.dao.VendaDAO;
import br.ufrn.imd.lojaRapida.dominio.Venda;

@ManagedBean
public class VendaMBean {

	private Venda venda = new Venda();

	private Tab tabDetalhe;

	private TabView tabView;

	private List<Venda> vendas;

	private List<Venda> filteredVendas;

	

	@PostConstruct
	public void init() {
		if (vendas == null) {
			VendaDAO dao = new VendaDAO();
			try {
				vendas = dao.findAll();
			} finally {
				dao.close();
			}
		}
	}

	public List<Venda> getListaCompleta() {

		VendaDAO dao = new VendaDAO();

		try {
			return dao.findAll();
		} finally {
			dao.close();
		}

	}

	public List<Venda> vendasCliente(Integer cliente) {
		VendaDAO dao = new VendaDAO();
		this.vendas = dao.findAllByClienteId(cliente);
		dao.close();
		return vendas;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public Double faturamento() {
		Double faturamento = 0.0;

		for (Venda venda : vendas) {
			faturamento = Double.sum(faturamento, venda.getTotal());
		}

		return faturamento;

	}
	
	
	public List<Venda> getFilteredVendas() {
		return filteredVendas;
	}

	public void setFilteredVendas(List<Venda> filteredVendas) {
		this.filteredVendas = filteredVendas;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Tab getTabDetalhe() {
		return tabDetalhe;
	}

	public void setTabDetalhe(Tab tabDetalhe) {
		this.tabDetalhe = tabDetalhe;
	}

	public TabView getTabView() {
		return tabView;
	}

	public void setTabView(TabView tabView) {
		this.tabView = tabView;
	}

}
