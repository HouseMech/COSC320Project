package algorithm2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {

		ArrayList<File> listFiles = new ArrayList<File>();
		Collections.addAll(listFiles, new File("./inputcsv").listFiles());
		Collections.sort(listFiles);

		// TODO: get array of slangs

		for (int i = 0; i < listFiles.size(); i++) {
			ArrayList<String> input = IO.readInput(listFiles.get(i).getAbsolutePath());
			ArrayList<String> output = new ArrayList<>();
			long time = System.currentTimeMillis();
			for (int j = 0; j < input.size(); j++) {
				// TODO: perform algo with input
				String line = input.get(j);
				output.add(line);
			}
			time = System.currentTimeMillis() - time;
			IO.writeOutput(output, "./Algorithm2Output/output" + listFiles.get(i).getName());
		}

	}

}
