package br.com.m17;

abstract class Carro {
	
	private String marca;
	private String modelo;
	
	public Carro(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}


	public String getModelo() {
		return modelo;
	}

	
	public abstract void exibirDetalhes();
	
}
