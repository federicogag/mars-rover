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
import main.it.kata.rover.commands.RoverCommand;
import main.it.kata.rover.commands.TurnLeftRoverCommand;

class TurnLeftRoverCommandTest {

	@Test
	public void shouldChangeDirectionFromNorthToWest() throws ObstacleDetectedException {
		int initialPositionX = 6;
		int initialPositionY = 5;
		Direction initialDirection = Direction.NORTH;
		List<RoverCommand> roverCommands = Arrays.asList(new TurnLeftRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);
		char[] commands = {'l'};
		rover.executeCommands(commands);
		
		assertTrue(rover.getDirection().equals(Direction.WEST));
	}
	
	@Test
	public void shouldChangeDirectionFromWestToSouth() throws ObstacleDetectedException {
		int initialPositionX = 6;
		int initialPositionY = 5;
		Direction initialDirection = Direction.WEST;
		List<RoverCommand> roverCommands = Arrays.asList(new TurnLeftRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);
		char[] commands = {'l'};
		rover.executeCommands(commands);
		
		assertTrue(rover.getDirection().equals(Direction.SOUTH));
	}
	
	@Test
	public void shouldChangeDirectionFromSouthToEast() throws ObstacleDetectedException {
		int initialPositionX = 6;
		int initialPositionY = 5;
		Direction initialDirection = Direction.SOUTH;
		List<RoverCommand> roverCommands = Arrays.asList(new TurnLeftRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);		
		char[] commands = {'l'};
		rover.executeCommands(commands);
		
		assertTrue(rover.getDirection().equals(Direction.EAST));
	}
	
	@Test
	public void shouldChangeDirectionFromEastToNorth() throws ObstacleDetectedException {
		int initialPositionX = 6;
		int initialPositionY = 5;
		Direction initialDirection = Direction.EAST;
		List<RoverCommand> roverCommands = Arrays.asList(new TurnLeftRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);
		char[] commands = {'l'};
		rover.executeCommands(commands);
		
		assertTrue(rover.getDirection().equals(Direction.NORTH));
	}
	
	@Test
	public void shouldChangeDirectionFromNorthToSouth() throws ObstacleDetectedException {
		int initialPositionX = 6;
		int initialPositionY = 5;
		Direction initialDirection = Direction.NORTH;
		List<RoverCommand> roverCommands = Arrays.asList(new TurnLeftRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);
		char[] commands = {'l', 'l'};
		rover.executeCommands(commands);
		
		assertTrue(rover.getDirection().equals(Direction.SOUTH));
	}
	
	@Test
	public void shouldChangeDirectionFromEastToWest() throws ObstacleDetectedException {
		int initialPositionX = 6;
		int initialPositionY = 5;
		Direction initialDirection = Direction.EAST;
		List<RoverCommand> roverCommands = Arrays.asList(new TurnLeftRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);
		char[] commands = {'l', 'l'};
		rover.executeCommands(commands);
		
		assertTrue(rover.getDirection().equals(Direction.WEST));
	}
	
	@Test
	public void shouldReturnOnInitialDirection() throws ObstacleDetectedException {
		int initialPositionX = 6;
		int initialPositionY = 5;
		Direction initialDirection = Direction.EAST;
		List<RoverCommand> roverCommands = Arrays.asList(new TurnLeftRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);
		char[] commands = {'l', 'l', 'l', 'l'};
		rover.executeCommands(commands);
		
		assertTrue(rover.getDirection().equals(Direction.EAST));
	}
	
}
