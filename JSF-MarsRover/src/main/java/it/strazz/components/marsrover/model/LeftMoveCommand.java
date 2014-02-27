package it.strazz.components.marsrover.model;

/**
 * A {@link MovementCommand} that makes the {@link Rover} turn left
 *
 * @author Francesco.Strazzullo
 *
 */
public class LeftMoveCommand implements MovementCommand {
	public void moveTo(Rover rover) {
		switch (rover.getDirection()) {
		case NORTH:
			rover.setDirection(Directions.WEST);
			break;
		case EAST:
			rover.setDirection(Directions.NORTH);
			break;
		case SOUTH:
			rover.setDirection(Directions.EAST);
			break;
		case WEST:
			rover.setDirection(Directions.SOUTH);
			break;
		}
	}
}
