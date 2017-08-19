package br.ufrn.imd.lojaRapida.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufrn.imd.lojaRapida.dao.DocumentoDAO;
import br.ufrn.imd.lojaRapida.dominio.Documento;

@Stateless
public class DocumentoService {

	@EJB
	private DocumentoDAO dao;
	
	public List<Documento> getAllDocumentos(){
		return dao.findAll();
	}
	
	public void removeDoc(int id) {
		Documento d = dao.findByPrimaryKey(id);
		dao.delete(d);
	}
	
	public void atualiza(int id) {
		Documento d = dao.findByPrimaryKey(id);
		dao.update(d);
	}
}
