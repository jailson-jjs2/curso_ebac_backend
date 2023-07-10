package br.com.m13;

public class Pessoa {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void imprimir() {
		System.out.println("Nome: " + getNome());
	}

}
