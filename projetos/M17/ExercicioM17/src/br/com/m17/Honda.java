package br.com.m17;

class Honda extends Carro {
	
	public Honda(String modelo) {
		super("Honda", modelo);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void exibirDetalhes() {
		System.out.println("Marca: " + getMarca() + ", Modelo: " + getModelo());
		
	}

}
