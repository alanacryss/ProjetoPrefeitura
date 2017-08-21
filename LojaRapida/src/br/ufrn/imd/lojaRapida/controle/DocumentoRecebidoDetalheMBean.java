package br.ufrn.imd.lojaRapida.controle;

import javax.faces.bean.ManagedBean;

import br.ufrn.imd.lojaRapida.dao.DocumentoRecebidoDAO;
import br.ufrn.imd.lojaRapida.dominio.DocumentoRecebido;

@ManagedBean
public class DocumentoRecebidoDetalheMBean {

	private DocumentoRecebido doc;

	public DocumentoRecebido getDoc() {
		return doc;
	}

	public void setDoc(DocumentoRecebido doc) {
		this.doc = doc;
	}

	public String selecionar(DocumentoRecebido doc) {
		System.out.println(doc);
		this.doc = doc;
		return "/cadastro/documentoRecebidoDetalhe";
	}

	public String selecionar2(DocumentoRecebido doc) {
		this.doc = doc;
		return "/cliente/compra";
	}

	public String selecionar3(Integer idDoc) {
		System.out.println("Selecionar 3 - " + doc);
		DocumentoRecebidoDAO dao = new DocumentoRecebidoDAO();
		this.doc = dao.findByPrimaryKey(idDoc);
		dao.close();
		return "/cadastro/documentoRecebidoDetalhe";
	}
}
