package bussines;

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
