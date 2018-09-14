package br.com.rodrigo.locadora.controle;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.rodrigo.locadora.dao.ClienteDao;
import br.com.rodrigo.locadora.dao.FuncionarioDao;
import br.com.rodrigo.locadora.dao.LocacaoDao;
import br.com.rodrigo.locadora.dao.VeiculoDao;
import br.com.rodrigo.locadora.modelo.Cliente;
import br.com.rodrigo.locadora.modelo.Funcionario;
import br.com.rodrigo.locadora.modelo.Locacao;
import br.com.rodrigo.locadora.modelo.Veiculo;

@ManagedBean(name = "locacaoBean")
public class LocacaoBean {

	private Locacao locacao = new Locacao();
	private Cliente cliente = new Cliente();
	private LocacaoDao locacaoDao = new LocacaoDao();
	private List<Locacao> locacoes = new ArrayList<Locacao>();
	private List<Cliente> clientes;
	private List<Funcionario> funcionarios;
	private List<Veiculo> veiculos;

	public String salvar() {
		LocalDate dataInicio = locacao.getDataInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate dataFim = locacao.getDataFim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int qtdDiarias = Period.between(dataInicio, dataFim).getDays();
		locacao.setValorTotal(qtdDiarias*locacao.getVeiculo().getValorDiaria());
		locacaoDao.merge(locacao);
		listaLocacoes();
		return "locacao";
	}

	public List<Cliente> getClientes() {
		clientes = new ClienteDao().findAll();
		return clientes;
	}

	public List<Funcionario> getFuncionarios() {
		funcionarios = new FuncionarioDao().findAll();
		return funcionarios;
	}

	public List<Veiculo> getVeiculos() {
		veiculos = new VeiculoDao().findAll();
		return veiculos;
	}

	public void remover() {
		locacaoDao.delete(locacao);
		listaLocacoes();
	}

	@PostConstruct
	public void listaLocacoes() {
		locacoes = locacaoDao.findAll();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

}
