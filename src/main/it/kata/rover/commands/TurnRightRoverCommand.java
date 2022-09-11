package main.it.kata.rover.commands;

import main.it.kata.rover.Direction;
import main.it.kata.rover.Rover;

public class TurnRightRoverCommand extends RoverCommand {

	public TurnRightRoverCommand() {
		super('r');
	}

	@Override
	public void execute(Rover rover) {
		switch(rover.getDirection()) {
		
			case NORTH:
				rover.setDirection(Direction.EAST);
				break;
			case EAST:
				rover.setDirection(Direction.SOUTH);
				break;
			case SOUTH:
				rover.setDirection(Direction.WEST);
				break;
			case WEST:
				rover.setDirection(Direction.NORTH);
				break;
			}		
	}

}
