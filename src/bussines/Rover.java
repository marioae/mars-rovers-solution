package bussines;

import java.awt.Point;

import type.CardinalPointType;
import type.InstructionType;

/**
 * <pre>
 * @author mario
 * 
 * Clase Rober que representa un obteto Robot.
 * </pre>
 */
public class Rover {

	private Point coordinate;
	private CardinalPointType cardinalPointType;

	public Rover(Point coordinate, CardinalPointType cardinalPointType) {
		this.coordinate = coordinate;
		this.cardinalPointType = cardinalPointType;
	}

	/**
	 * Method which move the rover east
	 */
	private void moveEast() {
		coordinate.x += 1;
	}

	/**
	 * Method which move the rover south
	 */
	private void moveSouth() {
		coordinate.y -= 1;
	}

	/**
	 * Method which move the rover west
	 */
	private void moveWest() {
		coordinate.x -= 1;
	}

	/**
	 * Method which move the rover north
	 */
	private void moveNorth() {
		coordinate.y += 1;
	}

	/**
	 * Method which move the rover forward one point, and maintain the same heading.
	 */
	private void move() {
		if (cardinalPointType.equals(CardinalPointType.N)) {
			moveNorth();
		} else if (cardinalPointType.equals(CardinalPointType.O)) {
			moveWest();
		} else if (cardinalPointType.equals(CardinalPointType.S)) {
			moveSouth();
		} else if (cardinalPointType.equals(CardinalPointType.E)) {
			moveEast();
		}
	}

	/**
	 * Method which rotates the rover 90 degrees left
	 */
	private void spin90DegreesLeft() {
		if (cardinalPointType.equals(CardinalPointType.N)) {
			cardinalPointType = CardinalPointType.O;
		} else if (cardinalPointType.equals(CardinalPointType.O)) {
			cardinalPointType = CardinalPointType.S;
		} else if (cardinalPointType.equals(CardinalPointType.S)) {
			cardinalPointType = CardinalPointType.E;
		} else if (cardinalPointType.equals(CardinalPointType.E)) {
			cardinalPointType = CardinalPointType.N;
		}
	}

	/**
	 * Method which rotates the rover 90 degrees right
	 */
	private void spin90DegreesRight() {
		if (cardinalPointType.equals(CardinalPointType.N)) {
			cardinalPointType = CardinalPointType.E;
		} else if (cardinalPointType.equals(CardinalPointType.E)) {
			cardinalPointType = CardinalPointType.S;
		} else if (cardinalPointType.equals(CardinalPointType.S)) {
			cardinalPointType = CardinalPointType.O;
		} else if (cardinalPointType.equals(CardinalPointType.O)) {
			cardinalPointType = CardinalPointType.N;
		}
	}

	/**
	 * Method which position the rover, the possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right
	 * respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.
	 */
	public void explore(InstructionType instructionType) {
		if (instructionType.equals(InstructionType.L)) {
			spin90DegreesLeft();
		} else if (instructionType.equals(InstructionType.R)) {
			spin90DegreesRight();
		} else if (instructionType.equals(InstructionType.M)) {
			move();
		}
	}

	public Point getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
	}

	public CardinalPointType getCardinalPointType() {
		return cardinalPointType;
	}

	public void setCardinalPointType(CardinalPointType cardinalPointType) {
		this.cardinalPointType = cardinalPointType;
	}

	@Override
	public String toString() {
		return coordinate.x + " " + coordinate.y + " " + cardinalPointType;
	}

}
