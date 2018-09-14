package br.com.rodrigo.locadora.dao;

import br.com.rodrigo.locadora.modelo.Funcionario;

public class FuncionarioDao extends GenericDao<Funcionario, Long> {

	public FuncionarioDao() {
		super(Funcionario.class);
	}
}