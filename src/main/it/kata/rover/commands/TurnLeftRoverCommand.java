package main.it.kata.rover.commands;

import main.it.kata.rover.Direction;
import main.it.kata.rover.Rover;

public class TurnLeftRoverCommand extends RoverCommand {

	public TurnLeftRoverCommand() {
		super('l');
	}

	@Override
	public void execute(Rover rover) {
		switch(rover.getDirection()) {
		
			case NORTH:
				rover.setDirection(Direction.WEST);
				break;
			case EAST: 
				rover.setDirection(Direction.NORTH);
				break;
			case SOUTH:
				rover.setDirection(Direction.EAST);
				break;
			case WEST:
				rover.setDirection(Direction.SOUTH);
				break;
			}
	}

}
