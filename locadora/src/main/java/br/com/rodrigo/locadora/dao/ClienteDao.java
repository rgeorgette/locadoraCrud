package br.com.rodrigo.locadora.dao;

import br.com.rodrigo.locadora.modelo.Cliente;

public class ClienteDao extends GenericDao<Cliente, Long> {

	public ClienteDao() {
		super(Cliente.class);
	}
}