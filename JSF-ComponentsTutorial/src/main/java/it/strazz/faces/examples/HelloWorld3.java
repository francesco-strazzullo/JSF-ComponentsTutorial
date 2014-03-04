package it.strazz.faces.examples;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

@FacesComponent(value=HelloWorld3.COMPONENT_TYPE)
@ResourceDependencies({
	@ResourceDependency(name="examples.css"),
	@ResourceDependency(name="examples.js")
})
public class HelloWorld3 extends UIComponentBase{
	
	public static final String COMPONENT_TYPE = "it.strazz.faces.HelloWorld3";
	public static final String COMPONENT_FAMILY = "it.strazz.faces.components";

	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		context.getResponseWriter().write("<div id='" + this.getClientId() + " onclick='exampleFunction();' class='hello'>Hello " + getName() + "! (with resources)</div>");
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
