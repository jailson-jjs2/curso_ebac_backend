package br.com.m17;

class Toyota extends Carro {

	public Toyota(String modelo) {
		super("Toyota", modelo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void exibirDetalhes() {
		System.out.println("Marca: " + getMarca() + ", Modelo: " + getModelo());
		
	}

}
