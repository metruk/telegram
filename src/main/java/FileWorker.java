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

	List readFile(String filename) throws UnsupportedEncodingException{
			
		String cvsSplitBy = ";";
		List<Event> events = new ArrayList<Event>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String[] values = sCurrentLine.split(cvsSplitBy);
				String link = values[0];
				String header = values[1];
				String time = values[2];
				events.add(new Event(link,header,time));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
			
	return events;
	}
	

	public static void main (String [] args) throws UnsupportedEncodingException{
		  FileWorker fw = new FileWorker();
		  fw.readFile("test.csv");
	}
}
