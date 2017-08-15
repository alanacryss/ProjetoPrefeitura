package br.ufrn.imd.lojaRapida.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;

import br.ufrn.imd.lojaRapida.dao.OfertaDAO;
import br.ufrn.imd.lojaRapida.dao.ProdutoDAO;
import br.ufrn.imd.lojaRapida.dominio.Oferta;
import br.ufrn.imd.lojaRapida.negocio.CrudService;

@ManagedBean
public class OfertaMBean {

	@EJB
	private OfertaDAO dao;
	
	@EJB
	private ProdutoDAO prodDao;
	
	private Oferta oferta = new Oferta();

	private Tab tabCadastro;

	private TabView tabView;

	@PostConstruct
	public void init() {
		if (oferta.getId() == 0) {
			oferta = new Oferta();
		}
	}

	public List<Oferta> getListaCompleta() {
		return dao.findAll();
	}

	public String salvar() {

		OfertaDAO dao = new OfertaDAO();
		ProdutoDAO prodDao = new ProdutoDAO();

		System.out.println(oferta.getId());

		try {
			if (oferta.getId() > 0) {
				new CrudService().update(oferta);
				MensagensUtil.addInfo("Oferta Atualizada com Sucesso!");
				oferta = new Oferta();
				tabView.setActiveIndex(0);
			} else {

				Boolean dataConfirm = true;

				if (dao.findAllByProdutoId(oferta.getProduto().getId()) != null) {
					for (Oferta of : dao.findAllByProdutoId(oferta.getProduto().getId())) {
						if (oferta.getDataFimOferta().after(of.getDataFimOferta())) {
							dataConfirm = true;
						} else {
							dataConfirm = false;
						}

					}

				}

				if (dataConfirm == true) {
					new CrudService().create(oferta);
					oferta.setProduto(prodDao.findByPrimaryKey(oferta.getProduto().getId()));
					oferta = new Oferta();
					tabView.setActiveIndex(0);
					MensagensUtil.addInfo("Oferta salva com sucesso");
				} else {
					MensagensUtil.addInfo("Oferta com data invalida");
				}
			}

		} finally {
			dao.close();
		}

		return null;
	}

	public String selecionar(Oferta oferta) {
		this.oferta = oferta;
		tabCadastro.setInView(true);
		tabView.setActiveIndex(1);
		return "/admin/oferta";
	}

	public String deletar(Oferta oferta) {

		new CrudService().delete(oferta);
		MensagensUtil.addInfo("Registro deletado com sucesso");
		tabView.setActiveIndex(0);
		oferta = new Oferta();

		return null;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Tab getTabCadastro() {
		return tabCadastro;
	}

	public void setTabCadastro(Tab tabCadastro) {
		this.tabCadastro = tabCadastro;
	}

	public TabView getTabView() {
		return tabView;
	}

	public void setTabView(TabView tabView) {
		this.tabView = tabView;
	}

}
