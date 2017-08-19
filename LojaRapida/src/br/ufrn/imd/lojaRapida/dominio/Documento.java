package br.ufrn.imd.lojaRapida.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.ufrn.imd.lojaRapida.dao.PersistDB;
import br.com.integrador.enums.TipoDocumento;

@Entity
public class Documento implements PersistDB {
	
	@Id
	@GeneratedValue
	private int id;
	private String titulo;
	
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipo;
	private Date data;
	private String assunto;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TipoDocumento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDocumento tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

}
