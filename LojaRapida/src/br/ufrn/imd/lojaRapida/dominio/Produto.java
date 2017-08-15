package br.ufrn.imd.lojaRapida.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.ufrn.imd.lojaRapida.dao.PersistDB;


/**
 * Representa um produto dispon�vel na loja
 * @author Usuario
 *
 */

@Entity
public class Produto implements PersistDB {
	
	/**
	 * Identificador �nico do produto no sistema
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Denomina��o do produto, descreve-o de forma sucinta.
	 */
	private String denominacao;
	
	/**
	 * Descri��o do produto, detalhes sobre o produto
	 */
	private String descricao;
	
	private String imagem;
	
	/**
	 * Pre�o do produto
	 */
	private Double preco;
	
	/**
	 * Categoria da qual o produto pertence
	 */
	@ManyToOne
	private Categoria categoria = new Categoria();
	
	private Integer estoque;
	
	
	
	//constructors----------
	
	/**
	 * Construtor padr�o
	 */
	public Produto() {
	
	}
	
	
	/**
	 * Construtor recebendo apenas o id
	 * @param id
	 */
	public Produto(int id) {
		
		this.id = id;
	}
	
	
	/**
	 * Construtor recebendo todos os atributos.
	 * @param id
	 * @param denominacao
	 * @param descricao
	 * @param preco
	 */
	public Produto(int id, String denominacao, String descricao, Double preco, Integer estoque) {
		this.id = id;
		this.denominacao = denominacao;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}


	

	//getters and setters ----- 
	
	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	

	public Integer getEstoque() {
		return estoque;
	}


	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	} 
	
	

}