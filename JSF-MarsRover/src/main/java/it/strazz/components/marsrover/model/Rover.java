package it.strazz.components.marsrover.model;


import java.io.Serializable;

/**
 * Pojo that holds the information of a Rover. A Rover it's identified by:
 *
 * <ul>
 * 	<li>x position</li>
 * 	<li>y position</li>
 * 	<li>the direction the rover is facing</li>
 * </ul>
 *
 * @author Francesco.Strazzullo
 *
 */
public class Rover implements Serializable{

	private static final long serialVersionUID = -2952863674907315523L;

	private int x = 0;
	private int y = 0;
	private Directions direction = Directions.NORTH;

	public Rover() {}

	public Rover(int x, int y, Directions direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Directions getDirection() {
		return this.direction;
	}

	public void setDirection(Directions direction) {
		this.direction = direction;
	}

	public String toString() {
		return this.x + " " + this.y + this.direction;
	}

}
