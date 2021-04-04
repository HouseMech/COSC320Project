package algorithmone;

import java.io.File;
import java.util.*;

//TODO: Clean these things up
public class Main {

	public static void main(String[] args) {
		
		File folder = new File("./inputcsv");
		ArrayList<File> listOfFiles = new ArrayList<File>();
		Collections.addAll(listOfFiles, folder.listFiles());
		// File[] listOfFiles =
		WordHashmap wordmap = new WordHashmap();
		String[] csvArray = {};
		long beforeTime;
		long afterTime;

		Collections.sort(listOfFiles);
		System.out.println(listOfFiles.toString());

		for (int i = 0; i < listOfFiles.size(); i++) {
			if (listOfFiles.get(i).isFile()) {
				System.out.println("File " + listOfFiles.get(i).getName());
				beforeTime = System.currentTimeMillis();
				CSVImporter.readCSV(listOfFiles.get(i).getName(), csvArray, wordmap);
				afterTime = System.currentTimeMillis();
				System.out.println("time taken = " + (afterTime - beforeTime));
			}
		}
	}
 }
