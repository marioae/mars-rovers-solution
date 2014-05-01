package bussines;

/**
 * <pre>
 * @author mario
 * 
 * Clse Information que representa las dos lineas de entradas que representan la informacion de un Robot. 
 * La primera linea es la posicion del Robot en la meseta y la segunda linea son las instrucciones para que realice los movimientos.
 * </pre>
 */
public class Information {

	private Rover rover;
	private String instructions;

	public Information(Rover rover, String instructions) {
		this.rover = rover;
		this.instructions = instructions;
	}

	public Rover getRover() {
		return rover;
	}

	public void setRover(Rover rover) {
		this.rover = rover;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

}
