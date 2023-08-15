package testes.mocks.service;

import testes.mocks.dao.IContratoDao;
import testes.mocks.dao.IContratoServide;

public class ContratoService implements IContratoServide {
	
	private IContratoDao contratoDao;

	public ContratoService(IContratoDao dao) {
		this.contratoDao = dao;
	}

	@Override
	public String salvar() {
		contratoDao.salvar();
		return "Sucesso";
	}

	@Override
	public String buscar() {
		contratoDao.buscar();
		return "Sucesso";
	}

	@Override
	public String atualizar() {
		contratoDao.atualizar();
		return "Sucesso";
	}

	@Override
	public String excluir() {
		contratoDao.excluir();
		return "Sucesso";
	}

}
