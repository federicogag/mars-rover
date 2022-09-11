package main.it.kata.rover;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import main.it.kata.rover.commands.MoveBackwardRoverCommand;
import main.it.kata.rover.commands.MoveForwardRoverCommand;
import main.it.kata.rover.commands.RoverCommand;
import main.it.kata.rover.commands.TurnLeftRoverCommand;
import main.it.kata.rover.commands.TurnRightRoverCommand;

public class RoverMain {

	public static void main(String[] args) {
		String commandSequence;
		int initialPositionX = 0;
		int initialPositionY = 0;
		Direction initialDirection = Direction.NORTH;
		List<RoverCommand> roverCommands = Arrays.asList(new MoveForwardRoverCommand(), new MoveBackwardRoverCommand(), new TurnLeftRoverCommand(), new TurnRightRoverCommand());
		List<Position> marsObstacles = Arrays.asList(new Position(2,3));
		Planet mars = new Planet(20, 20, marsObstacles);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);		
		printRoverPosition(rover);
		
        do {
            System.out.print("\n Command sequence > ");
            commandSequence = new Scanner(System.in).nextLine();
            if(!commandSequence.equals("exit")) {
                try {
					rover.executeCommands(commandSequence.toCharArray());
					printRoverPosition(rover);
				} catch (ObstacleDetectedException e) {
					System.err.println(e.getMessage());
					printRoverPosition(rover);
				}
            }
        } while (!commandSequence.equals("exit"));
	}
	
	public static void printRoverPosition(Rover rover) {
		System.out.println("Rover Position: (" + rover.getPosition().getX() + ", " + rover.getPosition().getY() + ", Direction: " + rover.getDirection().toString() +");");
	}
	
	
}
