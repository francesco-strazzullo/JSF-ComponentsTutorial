package it.strazz.faces.examples;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(componentFamily=HelloWorld4.COMPONENT_FAMILY,rendererType=HelloWorld4Renderer.RENDERER_TYPE)
public class HelloWorld4Renderer extends Renderer {
	
	public static final String RENDERER_TYPE = "it.strazz.faces.HelloWorld4Renderer";

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		HelloWorld4 helloWorld4 = (HelloWorld4) component;
		context.getResponseWriter().write("<div id='" + helloWorld4.getClientId() + " onclick='exampleFunction();' class='hello'>Hello " + helloWorld4.getName() + "! (with renderer)</div>");
	}
	
}
