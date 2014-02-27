package it.strazz.components.marsrover.model;

/**
 * A Command useb by a {@link MarsRoverModel} to move the {@link Rover}
 *
 * @author Francesco.Strazzullo
 *
 */
public interface MovementCommand {
	public void moveTo(Rover rover);
}
