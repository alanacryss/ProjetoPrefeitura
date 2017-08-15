package br.com.integrador.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.integrador.dao.PersistDB;

@Entity
public class Usuario implements PersistDB {

	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String comfirmSenha;
	private String cargo;
	private String setor;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getComfirmSenha() {
		return comfirmSenha;
	}
	public void setComfirmSenha(String comfirmSenha) {
		this.comfirmSenha = comfirmSenha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
