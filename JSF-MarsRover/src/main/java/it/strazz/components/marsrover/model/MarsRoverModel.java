package it.strazz.components.marsrover.model;


import it.strazz.components.marsrover.MarsRover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Model of the {@link MarsRover} component.
 * It hold the size of the grid and the current positions of the Rovers
 *
 * @author Francesco.Strazzullo
 *
 */
public class MarsRoverModel {

	private int xSize;
	private int ySize;
	private Stack<Rover> rovers = new Stack<Rover>();

	public static final char LEFT_COMMAND = 'L';
	public static final char RIGHT_COMMAND = 'R';
	public static final char MOVE_COMMAND = 'M';

	private Map<Character,MovementCommand> commandTranslations = new HashMap<Character, MovementCommand>(3);

	public MarsRoverModel(int xSize,int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.initCommands();
	}

	private void initCommands() {
		this.commandTranslations.put(LEFT_COMMAND, new LeftMoveCommand());
		this.commandTranslations.put(RIGHT_COMMAND, new RightCommand());
		this.commandTranslations.put(MOVE_COMMAND, new FowardCommand(this.xSize,this.ySize));
		//Here you can add more Command (Example 'S' -> new ResetPositionCommand()),(Example 'T' -> new TurnBackCommand());
	}

	/**
	 * add a {@link Rover}
	 */
	public void addRover(Rover rover){
		this.rovers.push(rover);
	}

	/**
	 * Send a moveCommand to the last {@link Rover}.
	 * @param commandExpr command to be parsed
	 */
	public void sendCommand(String commandExpr){
		if(this.rovers.empty()){
			throw new IllegalStateException("no rovers to move");
		}else{

			char[] inputCommands = commandExpr.toUpperCase().toCharArray();
			for (char inputCommand : inputCommands) {
				if(this.commandTranslations.containsKey(inputCommand)){
					this.commandTranslations.get(inputCommand).moveTo(this.rovers.peek());
				}else{
					FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_WARN, "'" + inputCommand + "' is not a valid command", null);
					FacesContext.getCurrentInstance().addMessage(null, m);
				}
			}
		}
	}

	/**
	 * @return un unmodifiable List that contains all the Rovers
	 */
	public List<Rover> getRovers(){
		return Collections.unmodifiableList(new ArrayList<Rover>(this.rovers));
	}

	public int getxSize() {
		return this.xSize;
	}

	public int getySize() {
		return this.ySize;
	}

}
