package br.ufrn.imd.lojaRapida.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;

import br.ufrn.imd.lojaRapida.dao.ClienteDAO;
import br.ufrn.imd.lojaRapida.dominio.Cliente;
import br.ufrn.imd.lojaRapida.negocio.CrudService;

@ManagedBean
public class ClienteMBean {

	private Cliente cliente = new Cliente();

	private String confirmarSenha;

	private Tab tabCadastro;

	private TabView tabView;

	public List<Cliente> getListaCompleta() {
		ClienteDAO dao = new ClienteDAO();
		try {
			return dao.findAll();
		} finally {
			dao.close();
		}
	}

	public String salvar() {

		if (cliente.getSenha().equals(confirmarSenha)) {
			if (cliente.getId() > 0) {
				new CrudService().update(cliente);
				MensagensUtil.addInfo("Cliente Atualizado com Sucesso!");
				cliente = new Cliente();
				tabView.setActiveIndex(0);
			} else {
				new CrudService().create(cliente);
				cliente = new Cliente();
				MensagensUtil.addInfo("Cliente salvo com sucesso");
				tabView.setActiveIndex(0);
			}
		} else {
			MensagensUtil.addError("Senha Incorreta!");
		}

		return null;
	}

	public String selecionar(Cliente cliente) {
		this.cliente = cliente;
		tabView.setActiveIndex(1);
		return "/admin/cliente";
	}

	public String deletar(Cliente cliente) {

		new CrudService().delete(cliente);
		MensagensUtil.addInfo("Registro deletado com sucesso");
		tabView.setActiveIndex(0);

		return null;
	}

	
	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
