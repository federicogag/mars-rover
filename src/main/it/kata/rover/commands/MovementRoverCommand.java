package main.it.kata.rover.commands;

import main.it.kata.rover.ObstacleDetectedException;
import main.it.kata.rover.Planet;
import main.it.kata.rover.Position;

/**
 * Class representing a move rover command. It contains additional methods
 * for calculating the new position
 *
 */
public abstract class MovementRoverCommand extends RoverCommand {

	public MovementRoverCommand(char commandCode) {
		super(commandCode);
	}
	
	
	/**
	 * Increases the X axis value by one unit.
	 * If the increment brings the new position outside the planet grid map, the X axis value is set to 0.
	 * @param planet planet where the move is to be made
	 * @param position the position from which to calculate the increment
	 * @return the calculated position
	 * @throws ObstacleDetectedException if the new position represents the position of an obstacle in the planet passed as a parameter
	 */
	public Position incrementX(Planet planet, Position position) throws ObstacleDetectedException {
		
		Position nextPosition = new Position(position.getX() + 1, position.getY());
		
		if(nextPosition.getX() > planet.getMaxY())
			nextPosition.setX(0);
		
		if(planet.isObstacle(nextPosition))
			throw new ObstacleDetectedException(nextPosition);
		
		return nextPosition;
	}
	
	
	/**
	 * Decreases the X axis value by one unit.
	 * If the decrease brings the new position outside the planet grid map, the X axis value is set to the maximum X value of the planet.
	 * @param planet planet where the move is to be made
	 * @param position the position from which to calculate the increment
	 * @return the calculated position
	 * @throws ObstacleDetectedException if the new position represents the position of an obstacle in the planet passed as a parameter
	 */
	public Position decrementX(Planet planet, Position position) throws ObstacleDetectedException {
		
		Position nextPosition = new Position(position.getX() - 1, position.getY());
		
		if(nextPosition.getX() < 0)
			nextPosition.setX(planet.getMaxX());
		
		if(planet.isObstacle(nextPosition))
			throw new ObstacleDetectedException(nextPosition);
		
		return nextPosition;
	}
	
	
	/**
	 * Increases the Y axis value by one unit.
	 * If the increment brings the new position outside the planet grid map, the Y axis value is set to 0.
	 * @param planet planet where the move is to be made
	 * @param position the position from which to calculate the increment
	 * @return the calculated position
	 * @throws ObstacleDetectedException if the new position represents the position of an obstacle in the planet passed as a parameter
	 */
	public Position incrementY(Planet planet, Position position) throws ObstacleDetectedException {
		
		Position nextPosition = new Position(position.getX(), position.getY() + 1);
		
		if(nextPosition.getY() > planet.getMaxY())
			nextPosition.setY(0);
		
		if(planet.isObstacle(nextPosition))
			throw new ObstacleDetectedException(nextPosition);
		
		return nextPosition;
	}
	
	
	/**
	 * Decreases the Y axis value by one unit.
	 * If the decrease brings the new position outside the planet grid map, the Y axis value is set to the maximum Y value of the planet.
	 * @param planet planet where the move is to be made
	 * @param position the position from which to calculate the increment
	 * @return the calculated position
	 * @throws ObstacleDetectedException if the new position represents the position of an obstacle in the planet passed as a parameter
	 */
	public Position decrementY(Planet planet, Position position) throws ObstacleDetectedException {
		
		Position nextPosition = new Position(position.getX(), position.getY() - 1);
		
		if(nextPosition.getY() < 0)
			nextPosition.setY(planet.getMaxY());
		
		if(planet.isObstacle(nextPosition))
			throw new ObstacleDetectedException(nextPosition);

		return nextPosition;
	}
	
}
