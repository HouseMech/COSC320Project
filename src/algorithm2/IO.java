package algorithm2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class IO {

	// reads input file and returns a string array list with each line as an element
	public static ArrayList<String> readInput(String filename) throws Exception {
		ArrayList<String> r = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
		// reader.readLine(); // skip header line
		String line;
		while ((line = reader.readLine()) != null) {
			r.add(line.trim());
		}
		reader.close();
		return r;
	}

	// writes the output array list to a file with each element as a line
	public static void writeOutput(ArrayList<String> output, String filename) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		for (int i = 0; i < output.size(); i++) {
			writer.append(output.get(i));
			writer.newLine();
		}
		writer.close();
	}

	// reads the "./slangs.txt" file and returns an array list of slang, full form pairs
	public static ArrayList<Pair> readWordPairMap() throws Exception {
		ArrayList<Pair> r = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(new File("./slangs.txt")));
		String line;
		while ((line = reader.readLine()) != null) {
			if (!(line = line.trim()).equals("")) {
				String[] data = line.split("\\s", 2);
				r.add(new Pair(data[0], data[1]));
			}
		}
		reader.close();
		return r;
	}
}
