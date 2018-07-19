import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileWorker {

	String readFile(String filename) throws UnsupportedEncodingException{
		
		
		String cvsSplitBy = ";";
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String[] values = sCurrentLine.split(cvsSplitBy);
				System.out.println(values[1]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	return "";
	}
	

	public static void main (String [] args) throws UnsupportedEncodingException{
		  FileWorker fw = new FileWorker();
		  fw.readFile("test.csv");
	}
}
