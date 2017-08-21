package br.ufrn.imd.lojaRapida.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.integrador.enums.TipoDocumento;
import br.ufrn.imd.lojaRapida.dao.PersistDB;

@Entity
public class Documento implements PersistDB {
	
	@Id
	@GeneratedValue
	private int id;
	private String titulo;
	
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipo;
	
//	@Column(name="numeracao")
//	private HashMap<String, Integer> numeracao;
	
//	@OneToMany
//	private br.com.integrador.interfaces.TipoDocumento tipos;
	private Date data;
	private String assunto;
	
	private Integer numeracao;
	
//	@Column(name="ano")
//	private String ano;
	

//	public HashMap<String, Integer> getNumeracao() {
//		return numeracao;
//	}
//	
//	public void setNumeracao(HashMap<String, Integer> numeracao) {
//		this.numeracao = numeracao;
//	}	
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getNumeracao() {
		return numeracao;
	}
	
	public void setNumeracao(Integer numeracao) {
		this.numeracao = numeracao;
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
