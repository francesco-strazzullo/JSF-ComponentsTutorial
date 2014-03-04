package it.strazz.faces.examples;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

@FacesComponent(value=HelloWorld4.COMPONENT_TYPE)
@ResourceDependencies({
	@ResourceDependency(name="examples.css"),
	@ResourceDependency(name="examples.js")
})
public class HelloWorld4 extends UIComponentBase{
	
	public static final String COMPONENT_TYPE = "it.strazz.faces.HelloWorld4";
	public static final String COMPONENT_FAMILY = "it.strazz.faces.components";

	public String getFamily() {
		return COMPONENT_FAMILY;
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
