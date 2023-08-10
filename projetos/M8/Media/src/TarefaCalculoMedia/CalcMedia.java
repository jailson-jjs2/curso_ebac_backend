package TarefaCalculoMedia;

public class CalcMedia {

	public static void main(String[] args) {
	
		mediaNota();
		
	}
	private static void mediaNota() {
		int nota1 = 7;
		int nota2 = 8;
		int nota3 = 8;
		int nota4 = 9;
		
		int total = (nota1 + nota2 + nota3 + nota4);
		
		int media = (total / 4);
		
		System.out.println("Valor da média: " + media);
	}
	
}
