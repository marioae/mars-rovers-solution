package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class ReadFileUtils {

	private BufferedReader br;

	public ReadFileUtils(String pathname) throws FileNotFoundException {
		File file = new File(pathname);
		FileReader fr = new FileReader(file);
		br = new BufferedReader(fr);
	}

	public String readLine() throws IOException {
		return br.readLine();
	}

	public void close() {
		IOUtils.closeQuietly(br);
	}

}
