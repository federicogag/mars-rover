package main.it.kata.rover;

import java.util.ArrayList;
import java.util.List;

public class Planet {

	private int maxX;
	private int maxY;
	private List<Position> obstacles;
	
	/**
	 * Constructor 
	 * @param maxX maximum X axis value
	 * @param maxY maximum Y axis value
	 */
	public Planet(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
		this.obstacles = new ArrayList<Position>();
	}
	
	/**
	 * Constructor
	 * @param maxX maximum X axis value
	 * @param maxY maximum Y axis value
	 * @param obstacles of obstacle positions 
	 */
	public Planet(int maxX, int maxY, List<Position> obstacles) {
		this.maxX = maxX;
		this.maxY = maxY;
		this.obstacles = obstacles;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	
	public List<Position> getObstacleList(){
		return this.obstacles;
	}
	
	public void addObstacle(Position obstacle) {
		this.obstacles.add(obstacle);
	}
	
	/**
	 * Checks that a given position is an obstacle
	 * @param position position to check
	 * @return true if the given position is an obstacle, false otherwise
	 */
	public boolean isObstacle(Position position) {
		for(Position obstacle : this.obstacles) {
			if(obstacle.getX() == position.getX() && obstacle.getY() == position.getY())
				return true;
		}
		return false;
	}
	
	
}
