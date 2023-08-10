package br.com.m17;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Carro> listaCarro = new ArrayList<>();
		
		listaCarro.add(new Honda("Civic"));
		listaCarro.add(new Toyota("Corolla"));
		listaCarro.add(new Honda("Fit"));
		
		for (Carro carro : listaCarro) {
			carro.exibirDetalhes();
		}
	}
}
