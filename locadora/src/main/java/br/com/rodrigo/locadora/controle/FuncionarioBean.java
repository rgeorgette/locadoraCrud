package br.com.rodrigo.locadora.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.rodrigo.locadora.dao.FuncionarioDao;
import br.com.rodrigo.locadora.modelo.Funcionario;

@ManagedBean(name = "funcionarioBean")
public class FuncionarioBean {

	private Funcionario funcionario = new Funcionario();
	private FuncionarioDao funcionarioDao = new FuncionarioDao();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public String salvar() {
		funcionarioDao.merge(funcionario);
		listaFuncionarios();
		return "funcionarios";
	}

	public void remover() {
		funcionarioDao.delete(funcionario);
		listaFuncionarios();
	}

	@PostConstruct
	public void listaFuncionarios() {
		funcionarios = funcionarioDao.findAll();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
