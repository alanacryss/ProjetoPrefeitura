package br.ufrn.imd.lojaRapida.controle;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.integrador.login.UsuarioLogadoMBean;
import br.ufrn.imd.lojaRapida.dao.UsuarioDAO;
import br.ufrn.imd.lojaRapida.dominio.Usuario;

@ManagedBean
@Model
public class LoginMBean {

	private Usuario usuario = new Usuario();
	
	@EJB
	private UsuarioDAO dao;// = new UsuarioDAO();

	@Inject
	UsuarioLogadoMBean usuarioLogado;

//	@Inject
//	RedirecionadorMBean redirect;

	public String cadastrar() {
		return "/cadastro/cadastroUsuario";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String realizarLogin() {
		
		Usuario usuarioEncontrado = this.dao.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());
		
		System.out.println("Usuario is null? " + (usuarioEncontrado != null));

		if (usuarioEncontrado != null) {
			usuarioLogado.logar(usuarioEncontrado);
			return "/faces/home/home?faces-redirect=true";
		}
		
		criaMensagem("Usuário não encontrado!");
		limparForm();

		return "";
	}

	public String efetuaLogout() {
		this.usuarioLogado.deslogar();
		//return this.redirect.home();
		return "/faces/login/indexLogin?faces-redirect=true";
	}

	private void limparForm() {
		this.usuario = new Usuario();
	}

	private void criaMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, ""));
	}

	private boolean possuiMesmaSenha(Usuario usuarioEncontrado) {
		return usuarioEncontrado.getSenha().equals(usuario.getSenha());
	}
}
