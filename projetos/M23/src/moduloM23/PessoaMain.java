package moduloM23;

import java.util.ArrayList;
import java.util.List;


public class PessoaMain {
	

	public static void main(String[] args) {

		List<Pessoa> listaPessoas = new ArrayList<>();
		listaPessoas.add(new Pessoa("Jailson", 40, "M"));
		listaPessoas.add(new Pessoa("Renata", 38, "F"));
		listaPessoas.add(new Pessoa("Tiago", 20, "M"));
		listaPessoas.add(new Pessoa("Bel", 39, "F"));
		
		System.out.println("Lista de Todos");
		
		for (Pessoa pessoa : listaPessoas) {
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Idade: " + pessoa.getIdade());
			System.out.println("Sexo: " + pessoa.getSexo());
			System.out.println();
			
		}
		//**********************************************//
		System.out.println("*** MULHERES ***");
		
		listaPessoas.stream()
		.filter(pessoa -> pessoa.getSexo().equals("F"))
		.forEach(mulher -> {
			System.out.println("Nome: " + mulher.getNome());
			System.out.println("Sexo: " + mulher.getSexo());
			System.out.println("Idade: " + mulher.getIdade());
			System.out.println();
		});

	}

}
