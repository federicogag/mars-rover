package main.it.kata.rover;

import java.util.List;

import main.it.kata.rover.commands.RoverCommand;

public class Rover {
	
	private Position position;
	private Direction direction;
	private List<RoverCommand> commands;
	private Planet planet;
	
	/**
	 * Rover constructor
	 * @param planet Rover planet
	 * @param position Rover starting position
	 * @param direction Rover starting direction
	 * @param commands list of Rover executable commands
	 */
	public Rover(Planet planet, Position position, Direction direction, List<RoverCommand> commands) {
		this.planet = planet;
		this.position = position;
		this.direction = direction;
		this.commands = commands;
	}
	

	public Position getPosition() {
		return this.position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	public Direction getDirection() {
		return this.direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Planet getPlanet() {
		return this.planet;
	}
	
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	
	public void addRoverCommand(RoverCommand command) {
		this.commands.add(command);
	}
	
	public List<RoverCommand> getRoverCommandsList() {
		return this.commands;
	}
	
	/**
	 * Executes the commands identified by the codes passed into the array, in the order in which they are passed
	 * @param commandsToExecute list of command codes to execute
	 * @throws ObstacleDetectedException if a given sequence of commands encouters an obstacle in rover planet.
	 * in this case the execution of any remaining commands is blocked. 
	 */
	public void executeCommands(char[] commandsToExecute) throws ObstacleDetectedException {
		for(char commandCode : commandsToExecute) {
			for(RoverCommand roverCommand : this.commands) {
				if(commandCode == roverCommand.getCommandCode())
					roverCommand.execute(this);
			}
		}		
	}

}
