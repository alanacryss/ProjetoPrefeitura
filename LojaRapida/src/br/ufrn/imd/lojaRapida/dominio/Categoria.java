package br.ufrn.imd.lojaRapida.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.ufrn.imd.lojaRapida.dao.CategoriaDAO;
import br.ufrn.imd.lojaRapida.dao.PersistDB;

/**
 * Representa a categoria de um produto.
 * @author Usuario
 *
 */
@Entity
public class Categoria implements PersistDB {
	
	/**
	 * Identificador unico de uam categoria de produto
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Denomina��o da categoria do produto
	 */
	private String denominacao;
	
	/**
	 * texto descritivo da categoria que ir� aparecer para o cliente 
	 */
	private String descricao;
	
	//Constructors
	
	/**
	 * Construtor Padr�o
	 */
	public Categoria() {
	
	}
	
	/**
	 * Construtor recebendo apenas o id
	 * @param id
	 */
	public Categoria(int id) {
		super();
		this.id = id;
	}
	
	/**
	 * Construtor recebendo todos os atributos.
	 * @param id
	 * @param denominacao
	 */
	public Categoria(int id, String denominacao, String descricao) {
		super();
		this.id = id;
		this.denominacao = denominacao;
		this.descricao = descricao;
	}

	
	
	//getters and setters -------
	
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
	
	

	public static void main(String[] args) {
		Categoria c = new Categoria();
		
		c.setDenominacao("Inform�tica");
		c.setDescricao("Nesta categoria voc� encontra o melhor da inform�tica nos melhores pre�os, � tecnologia de ponta ao seu alcance.");
		
		CategoriaDAO catgDao = new CategoriaDAO();
		
		catgDao.create(c);
		
	}
	
	@Override
	public String toString() {
		
		return denominacao;
	}
	
	

}
