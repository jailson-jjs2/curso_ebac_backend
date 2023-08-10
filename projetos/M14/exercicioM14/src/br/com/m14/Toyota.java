package br.com.m14;

public class Toyota implements Carro {

	@Override
	public String getNome() {
		return "Toyota";

	}

	@Override
	public String getModelo() {
		return "Corolla";
	}

	@Override
	public String toString() {
		return "Fabricante = " + getNome() + ", Modelo = " + getModelo();
	}

}
