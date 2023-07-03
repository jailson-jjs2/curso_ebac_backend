package br.com.m7;

/**
 *  @author jailson
 *  
 *  @version 1.0
 */
public class Pessoa {
	
	 private int cod;
	    private String nome;
	    private String curso;

	    public int getCod() {
	        return cod;
	    }

	    public void setCod(int cod) {
	        this.cod = cod;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getCurso() {
	        return curso;
	    }

	    public void setCurso(String curso) {
	        this.curso = curso;
	    }

	    public String dadosPessoa() {
	        return "Código.: " + getCod() + "\n" +
	               "Nome...: " + getNome() + "\n" +
	               "Curso..: " + getCurso();
	    }

}
