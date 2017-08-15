package br.ufrn.imd.lojaRapida.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.ufrn.imd.lojaRapida.dao.PersistDB;

@Entity
public class Venda implements PersistDB{

	/**
	 * Identificador �nico do produto no sistema
	 */
	@Id
	@GeneratedValue
	private int id;
	
	private Date data;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<ItemVenda> itens;
	
	private Double total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", data=" + data + ", cliente=" + cliente
				+ ", itens=" + itens + ", total=" + total + "]";
	}
	
	
	
	
	
	
}
