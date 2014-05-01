package bussines;

import java.awt.Point;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * <pre>
 * @author mario
 * 
 * Clase Squad que realiza la eploracion de Martes con el escuadron de Robots dentro de la Meseta.
 * </pre>
 */
public class Squad {

	private static Logger log = Logger.getLogger(Squad.class);

	/**
	 * Metodo que realiza la exploración de Martes.
	 */
	public static void exploreMars() {
		log.info("--------------- Se va iniciar la exploración de Martes. -------------------");
		try {
			InputFile inputFile = new InputFile();
			if (!inputFile.readInput()) {
				System.out.println("<01> Confguration input file is invalid.");
				return;
			}

			Point coordinate = inputFile.getCoordinate();
			List<Information> lstInformations = inputFile.getLstInformations();
			if (lstInformations.isEmpty()) {
				System.out.println("<02> Input information is empty.");
				log.info("No hay lineas de entrada de informacion de los robots.");
				return;
			}

			Plateau plateau = new Plateau(coordinate);
			if (lstInformations.size() > plateau.size()) {
				System.out.println("<03> The number of rovers surpassed the plateau.");
				log.info("El numero de robots ha sobrepasado la cantidad maxima soportado por la meseta.");
				return;
			}

			moveRovers(plateau, lstInformations);

			log.info("Se ha realizado la exploración de Martes satisfactoriamente.");
		} catch (Exception e) {
			log.error("Error al intentar realizar la exploración de Martes.", e);
		} finally {
			log.info("--------------- Se finalizo la exploración de Martes. -------------------");
		}
	}

	/**
	 * Metodo que realiza los movimientos de los Robots en base a las instrucciones.
	 */
	public static void moveRovers(Plateau plateau, List<Information> lstInformations) {
		log.info("Se va realizar los movimientos de los robots en la meseta.");
		try {

			log.info("=============OUPUT==============");
			for (Information information : lstInformations) {
				if (information == null) {
					System.out.println("<04> Information is invalid.");
					log.warn("Las lineas de entrada de informacion del Robot no es valido.");
					continue;
				}

				boolean explored = plateau.explore(information.getRover(), information.getInstructions());
				if (!explored) {
					System.out.println("<05> Rover's movement is invalid.");
					log.warn("Movimiento del Robot no es valido. {" + information.getRover() + "}");
					continue;
				}

				System.out.println(information.getRover());
				log.info(information.getRover());
			}
			log.info("================================");

			log.info("Se ha realizado los movimientos de los robots en la meseta satisfactoriamente.");
		} catch (Exception e) {
			log.error("Error al intentar realizar los movimientos de los robots en la meseta.", e);
		}
	}

}
