package br.com.rodrigo.locadora.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.rodrigo.locadora.dao.VeiculoDao;
import br.com.rodrigo.locadora.modelo.Veiculo;

@ManagedBean(name = "veiculoBean")
public class VeiculoBean {

	private Veiculo veiculo = new Veiculo();
	private VeiculoDao veiculoDao = new VeiculoDao();
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();

	public String salvar() {
		veiculoDao.merge(veiculo);
		listaVeiculos();
		return "veiculos";
	}

	public void remover() {
		veiculoDao.delete(veiculo);
		listaVeiculos();
	}

	@PostConstruct
	public void listaVeiculos() {
		veiculos = veiculoDao.findAll();
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
