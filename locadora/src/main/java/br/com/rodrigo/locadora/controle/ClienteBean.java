package br.com.rodrigo.locadora.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.rodrigo.locadora.dao.ClienteDao;
import br.com.rodrigo.locadora.modelo.Cliente;

@ManagedBean(name = "clienteBean")
public class ClienteBean {

	private Cliente cliente = new Cliente();
	private ClienteDao clienteDao = new ClienteDao();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	

	public String salvar() {
		clienteDao.merge(cliente);
		listaClientes();
		return "clientes";
	}

	public void remover() {
		clienteDao.delete(cliente);
		listaClientes();
	}

	@PostConstruct
	public void listaClientes() {
		clientes = clienteDao.findAll();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
