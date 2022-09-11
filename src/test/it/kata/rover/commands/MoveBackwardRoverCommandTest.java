package test.it.kata.rover.commands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.it.kata.rover.Direction;
import main.it.kata.rover.ObstacleDetectedException;
import main.it.kata.rover.Planet;
import main.it.kata.rover.Position;
import main.it.kata.rover.Rover;
import main.it.kata.rover.commands.MoveBackwardRoverCommand;
import main.it.kata.rover.commands.MoveForwardRoverCommand;
import main.it.kata.rover.commands.RoverCommand;

class MoveBackwardRoverCommandTest {

	@Test
	public void shouldMoveBackwardNorthDirection() throws ObstacleDetectedException {
		int initialPositionX = 2;
		int initialPositionY = 2;
		Direction initialDirection = Direction.NORTH;
		List<RoverCommand> roverCommands = Arrays.asList(new MoveBackwardRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);
		char[] commands = {'b'};
		rover.executeCommands(commands);
		Position expectedPosition = new Position(2, 1);
		
		assertTrue(rover.getPosition().getX() == expectedPosition.getX() && rover.getPosition().getY() == expectedPosition.getY());
	}
	
	@Test
	public void shouldMoveBackwardSouthDirection() throws ObstacleDetectedException {
		int initialPositionX = 2;
		int initialPositionY = 4;
		Direction initialDirection = Direction.SOUTH;
		List<RoverCommand> roverCommands = Arrays.asList(new MoveBackwardRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);		
		char[] commands = {'b'};
		rover.executeCommands(commands);
		Position expectedPosition = new Position(2, 5);
		
		assertTrue(rover.getPosition().getX() == expectedPosition.getX() && rover.getPosition().getY() == expectedPosition.getY());
	}
	
	@Test
	public void shouldMoveBackwardEastDirection() throws ObstacleDetectedException {
		int initialPositionX = 3;
		int initialPositionY = 1;
		Direction initialDirection = Direction.EAST;
		List<RoverCommand> roverCommands = Arrays.asList(new MoveBackwardRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);		char[] commands = {'b'};
		rover.executeCommands(commands);
		Position expectedPosition = new Position(2, 1);
		
		assertTrue(rover.getPosition().getX() == expectedPosition.getX() && rover.getPosition().getY() == expectedPosition.getY());
	}
	
	@Test
	public void shouldMoveBackwardWestDirection() throws ObstacleDetectedException {
		int initialPositionX = 1;
		int initialPositionY = 1;
		Direction initialDirection = Direction.WEST;
		List<RoverCommand> roverCommands = Arrays.asList(new MoveBackwardRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);		char[] commands = {'b'};
		rover.executeCommands(commands);
		Position expectedPosition = new Position(2, 1);
		
		assertTrue(rover.getPosition().getX() == expectedPosition.getX() && rover.getPosition().getY() == expectedPosition.getY());
	}

}
