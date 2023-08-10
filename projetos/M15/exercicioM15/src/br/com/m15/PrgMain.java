package br.com.m14;

public class PrgMain {

	public static void main(String[] args) {
		Carro carro = CarroFactory.newCarro("Toyota");
		System.out.println(carro);
	}
}
