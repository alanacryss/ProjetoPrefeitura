package br.ufrn.imd.lojaRapida.controle;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;

import br.ufrn.imd.lojaRapida.dao.ProdutoDAO;
import br.ufrn.imd.lojaRapida.dominio.Produto;
import br.ufrn.imd.lojaRapida.negocio.CrudService;

@ManagedBean
public class ProdutoMBean {

	@EJB
	private ProdutoDAO dao;

	@EJB 
	private CrudService crudService; 
	
	private Produto produto = new Produto();

	private Tab tabCadastro;

	private TabView tabView;

	public List<Produto> getListaCompleta() {
		return dao.findAll();
	}

	public List<Produto> getListaCompletaPorCategoria(Integer idCategoria) {

		if (idCategoria == 0) {
			return dao.findAll();
		} else {
			return dao.findAllById("categoria.id", idCategoria);
		}

	}

	public String salvar() {

		if (produto.getId() > 0) {
			crudService.update(produto);
			MensagensUtil.addInfo("Produto Atualizado com Sucesso!");
			produto = new Produto();
			tabView.setActiveIndex(0);
		} else {
			crudService.create(produto);
			produto = new Produto();
			tabView.setActiveIndex(0);
			MensagensUtil.addInfo("Produto salvo com sucesso");
		}

		return null;
	}

	public String selecionar(Produto produto) {
		this.produto = produto;
		tabCadastro.setInView(true);
		tabView.setActiveIndex(1);
		return "/admin/produto";
	}

	public String deletar(Produto produto) {

		crudService.delete(produto);
		MensagensUtil.addInfo("Registro deletado com sucesso");
		tabView.setActiveIndex(0);
		produto = new Produto();

		return null;
	}

	public TabView getTabView() {
		return tabView;
	}

	public void setTabView(TabView tabView) {
		this.tabView = tabView;
	}

	public Tab getTabCadastro() {
		return tabCadastro;
	}

	public void setTabCadastro(Tab tabCadastro) {
		this.tabCadastro = tabCadastro;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
