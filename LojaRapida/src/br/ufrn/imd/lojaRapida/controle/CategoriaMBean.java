package br.ufrn.imd.lojaRapida.controle;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;

import br.ufrn.imd.lojaRapida.dao.CategoriaDAO;
import br.ufrn.imd.lojaRapida.dominio.Categoria;
import br.ufrn.imd.lojaRapida.negocio.CrudService;

/**
 * Controla as operações relacionadas ao cadastro de categoria.
 *
 */

@ManagedBean
public class CategoriaMBean{

	@EJB
	private CategoriaDAO dao;
	
	@EJB
	private CrudService crudService;
	
	private Categoria categoria = new Categoria();
	
	private Tab tabCadastro;
	private TabView tabView;
	
	/**
	 * Retorna a listagem todos os registros do banco
	 * @return
	 */
	public List<Categoria> getListaCompleta(){
		try{
			return dao.findAll();
		}finally{
			dao.close();
		}
	}
	
	
	/**
	 * Método que salva o objeto
	 * @return
	 */
	public String salvar(){
		
		try{
			if (categoria.getId()==0 ){
				crudService.create(categoria);
				categoria  = new Categoria();
			}else{
				crudService.update(categoria);
				categoria = new Categoria();			}
			MensagensUtil.addInfo("Categoria salva com sucesso");
		}finally{
			tabView.setActiveIndex(0);
		}
		
		return null;
	}


	public String selecionar(Categoria categoria){
		this.categoria = categoria;
		tabCadastro.setInView(true);
		tabView.setActiveIndex(1);
		return "/admin/categorrfrfia";
	}
	
	
	public String deletar(Categoria categoria){
		
		new CrudService().delete(categoria);
		MensagensUtil.addInfo("Registro deletado com sucesso");
	
		tabView.setActiveIndex(0);
		return null;
	}
	
	
	//----------------------
	
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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


	public CategoriaDAO getDao() {
		return dao;
	}


	public void setDao(CategoriaDAO dao) {
		this.dao = dao;
	}
		
	
	
}