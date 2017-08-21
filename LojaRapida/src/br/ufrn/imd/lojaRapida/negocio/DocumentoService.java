package br.ufrn.imd.lojaRapida.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.integrador.enums.TipoDocumento;
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
	
	public boolean verificarDisponibilidadePorAno(int ano, TipoDocumento tipo, Integer n){
		List<Documento> list = dao.findAll();
		for(Documento d : list)
			if(ano == d.getData().getYear() && tipo.compareTo(d.getTipo()) == 0 && n.equals(d.getNumeracao()))
				return false;
				
		return true;
	}
}
