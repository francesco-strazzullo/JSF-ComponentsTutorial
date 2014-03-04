package it.strazz.faces.examples;

import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

@FacesComponent(value=Clock.COMPONENT_TYPE)
@ResourceDependency(name="coolclock.js")
public class Clock extends UIComponentBase {

	public static final String COMPONENT_TYPE = "it.strazz.faces.Clock";
	public static final String COMPONENT_FAMILY = "it.strazz.faces.components";
	
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	public boolean isDigital(){
		return Boolean.TRUE.equals(this.getStateHelper().eval(PropertyKeys.digital, true));
	}
	
	public void setDigital(boolean digital){
		this.getStateHelper().put(PropertyKeys.digital, digital);
	}
	
	protected static enum PropertyKeys{
		digital;
	}

}
