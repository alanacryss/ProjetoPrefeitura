package br.ufrn.imd.lojaRapida.controle;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.hibernate.loader.criteria.CriteriaJoinWalker;

import br.ufrn.imd.lojaRapida.dominio.Usuario;
import br.ufrn.imd.lojaRapida.negocio.CrudService;

@ManagedBean
public class UsuarioMBean {
	
	
	@EJB
	private CrudService crudService;
	private Usuario usuario = new Usuario();
	private int id;
	
	
	public void salvarUsuario() {
		crudService.create(usuario);
		usuario = new Usuario();
	}
	
	public void atualizarUsuario() {
		crudService.update(usuario);
		usuario = new Usuario();
	}
	
	public void removerUsuario(Usuario usuario) {
		crudService.delete(usuario);
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
