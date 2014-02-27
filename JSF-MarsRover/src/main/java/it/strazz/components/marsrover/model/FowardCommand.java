package it.strazz.components.marsrover.model;

/**
 * A {@link MovementCommand} that moves forward the {@link Rover}
 *
 * @author Francesco.Strazzullo
 *
 */
public class FowardCommand implements MovementCommand {

	private int xSize;
	private int ySize;

	public FowardCommand(int xSize,int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
	}

	public void moveTo(Rover rover) {
		switch (rover.getDirection()) {
		case SOUTH:
			if(rover.getY()>0){
				rover.setY(rover.getY()-1);
			}
			break;
		case EAST:
			if(rover.getX()<this.xSize-1){
				rover.setX(rover.getX()+1);
			}
			break;
		case NORTH:
			if(rover.getY()<this.ySize-1){
				rover.setY(rover.getY()+1);
			}
			break;
		case WEST:
			if(rover.getX()>0){
				rover.setX(rover.getX()-1);
			}
			break;
		}
	}

}
