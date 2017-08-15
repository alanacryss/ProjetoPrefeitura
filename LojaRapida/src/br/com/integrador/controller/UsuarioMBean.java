package br.com.integrador.controller;

import javax.faces.bean.ManagedBean;

import br.com.integrador.dominio.Usuario;
import br.com.integrador.negocio.CrudService;

@ManagedBean
public class UsuarioMBean {

	private Usuario usuario = new Usuario();
	private int id;
	
	public void salvarUsuario() {
		new CrudService().create(usuario);
		usuario = new Usuario();
	}
	
	public void atualizarUsuario() {
		new CrudService().update(usuario);
		usuario = new Usuario();
	}
	
	public void removerUsuario(Usuario usuario) {
		new CrudService().delete(usuario);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
