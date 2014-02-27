package it.strazz.components.marsrover;

import it.strazz.components.marsrover.model.Directions;
import it.strazz.components.marsrover.model.MarsRoverModel;
import it.strazz.components.marsrover.model.Rover;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import org.primefaces.renderkit.CoreRenderer;

/**
 * {@link Renderer} of {@link MarsRoverRenderer} that uses Raphael to create a grid for displaying the
 * position of {@link MarsRoverModel#getRovers()}
 *
 * @author Francesco.Strazzullo
 *
 */
public class MarsRoverRenderer extends CoreRenderer {

	public static final String RENDERER_TYPE = "it.strazz.marsrover.MarsRoverRenderer";

	private final static Map<Directions, String> directionsNames = new HashMap<Directions, String>(4);
	static{
		directionsNames.put(Directions.NORTH, "N");
		directionsNames.put(Directions.EAST, "E");
		directionsNames.put(Directions.SOUTH, "S");
		directionsNames.put(Directions.WEST, "W");
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if(component.isRendered()){

		}
		MarsRover marsRover = (MarsRover) component;
		ResponseWriter writer = context.getResponseWriter();
		this.econdeMarkup(writer,context,marsRover);
		this.encodeScript(writer,context,marsRover);
	}

	private void encodeScript(ResponseWriter writer, FacesContext context,MarsRover marsRover) throws IOException {

		MarsRoverModel model = (MarsRoverModel) marsRover.getValue();
		if(model != null){
			this.startScript(writer, marsRover.getClientId());
			writer.write("$(function(){var " + marsRover.resolveWidgetVar() + " = new MarsRover('" + marsRover.getClientId() + "'," + model.getxSize() + "," +  model.getySize() + ");" + marsRover.resolveWidgetVar() + ".drawBoard();");
			int i = 0;
			for (Rover rover : model.getRovers()) {
				writer.write("" + marsRover.resolveWidgetVar() + ".drawRover(" + rover.getX() + "," + rover.getY() + ",'" + directionsNames.get(rover.getDirection()) + "'," + i + ");");
				i++;
			}
			writer.write("});");
			this.endScript(writer);
		}

	}

	private ResponseWriter econdeMarkup(ResponseWriter writer, FacesContext context,MarsRover marsRover) throws IOException {
		writer.startElement("div", marsRover);
	    writer.writeAttribute("id", marsRover.getClientId(), "id");
	    writer.endElement("div");
		return writer;
	}

}
