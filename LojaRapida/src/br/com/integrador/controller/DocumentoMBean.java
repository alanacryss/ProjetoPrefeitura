package br.com.integrador.controller;

import javax.faces.bean.ManagedBean;

import br.com.integrador.dominio.Documento;
import br.com.integrador.negocio.CrudService;

@ManagedBean
public class DocumentoMBean {

	private Documento doc = new Documento();
	private int id;
	
	public void salvarDoc() {
		new CrudService().create(doc);
		doc = new Documento();
	}
	
	public void atualizarDoc() {
		new CrudService().update(doc);
		doc = new Documento();
	}
	
	public void removerDoc(Documento doc) {
		new CrudService().delete(doc);
	}

	public Documento getDoc() {
		return doc;
	}

	public void setDoc(Documento doc) {
		this.doc = doc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
