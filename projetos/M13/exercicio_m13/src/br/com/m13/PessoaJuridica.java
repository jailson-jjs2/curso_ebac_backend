package br.com.m13;

public class PessoaJuridica extends Pessoa {

	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public void imprimir() {
		System.out.println("Nome: " + getNome());
		System.out.println("CNPJ: " + getCnpj());
		System.out.println();
	}
	
}
