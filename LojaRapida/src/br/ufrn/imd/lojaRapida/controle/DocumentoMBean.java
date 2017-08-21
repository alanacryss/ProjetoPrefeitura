package br.ufrn.imd.lojaRapida.controle;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.tabview.TabView;

import br.com.integrador.enums.TipoDocumento;
import br.ufrn.imd.lojaRapida.dao.DocumentoDAO;
import br.ufrn.imd.lojaRapida.dominio.Documento;
import br.ufrn.imd.lojaRapida.negocio.CrudService;
import br.ufrn.imd.lojaRapida.negocio.DocumentoService;

@ManagedBean
public class DocumentoMBean {
	
	@EJB
	private CrudService crudService;
	
	@EJB
	private DocumentoService docService;
	
	private Documento doc = new Documento();
	private TipoDocumento[] tipos;
	private List<Documento> documentos;
	private TabView tabView;
	//private int id;
	
	public void salvarDoc() {
		
		if(docService.verificarDisponibilidadePorAno(doc.getData().getYear(), doc.getTipo(), doc.getNumeracao())){
			crudService.create(doc);
			
			MensagensUtil.addWarn("Documento salvo");
			
			doc = new Documento();
			
			return;
		}
		
		MensagensUtil.addError("Numeração já usada!");
		
		doc = new Documento();
	}
	
	public String atualizarDoc(Documento documento) {
		doc = documento;
		//docService.atualiza(id);
		//doc = new Documento();
		return "/cadastro/cadastroDocumento";
	}
	
	public List<Documento> getListaDocumento() {
		return docService.getAllDocumentos();	
	}
	
	public String removerDoc(int id) {
		docService.removeDoc(id);
		doc = new Documento();
		
		return null;
	}

	public Documento getDoc() {
		return doc;
	}

	public void setDoc(Documento doc) {
		this.doc = doc;
	}

	public TipoDocumento[] getTipos() {
		return TipoDocumento.values();
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
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
