package br.com.m7;

/**
 *  @author jailson
 *  
 *  @version 1.0
 *  
 *  @see br.com.m7.Pessoa
 */
public class Professor {
	
	private Pessoa pessoa;
	
	public Professor() {
		pessoa = new Pessoa();
	}
	
	public Pessoa getPessoa() {
        return pessoa;
    }

    public int getCod() {
        return pessoa.getCod();
    }

    public void setCod(int cod) {
        pessoa.setCod(cod);
    }

    public String getNome() {
        return pessoa.getNome();
    }

    public void setNome(String nome) {
        pessoa.setNome(nome);
    }

    public String getCurso() {
        return pessoa.getCurso();
    }

    public void setCurso(String curso) {
        pessoa.setCurso(curso);
    }

    /**
     * Método para pegar os dados do professor
     * 
     * @return retorna os dados do professor
     * 
     */
    public String dadosProfessor() {
        return pessoa.dadosPessoa();
    }
}
