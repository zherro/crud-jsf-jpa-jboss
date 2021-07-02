package br.com.zherro.crudjsf.converter;

import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import br.com.zherro.crudjsf.model.Author;

@FacesConverter(value="author", forClass=Author.class) 
public class AuthorConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Object ret = null; 
		if (component instanceof PickList) { 
			Object dualList = ((PickList) component).getValue(); 
			
			@SuppressWarnings("unchecked")
			DualListModel<Author> dl =  (DualListModel<Author>) dualList; 
			
			for (Iterator<Author> iterator = dl.getSource().iterator(); iterator.hasNext();) { 
				Object o = iterator.next(); 
				String id = (new StringBuilder()).append(((Author) o).getId()).toString(); 
				if (value.equals(id)) { 
					ret = o; 
					break; 
				} 
			} 

			if (ret == null) { 
				for (Iterator<Author> iterator1 = dl.getTarget().iterator(); iterator1 .hasNext();) { 
					Object o = iterator1.next(); 
					String id = (new StringBuilder()).append(((Author) o).getId()).toString(); 
					if (value.equals(id)) { 
						ret = o; 
						break; 
					} 
				} 
			} 
		} 
		return ret; 
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object != null && object instanceof Author) {
			return ((Author)object).getId().toString();
		}
		return null;
	}

}