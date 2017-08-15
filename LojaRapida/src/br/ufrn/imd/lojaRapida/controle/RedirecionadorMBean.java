package br.ufrn.imd.lojaRapida.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RedirecionadorMBean {

	public String cadastrar() {
		System.out.println("Entrou");
		return "../cadastro/cadastroUsuario.xhtml?faces-redirect=true";
	}
}
