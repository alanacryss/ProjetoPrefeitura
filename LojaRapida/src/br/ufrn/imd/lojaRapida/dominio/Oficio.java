package br.ufrn.imd.lojaRapida.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.integrador.interfaces.TipoDocumento;

@Entity
public class Oficio implements TipoDocumento{
	
	@Id
	@GeneratedValue
	private Integer id;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	private Documento documento;

//	private List<Ano> anos;
	
	@Override
	public List<Ano> getAnos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

}
