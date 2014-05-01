package bussines;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;

import type.CardinalPointType;
import utils.ReadFileUtils;

/**
 * <pre>
 * @author mario
 * Class that reads the input file.
 * </pre>
 */
public class InputFile {

	private Point coordinate;
	private List<Information> lstInformations;

	private static String inputFileName = "etc/input.txt";

	private static Logger log = Logger.getLogger(InputFile.class);

	public InputFile() {
		lstInformations = new ArrayList<Information>();
	}

	/**
	 * Method that reads the input file.
	 * 
	 * @return true/false.
	 */
	public boolean readInput() {
		log.info("It will read the input file.");

		ReadFileUtils rfu = null;
		try {
			rfu = new ReadFileUtils(inputFileName);
			String line;
			int lineCount = 0;
			String location = StringUtils.EMPTY;
			while ((line = rfu.readLine()) != null) {
				log.info("line " + lineCount + ":" + line);

				if (lineCount == 0) {
					if (StringUtils.isBlank(line)) {
						continue;
					}

					coordinate = getCoordinate(line);
					if (coordinate == null) {
						log.error("Cordinate is invalid.");
						return false;
					}
				} else {
					if (lineCount % 2 != 0) {
						if (StringUtils.isBlank(line)) {
							continue;
						}
						location = line;
					} else {
						lstInformations.add(getInformation(location, line));
					}
				}

				lineCount++;
			}

		} catch (Exception e) {
			log.error("Error while trying to read input file.", e);
			return false;
		} finally {
			if (rfu != null) {
				rfu.close();
			}
		}

		log.info("It has successfully read the input file.");
		return true;
	}

	public Information getInformation(String location, String instructions) {
		String[] str = StringUtils.split(location, " ");
		if (str.length < 3) {
			return null;
		}

		if (!NumberUtils.isNumber(str[0]) || !NumberUtils.isNumber(str[1]) || StringUtils.isBlank(str[2])) {
			return null;
		}

		Point c = new Point(NumberUtils.toInt(str[0]), NumberUtils.toInt(str[1]));

		if (c.x < 0 || c.x > coordinate.x || c.y < 0 || c.y > coordinate.y) {
			return null;
		}

		CardinalPointType cardinalPointType = CardinalPointType.value(str[2].toUpperCase());
		if (cardinalPointType == null) {
			return null;
		}

		Rover rover = new Rover(c, cardinalPointType);
		return new Information(rover, instructions);
	}

	public Point getCoordinate(String line) throws Exception {
		String[] str = StringUtils.split(line, " ");
		if (str.length < 2) {
			return null;
		}
		if (!NumberUtils.isNumber(str[0]) || !NumberUtils.isNumber(str[1])) {
			return null;
		}

		return new Point(NumberUtils.toInt(str[0]), NumberUtils.toInt(str[1]));
	}

	public Point getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
	}

	public List<Information> getLstInformations() {
		return lstInformations;
	}

	public void setLstInformations(List<Information> lstInformations) {
		this.lstInformations = lstInformations;
	}

}
