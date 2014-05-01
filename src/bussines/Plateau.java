package bussines;

import java.awt.Point;

import org.apache.commons.lang.StringUtils;

import type.InstructionType;

/**
 * <pre>
 * @author mario 
 * Clase Plateau es la meseta rectangular en forma de un matriz donde los robost realizan la exploración.
 * </pre>
 */
public class Plateau {

	private Point coordinateUpperRight;

	public Plateau(Point coordinateUpperRight) {
		this.coordinateUpperRight = coordinateUpperRight;
	}

	public boolean isMovementValid(int x, int y) {
		return ((x >= 0 && x <= coordinateUpperRight.x) && (y >= 0 && y <= coordinateUpperRight.y));
	}

	public int size() {
		return (coordinateUpperRight.x + 1) * (coordinateUpperRight.y + 1);
	}

	/**
	 * Metodo que realiza los movimientos de los robost en base a las instrucciones para explorar.
	 * 
	 * @param rover
	 * @param instructions
	 * @return true/false
	 */
	public boolean explore(Rover rover, String instructions) {
		instructions = StringUtils.upperCase(instructions);
		char[] arrayInstructions = instructions.toCharArray();

		for (char c : arrayInstructions) {
			if (c == ' ') {
				continue;
			}

			InstructionType instructionType = InstructionType.value(String.valueOf(c));
			rover.explore(instructionType);

			if (!isMovementValid(rover.getCoordinate().x, rover.getCoordinate().y)) {
				return false;
			}

		}

		return true;
	}

}
