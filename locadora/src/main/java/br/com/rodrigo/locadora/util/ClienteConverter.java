package br.com.rodrigo.locadora.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.rodrigo.locadora.dao.ClienteDao;
import br.com.rodrigo.locadora.modelo.Cliente;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		Long id = Long.valueOf(value);
		return new ClienteDao().findById(id);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		Cliente cliente = (Cliente) value;
		return String.valueOf(cliente.getId());

	}

}
