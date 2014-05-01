import java.io.File;

import org.apache.log4j.xml.DOMConfigurator;

import bussines.Squad;

/**
 * <pre>
 * @author mario  
 * Main class that starts the execution of the application
 * </pre>
 */
public class Main {

	public static void main(String[] args) {

		DOMConfigurator.configure("etc" + File.separator + "log4j.xml");
		Squad.exploreMars();

	}

}
