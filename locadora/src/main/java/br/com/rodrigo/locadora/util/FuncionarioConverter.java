package br.com.rodrigo.locadora.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.rodrigo.locadora.dao.FuncionarioDao;
import br.com.rodrigo.locadora.modelo.Funcionario;

@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		Long id = Long.valueOf(value);
		return new FuncionarioDao().findById(id);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		Funcionario funcionario = (Funcionario) value;
		return String.valueOf(funcionario.getId());

	}

}
