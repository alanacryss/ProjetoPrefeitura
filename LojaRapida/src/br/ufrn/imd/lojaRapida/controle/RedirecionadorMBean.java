package br.ufrn.imd.lojaRapida.controle;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

//@ManagedBean
@Named
@SessionScoped
public class RedirecionadorMBean implements Serializable{
	
	//@Inject
	//private LoginMBean login;// = new LoginMBean();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer index = 0;
	
	public Integer getIndex() {
		return index;
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}

	public String cadastrar() {
		//this.index = 0;
		return "../cadastro/cadastroUsuario.xhtml";
		//return "../cadastro/cadastroUsuario.xhtml?faces-redirect=true";
	}

	public String home() {
		//this.index = 0;
		return "../home/home.xhtml?faces-redirect=true";
	}

	public String documentos() {
		this.index = 0;
		return "../cadastro/listaDoc.xhtml?faces-redirect=true";
	}

	public void logout() {
		this.index = 0;

	}

	public void login() {
		this.index = 0;
		//login.efetuaLogin();
	}
}
