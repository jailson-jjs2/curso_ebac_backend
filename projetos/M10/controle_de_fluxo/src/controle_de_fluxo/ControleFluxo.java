package controle_de_fluxo;

import java.util.Scanner;

public class ControleFluxo {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
				
		System.out.println("Digite as notas de Nota 1 a Nota 4 : ");
		
		double nota1 = input.nextInt();
		double nota2 = input.nextInt();
		double nota3 = input.nextInt();
		double nota4 = input.nextInt();
		
		double media = (nota1 + nota2 + nota3 + nota4 ) / 4;
		
		String resultado = getResult(media);
		System.out.println(resultado);
	}
	
	public static String getResult(double media) {
		if (media < 5 && media > 0) {
			return "Aluno reprovado com a média: " + media;
		} else if (media >= 5 && media < 7) {
			return "Aluno em recuperação coma média: " + media;
		} else if (media >= 7 && media <= 10) {
			return "Aluno aprovado com a média: " + media;
		} else {
			return "Nota invalida, valor: " + media;
		}
	}
}
