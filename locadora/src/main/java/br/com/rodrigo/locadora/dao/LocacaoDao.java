package br.com.rodrigo.locadora.dao;

import br.com.rodrigo.locadora.modelo.Locacao;

public class LocacaoDao extends GenericDao<Locacao, Long> {

	public LocacaoDao() {
		super(Locacao.class);
	}
}