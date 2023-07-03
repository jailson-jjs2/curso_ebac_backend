package br.com.m7;

/**
 *  @author jailson
 *  
 *  @version 1.0
 */
public class Principal {

	public static void main(String[] args) {
		
		
		Aluno aluno = new Aluno();
		aluno.setCod(1);
		aluno.setNome("Jailson");
		aluno.setCurso("BackEnd");
		
		Professor professor = new Professor();
		professor.setCod(1);
		professor.setNome("Guga");
		professor.setCurso("BackEnd");

		System.out.println(aluno.dadosAluno());
		System.out.println();
		System.out.println(professor.dadosProfessor());
		

	}

}
