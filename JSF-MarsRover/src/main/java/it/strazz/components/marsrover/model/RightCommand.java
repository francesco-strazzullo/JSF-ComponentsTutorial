package it.strazz.components.marsrover.model;

/**
 * A {@link MovementCommand} that makes the {@link Rover} turn right
 *
 * @author Francesco.Strazzullo
 *
 */
public class RightCommand implements MovementCommand {

	public void moveTo(Rover rover) {
		switch (rover.getDirection()) {
		case NORTH:
			rover.setDirection(Directions.EAST);
			break;
		case EAST:
			rover.setDirection(Directions.SOUTH);
			break;
		case SOUTH:
			rover.setDirection(Directions.WEST);
			break;
		case WEST:
			rover.setDirection(Directions.NORTH);
			break;
		}
	}

}
