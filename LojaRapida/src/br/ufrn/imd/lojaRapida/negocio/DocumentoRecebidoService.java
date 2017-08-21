package br.ufrn.imd.lojaRapida.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.integrador.enums.TipoDocumento;
import br.ufrn.imd.lojaRapida.dao.DocumentoRecebidoDAO;
import br.ufrn.imd.lojaRapida.dominio.DocumentoRecebido;

@Stateless
public class DocumentoRecebidoService {

	@EJB
	private DocumentoRecebidoDAO dao;

	public List<DocumentoRecebido> getAllDocumentos() {
		return dao.findAll();
	}

	public void removeDoc(int id) {
		DocumentoRecebido d = dao.findByPrimaryKey(id);
		dao.delete(d);
	}

	public void atualiza(int id) {
		DocumentoRecebido d = dao.findByPrimaryKey(id);
		dao.update(d);
	}

	public boolean verificarDisponibilidadePorAno(int ano, TipoDocumento tipo, Integer n) {
		List<DocumentoRecebido> list = dao.findAll();
		for (DocumentoRecebido d : list)
			if (ano == d.getData().getYear() && tipo.compareTo(d.getTipo()) == 0 && n.equals(d.getNumeracao()))
				return false;

		return true;
	}

	public Integer getNumeroDisponivel(int ano, TipoDocumento tipo) {
		List<DocumentoRecebido> list = dao.findAll();
		Integer n = new Integer(1);
		for (DocumentoRecebido d : list){
			//System.out.println(ano == d.getData());
			if (ano == d.getData().getYear() && tipo.compareTo(d.getTipo()) == 0)
				n = new Integer(d.getNumeracao() + 1);
		}
		
		return n;
	}
}
