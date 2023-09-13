package br.com.jau;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.jau.dao.CursoDao;
import br.com.jau.dao.ICursoDao;
import br.com.jau.domain.Curso;

public class CursoTest {

    private ICursoDao cursoDao;
	
	public CursoTest() {
		cursoDao = new CursoDao();
	}
    
    @Test
    public void cadastrar() {
        Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("CURSO TESTE");
		curso.setNome("Curso de Java Backend");
		curso = cursoDao.cadastrar(curso);
		
		assertNotNull(curso);
		assertNotNull(curso.getId());
    }
}
