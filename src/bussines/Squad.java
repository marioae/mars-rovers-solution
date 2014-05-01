package bussines;

import java.awt.Point;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * <pre>
 * @author mario
 * Class that performs the location of the squad of robotic rovers.
 * </pre>
 */
public class Squad {

	private static Logger log = Logger.getLogger(Squad.class);

	/**
	 * Method that explores Mars
	 */
	public static void exploreMars() {
		log.info("It will process the location of the rovers.");
		try {
			InputFile inputFile = new InputFile();
			if (!inputFile.readInput()) {
				System.out.println("<01> Confguration input file is invalid.");
				return;
			}

			Point coordinate = inputFile.getCoordinate();
			List<Information> lstInformations = inputFile.getLstInformations();
			if (lstInformations.isEmpty()) {
				System.out.println("<02> Input infrmation is empty.");
				return;
			}

			Plateau plateau = new Plateau(coordinate);
			if (lstInformations.size() > plateau.size()) {
				System.out.println("<03> The number of rovers surpassed the plateau.");
				return;
			}

			moveRovers(plateau, lstInformations);

		} catch (Exception e) {
			log.error("Error while processing the location of the rovers.", e);
		}
	}

	/**
	 * Method that makes the process of location of the rovers.
	 */
	public static void moveRovers(Plateau plateau, List<Information> lstInformations) {
		log.info("It will process the location of the rovers.");
		try {

			for (Information information : lstInformations) {
				if (information == null) {
					System.out.println("<04> Information is invalid.");
					continue;
				}

				boolean explored = plateau.explore(information.getRover(), information.getInstructions());
				if (!explored) {
					System.out.println("<05> Rover's movement is invalid.");
					continue;
				}

				System.out.println(information.getRover());
			}

			log.info("The location of the rovers has ended.");
		} catch (Exception e) {
			log.error("Error while processing the location of the rovers.", e);
		}
	}

}
