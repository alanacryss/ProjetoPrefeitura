package br.ufrn.imd.lojaRapida.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.ufrn.imd.lojaRapida.dao.PersistDB;

@Entity
public class Oferta implements PersistDB{
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Produto produto = new Produto();
	private Date dataFimOferta;
	private Double precoOferta;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Date getDataFimOferta() {
		return dataFimOferta;
	}
	public void setDataFimOferta(Date dataFimOferta) {
		this.dataFimOferta = dataFimOferta;
	}
	public Double getPrecoOferta() {
		return precoOferta;
	}
	public void setPrecoOferta(Double precoOferta) {
		this.precoOferta = precoOferta;
	}
	
	
	
	

}
