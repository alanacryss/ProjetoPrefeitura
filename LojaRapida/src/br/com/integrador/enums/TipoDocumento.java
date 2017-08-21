package br.com.integrador.enums;

public enum TipoDocumento {
	OFICIO("Oficio"), EDITAL("Edital"), MEMORANDO("Memorando"), PORTARIA("Portaria");
	
	private String nome;
	
	TipoDocumento(String nomeDoc) {
		nome = nomeDoc;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
