package it.strazz.faces.examples;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

@FacesComponent(value=HelloWorld2.COMPONENT_TYPE)
public class HelloWorld2 extends UIComponentBase{
	
	public static final String COMPONENT_TYPE = "it.strazz.faces.HelloWorld2";
	public static final String COMPONENT_FAMILY = "it.strazz.faces.components";

	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		context.getResponseWriter().write("<div id=\"" + this.getClientId() + "\">Hello " + getName() + "!</div>");
	}
	
	public String getName(){
		return (String) this.getStateHelper().eval(PropertyKeys.name,"World");
	}
	
	public void setName(String name){
		this.getStateHelper().put(PropertyKeys.name, name);
	}
	
	protected static enum PropertyKeys{
		name;
	}
}
