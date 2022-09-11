package main.it.kata.rover.commands;

import main.it.kata.rover.ObstacleDetectedException;
import main.it.kata.rover.Rover;

public class MoveForwardRoverCommand extends MovementRoverCommand {

	public MoveForwardRoverCommand() {
		super('f');
	}

	@Override
	public void execute(Rover rover) throws ObstacleDetectedException {
		switch(rover.getDirection()) {
		
			case NORTH :
				rover.setPosition(incrementY(rover.getPlanet(), rover.getPosition()));
				break;
				
			case EAST:
				rover.setPosition(incrementX(rover.getPlanet(), rover.getPosition()));
				break;
				
			case SOUTH:
				rover.setPosition(decrementY(rover.getPlanet(), rover.getPosition()));
				break;
				
			case WEST:
				rover.setPosition(decrementX(rover.getPlanet(), rover.getPosition()));
				break;
		}		
	}


	
	

}
