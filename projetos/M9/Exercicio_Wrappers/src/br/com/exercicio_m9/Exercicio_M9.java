package br.com.exercicio_m9;

public class Exercicio_M9 {

	int valorPrimitivo = 20;
	Integer valorWrapper = valorPrimitivo;
	
	double valorPrimitivo2 = 7.5;
	Double valorWrapper2 = valorPrimitivo2;
	
	public static void main(String[] args) {
		
		Exercicio_M9 exercicio = new Exercicio_M9();
		
		System.out.println(exercicio.valorPrimitivo);
		System.out.println(exercicio.valorWrapper);
		
		System.out.println(exercicio.valorPrimitivo2);
		System.out.println(exercicio.valorWrapper2);
	}
	

}
