package br.com.m14;

public class Honda implements Carro {

	@Override
	public String getNome() {
		return "Honda";
	}

	@Override
	public String getModelo() {
		return "Civic";
	}

	@Override
	public String toString() {
		return "Fabricante = " + getNome() + ", Modelo = " + getModelo();
	}

}
