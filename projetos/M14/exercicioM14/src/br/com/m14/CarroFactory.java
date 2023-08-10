package br.com.m14;

public class CarroFactory {
	
	public static Carro newCarro(String fabricante) {
		if(fabricante.equals("Toyota")) {
			return new Toyota();
		} else if (fabricante.equals("Honda")) {
			return new Honda();
		} else {
			throw new IllegalArgumentException("fabricante invalido!!");
		}
	}
}
