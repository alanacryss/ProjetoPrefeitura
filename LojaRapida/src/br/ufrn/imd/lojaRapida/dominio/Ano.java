package br.ufrn.imd.lojaRapida.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ano {
	
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name="ano")
	private String ano;
	
//	@Column(name="numeros")
//	private List<Integer> numeros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

//	public List<Integer> getNumeros() {
//		if(numeros == null)
//			return new ArrayList<Integer>();
//		return numeros;
//	}
//
//	public void setNumeros(List<Integer> numeros) {
//		this.numeros = numeros;
//	}
	
}
