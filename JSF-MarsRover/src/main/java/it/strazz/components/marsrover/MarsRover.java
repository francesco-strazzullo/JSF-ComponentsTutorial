package it.strazz.components.marsrover;

import it.strazz.components.marsrover.model.MarsRoverModel;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UINamingContainer;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.Widget;

/**
 * Component used to display the information of a {@link MarsRoverModel}
 *
 * @author Francesco.Strazzullo
 *
 */
@ResourceDependencies({
	@ResourceDependency(library="marsrover",name="marsRover.js"),
	@ResourceDependency(library="primefaces", name="raphael/raphael.js"),
})
public class MarsRover extends UIOutput implements Widget {

	public static String COMPONENT_TYPE = "it.strazz.marsrover.MarsRover";
	public static String COMPONENT_FAMILY = "it.strazz.marsrover.Output";
	private static final String OPTIMIZED_PACKAGE = "it.strazz.components.";

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	protected enum PropertyKeys {

		widgetVar;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}
	}


	public MarsRover() {
		this.setRendererType(MarsRoverRenderer.RENDERER_TYPE);
	}

	public java.lang.String getWidgetVar() {
		return (java.lang.String) this.getStateHelper().eval(PropertyKeys.widgetVar, null);
	}

	public void setWidgetVar(java.lang.String _widgetVar) {
		this.getStateHelper().put(PropertyKeys.widgetVar, _widgetVar);
		this.handleAttribute("widgetVar", _widgetVar);
	}

	public void handleAttribute(String name, Object value) {
		List<String> setAttributes = (List<String>) this.getAttributes().get("javax.faces.component.UIComponentBase.attributesThatAreSet");
		if(setAttributes == null) {
			String cname = this.getClass().getName();
			if(cname != null && cname.startsWith(OPTIMIZED_PACKAGE)) {
				setAttributes = new ArrayList<String>(6);
				this.getAttributes().put("javax.faces.component.UIComponentBase.attributesThatAreSet", setAttributes);
			}
		}
		if(setAttributes != null) {
			if(value == null) {
				ValueExpression ve = this.getValueExpression(name);
				if(ve == null) {
					setAttributes.remove(name);
				} else if(!setAttributes.contains(name)) {
					setAttributes.add(name);
				}
			}
		}
	}

	public String resolveWidgetVar() {
		FacesContext context = FacesContext.getCurrentInstance();
		String userWidgetVar = (String) this.getAttributes().get("widgetVar");

		if(userWidgetVar != null)
			return userWidgetVar;
		 else
			return "widget_" + this.getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}


}