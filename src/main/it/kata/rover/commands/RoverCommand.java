package main.it.kata.rover.commands;

import main.it.kata.rover.ObstacleDetectedException;
import main.it.kata.rover.Rover;

public abstract class RoverCommand {

	/**
	 * Rover command code
	 */
	private char code;
	
	/**
	 * Rover Command Constructor
	 * @param commandCode - the code that identify the rover command
	 */
	public RoverCommand(char commandCode) {
		this.code = commandCode;
	}
	
	public char getCommandCode() {
		return this.code;
	}
	
	/**
	 * Executes the rover command
	 * @param rover rover on which the command is to be executed 
	 * @throws ObstacleDetectedException if the command leads to the detection of an obstacle
	 */
	public abstract void execute(Rover rover) throws ObstacleDetectedException;
	
}
