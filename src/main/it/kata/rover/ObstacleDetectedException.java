package main.it.kata.rover;

/**
 * Exception that represents an obstacle detected
 */
public class ObstacleDetectedException extends Exception {

	private static final long serialVersionUID = 1L;

	public ObstacleDetectedException(Position obstaclePosition) {
		super("Obstacle detected at position (x: " + obstaclePosition.getX() + ", y: " + obstaclePosition.getY() + ")");
	}
}
