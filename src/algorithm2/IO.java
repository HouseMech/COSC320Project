package algorithm2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class IO {

	public static ArrayList<String> readInput(String filename) throws Exception {
		ArrayList<String> r = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
		reader.readLine(); // skip header line
		String line;
		while ((line = reader.readLine()) != null) {
			r.add(line);
		}
		reader.close();
		return r;
	}

	public static void writeOutput(ArrayList<String> output, String filename) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		for (int i = 0; i < output.size(); i++) {
			writer.append(output.get(i));
			writer.newLine();
		}
		writer.close();
	}
}
