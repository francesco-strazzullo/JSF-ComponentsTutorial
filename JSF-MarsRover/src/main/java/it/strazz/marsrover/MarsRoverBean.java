package it.strazz.marsrover;
import it.strazz.components.marsrover.model.Directions;
import it.strazz.components.marsrover.model.MarsRoverModel;
import it.strazz.components.marsrover.model.Rover;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.EnumConverter;
import javax.faces.model.SelectItem;
import javax.faces.validator.LongRangeValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean
@ViewScoped
public class MarsRoverBean {

	private static final int DEFAULT_SIZE = 5;

	private MarsRoverModel model = new MarsRoverModel(DEFAULT_SIZE,DEFAULT_SIZE);
	private Integer xSize = DEFAULT_SIZE;
	private Integer ySize = DEFAULT_SIZE;
	private Integer xRoverPosition;
	private Integer yRoverPosition;
	private Directions roverDirection;
	private EnumConverter directionConverter = new EnumConverter(Directions.class);
	private String command;

	public Directions getRoverDirection() {
		return this.roverDirection;
	}

	public void setRoverDirection(Directions direction) {
		this.roverDirection = direction;
	}

	public Integer getxRoverPosition() {
		return this.xRoverPosition;
	}

	public void setxRoverPosition(Integer x) {
		this.xRoverPosition = x;
	}

	public Integer getyRoverPosition() {
		return this.yRoverPosition;
	}

	public void setyRoverPosition(Integer y) {
		this.yRoverPosition = y;
	}

	public MarsRoverModel getModel() {
		return this.model;
	}

	public void setModel(MarsRoverModel model) {
		this.model = model;
	}

	public EnumConverter getDirectionConverter() {
		return this.directionConverter;
	}

	/**
	 * create a new {@link MarsRoverModel}
	 */
	public void newModel(){
		this.model = new MarsRoverModel(this.xSize,this.ySize);
	}

	/**
	 * Add a rover to the {@link #getModel()}
	 */
	public void addRover(){
		this.model.addRover(new Rover(this.xRoverPosition, this.yRoverPosition, this.roverDirection));
		this.xRoverPosition = null;
		this.yRoverPosition = null;
		this.roverDirection = null;
	}

	/**
	 * Send a command to the {@link #getModel()}
	 */
	public void sendCommand(){
		this.model.sendCommand(this.command);
		this.command = null;
	}

	public List<SelectItem> getDirections(){
		List<SelectItem> items = new ArrayList<SelectItem>(4);
		items.add(new SelectItem(Directions.NORTH, "North"));
		items.add(new SelectItem(Directions.EAST, "East"));
		items.add(new SelectItem(Directions.SOUTH, "South"));
		items.add(new SelectItem(Directions.WEST, "West"));
		return items;
	}

	public String getCommand() {
		return this.command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Integer getxSize() {
		return this.xSize;
	}

	public void setxSize(Integer size) {
		this.xSize = size;
	}

	public Integer getySize() {
		return this.ySize;
	}

	public void setySize(Integer ySize) {
		this.ySize = ySize;
	}

	 public void validateXRoverPosition(FacesContext context,UIComponent component,Object value) throws ValidatorException{
		 Validator v = new LongRangeValidator(this.model != null ? this.model.getxSize()-1 : 0, 0);
		 v.validate(context, component, value);
	 }

	 public void validateYRoverPosition(FacesContext context,UIComponent component,Object value) throws ValidatorException{
		 Validator v = new LongRangeValidator(this.model != null ? this.model.getySize()-1 : 0, 0);
		 v.validate(context, component, value);
	 }
}
