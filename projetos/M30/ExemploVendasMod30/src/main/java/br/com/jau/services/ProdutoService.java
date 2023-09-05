/**
 * 
 */
package br.com.jau.services;

import br.com.jau.dao.IProdutoDAO;
import br.com.jau.domain.Produto;
import br.com.jau.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
