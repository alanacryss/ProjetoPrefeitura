package br.ufrn.imd.lojaRapida.controle;

import javax.faces.bean.ManagedBean;

import br.ufrn.imd.lojaRapida.dao.DocumentoDAO;
import br.ufrn.imd.lojaRapida.dominio.Documento;

@ManagedBean
public class DocumentoDetalheMBean {
	
	private Documento doc;
	
	public Documento getDoc() {
		return doc;
	}
	
	public void setDoc(Documento doc) {
		this.doc = doc;
	}
	
	public String selecionar(Documento doc) {
		System.out.println(doc);
		this.doc = doc;
		return "/cadastro/documentoDetalhe";
	}
	
	public String selecionar2(Documento doc) {
		this.doc = doc;
		return "/cliente/compra";
	}
	
	public String selecionar3(Integer idDoc) {
		System.out.println("Selecionar 3 - "+ doc);
		DocumentoDAO dao = new DocumentoDAO();
		this.doc = dao.findByPrimaryKey(idDoc);
		dao.close();
		return "/cadastro/documentoDetalhe";
	}

}
