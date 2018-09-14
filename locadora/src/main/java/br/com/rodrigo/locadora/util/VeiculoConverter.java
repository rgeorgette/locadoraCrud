package br.com.rodrigo.locadora.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.rodrigo.locadora.dao.VeiculoDao;
import br.com.rodrigo.locadora.modelo.Veiculo;

@FacesConverter(forClass = Veiculo.class)
public class VeiculoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		Long id = Long.valueOf(value);
		return new VeiculoDao().findById(id);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		Veiculo veiculo = (Veiculo) value;
		return String.valueOf(veiculo.getId());

	}

}
