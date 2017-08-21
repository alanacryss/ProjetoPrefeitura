package br.ufrn.imd.lojaRapida.controle;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.ufrn.imd.lojaRapida.dominio.Usuario;
import br.ufrn.imd.lojaRapida.negocio.CrudService;
import javassist.ClassPool;
import javassist.CtClass;

@ManagedBean
public class UsuarioMBean {
	
	
	@EJB
	private CrudService crudService;
	private Usuario usuario = new Usuario();
	private int id;
	private Integer index = 0;
	// private int id;
	
	public Integer getIndex() {
		return index;
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public String salvarUsuario() {
		crudService.create(usuario);
		//MensagensUtil.addInfo("Usuário cadastrado com sucesso.");
		
//		ClassPool pool = ClassPool.getDefault();
//		CtClass cc = pool.makeClass("Ponto"); 
		
		
		usuario = new Usuario();
		this.index = 1;
		return "/faces/login/indexLogin?faces-redirect=true";
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
