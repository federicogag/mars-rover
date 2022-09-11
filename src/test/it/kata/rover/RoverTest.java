package test.it.kata.rover;

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
import main.it.kata.rover.commands.TurnLeftRoverCommand;
import main.it.kata.rover.commands.TurnRightRoverCommand;

class RoverTest {

	@Test
	public void shouldReturnToTheSamePosition() throws ObstacleDetectedException {
		int initialPositionX = 5;
		int initialPositionY = 4;
		Direction initialDirection = Direction.WEST;
		List<RoverCommand> roverCommands = Arrays.asList(new MoveForwardRoverCommand(), new MoveBackwardRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);
		char[] commands = {'b', 'b', 'f', 'f'};
		rover.executeCommands(commands);
		Position expectedPosition = new Position(initialPositionX, initialPositionY);
		
		assertTrue(rover.getPosition().getX() == expectedPosition.getX() && rover.getPosition().getY() == expectedPosition.getY());
	}
	
	@Test
	public void shouldReturnToTheSamePositionWithTurnAndLeftCommands() throws ObstacleDetectedException {
		int initialPositionX = 5;
		int initialPositionY = 4;
		Direction initialDirection = Direction.NORTH;
		List<RoverCommand> roverCommands = Arrays.asList(new MoveForwardRoverCommand(), new MoveBackwardRoverCommand(), new TurnLeftRoverCommand(), new TurnRightRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);		
		char[] commands = {'l', 'f', 'l', 'f', 'l', 'f', 'l', 'f'};
		rover.executeCommands(commands);
		Position expectedPosition = new Position(initialPositionX, initialPositionY);
		
		assertTrue(rover.getPosition().getX() == expectedPosition.getX() && rover.getPosition().getY() == expectedPosition.getY());
	}
	
	@Test
	public void shouldGoFromRightEdgeToLeftEdge() throws ObstacleDetectedException {
		int initialPositionX = 20;
		int initialPositionY = 10;
		Direction initialDirection = Direction.EAST;
		List<RoverCommand> roverCommands = Arrays.asList(new MoveForwardRoverCommand(), new MoveBackwardRoverCommand(), new TurnLeftRoverCommand(), new TurnRightRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);		
		char[] commands = {'f'};
		rover.executeCommands(commands);
		Position expectedPosition = new Position(0, 10);
		
		assertTrue(rover.getPosition().getX() == expectedPosition.getX() && rover.getPosition().getY() == expectedPosition.getY());
	}
	
	@Test
	public void shouldGoFromLeftEdgeToRightEdge() throws ObstacleDetectedException {
		int initialPositionX = 0;
		int initialPositionY = 10;
		Direction initialDirection = Direction.EAST;
		List<RoverCommand> roverCommands = Arrays.asList(new MoveForwardRoverCommand(), new MoveBackwardRoverCommand(), new TurnLeftRoverCommand(), new TurnRightRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);		
		char[] commands = {'b'};
		rover.executeCommands(commands);
		Position expectedPosition = new Position(20, 10);
		
		assertTrue(rover.getPosition().getX() == expectedPosition.getX() && rover.getPosition().getY() == expectedPosition.getY());
	}
	
	@Test
	public void shouldGoFromUpperEdgeToBottomEdge() throws ObstacleDetectedException {
		int initialPositionX = 10;
		int initialPositionY = 20;
		Direction initialDirection = Direction.NORTH;
		List<RoverCommand> roverCommands = Arrays.asList(new MoveForwardRoverCommand(), new MoveBackwardRoverCommand(), new TurnLeftRoverCommand(), new TurnRightRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);		
		char[] commands = {'f'};
		rover.executeCommands(commands);
		Position expectedPosition = new Position(10, 0);
		
		assertTrue(rover.getPosition().getX() == expectedPosition.getX() && rover.getPosition().getY() == expectedPosition.getY());
	}
	
	@Test
	public void shouldGoFromBottomEdgeToUpperEdge() throws ObstacleDetectedException {
		int initialPositionX = 10;
		int initialPositionY = 0;
		Direction initialDirection = Direction.NORTH;
		List<RoverCommand> roverCommands = Arrays.asList(new MoveForwardRoverCommand(), new MoveBackwardRoverCommand(), new TurnLeftRoverCommand(), new TurnRightRoverCommand());
		Planet mars = new Planet(20, 20);
		
		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);		
		char[] commands = {'b'};
		rover.executeCommands(commands);
		Position expectedPosition = new Position(10, 20);
		
		assertTrue(rover.getPosition().getX() == expectedPosition.getX() && rover.getPosition().getY() == expectedPosition.getY());
	}
	
	@Test 
	public void shouldThrowObstacleDetectedException() {
	    assertThrows(ObstacleDetectedException.class,
	            ()->{
	        		int initialPositionX = 10;
	        		int initialPositionY = 0;
	        		Direction initialDirection = Direction.EAST;
	        		List<RoverCommand> roverCommands = Arrays.asList(new MoveForwardRoverCommand(), new MoveBackwardRoverCommand(), new TurnLeftRoverCommand(), new TurnRightRoverCommand());
	        		List<Position> marsObstacles = Arrays.asList(new Position(12,0));
	        		Planet mars = new Planet(20, 20, marsObstacles);
	        		
	        		Rover rover = new Rover(mars, new Position(initialPositionX, initialPositionY), initialDirection, roverCommands);		
	        		char[] commands = {'f', 'f'};
	        		rover.executeCommands(commands);
	            });
	}
	
	
}
