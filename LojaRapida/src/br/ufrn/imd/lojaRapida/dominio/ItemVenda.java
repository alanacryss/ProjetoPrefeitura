package br.ufrn.imd.lojaRapida.dominio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.ufrn.imd.lojaRapida.dao.PersistDB;

@Entity
public class ItemVenda implements PersistDB {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produto;
	
	private Double preco;
	

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "ItemVenda [id=" + id + ", produto=" + produto + ", preco="
				+ preco + "]";
	}

	
}
