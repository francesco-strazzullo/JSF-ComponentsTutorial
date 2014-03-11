package it.strazz.faces.examples;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

@FacesComponent(value=HelloWorld.COMPONENT_TYPE)
public class HelloWorld extends UIComponentBase{
	
	public static final String COMPONENT_TYPE = "it.strazz.faces.HelloWorld";
	public static final String COMPONENT_FAMILY = "it.strazz.faces.components";

	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	public void encodeEnd(FacesContext context) throws IOException {
		context.getResponseWriter().write("<div id=\"" + this.getClientId() + "\">Hello World!</div>");
	}
}
