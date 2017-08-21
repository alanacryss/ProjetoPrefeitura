package br.ufrn.imd.lojaRapida.controle;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.tabview.TabView;

import br.com.integrador.enums.TipoDocumento;
import br.ufrn.imd.lojaRapida.dominio.DocumentoRecebido;
import br.ufrn.imd.lojaRapida.negocio.CrudService;
import br.ufrn.imd.lojaRapida.negocio.DocumentoRecebidoService;

@ManagedBean
public class DocumentoRecebidoMBean {

	@EJB
	private CrudService crudService;
	
	@EJB
	private DocumentoRecebidoService docService;
	
	private DocumentoRecebido doc = new DocumentoRecebido();
	private TipoDocumento[] tipos;
	private List<DocumentoRecebido> DocumentoRecebidos;
	private TabView tabView;
	//private int id;
	
	public void salvarDoc() {
		
		if(docService.verificarDisponibilidadePorAno(doc.getData().getYear(), doc.getTipo(), doc.getNumeracao())){
			crudService.create(doc);
			
			MensagensUtil.addInfo("DocumentoRecebido salvo");
			
			doc = new DocumentoRecebido();
			
			return;
		}
		
		MensagensUtil.addError("Numeração já usada!");
		
		doc = new DocumentoRecebido();
	}
	
	public Integer getNumeracao(TipoDocumento tipo){
		
		return docService.getNumeroDisponivel(new Date().getYear(), tipo);
	}
	
	public String atualizarDoc(DocumentoRecebido DocumentoRecebido) {
		doc = DocumentoRecebido;
		//docService.atualiza(id);
		//doc = new DocumentoRecebido();
		return "/cadastro/cadastroDocumentoRecebido";
	}
	
	public List<DocumentoRecebido> getListaDocumentoRecebido() {
		return docService.getAllDocumentos();	
	}
	
	public String removerDoc(int id) {
		docService.removeDoc(id);
		doc = new DocumentoRecebido();
		
		return null;
	}

	public DocumentoRecebido getDoc() {
		return doc;
	}

	public void setDoc(DocumentoRecebido doc) {
		this.doc = doc;
	}

	public TipoDocumento[] getTipos() {
		return TipoDocumento.values();
	}

	public List<DocumentoRecebido> getDocumentoRecebidos() {
		return DocumentoRecebidos;
	}

	public void setDocumentoRecebidos(List<DocumentoRecebido> DocumentoRecebidos) {
		this.DocumentoRecebidos = DocumentoRecebidos;
	}

	public TabView getTabView() {
		return tabView;
	}

	public void setTabView(TabView tabView) {
		this.tabView = tabView;
	}

	public void setTipos(TipoDocumento[] tipos) {
		this.tipos = tipos;
	}
}
