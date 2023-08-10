package br.com.m13;

public class PrgMain {

	public static void main(String[] args) {
		
		PessoaFisica pf = new PessoaFisica();
		
		pf.setNome("Jailson");
		pf.setCpf("999.999.999-99");
		
		PessoaJuridica pj = new PessoaJuridica();
		
		pj.setNome("JJS Desenvolvimentos");
		pj.setCnpj("00.394.460/0058-87");
		
		imprimir(pf);
		imprimir(pj);
		
	}
	
	public static void imprimir(Pessoa pessoa) {
		pessoa.imprimir();
	}

}
