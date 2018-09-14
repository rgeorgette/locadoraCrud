package br.com.rodrigo.locadora.dao;

import br.com.rodrigo.locadora.modelo.Veiculo;

public class VeiculoDao extends GenericDao<Veiculo, Long> {

	public VeiculoDao() {
		super(Veiculo.class);
	}
}