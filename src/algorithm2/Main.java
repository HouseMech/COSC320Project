package algorithm2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {

		// get input files
		ArrayList<File> listFiles = new ArrayList<File>();
		Collections.addAll(listFiles, new File("./inputcsv").listFiles());
		Collections.sort(listFiles);

		// get slang pairs map
		ArrayList<Pair> slangs = IO.readWordMap();

		// loop through input files
		for (int i = 0; i < listFiles.size(); i++) {
			System.out.println(listFiles.get(i).getName());
			// read file inputs to an array list
			ArrayList<String> input = IO.readInput(listFiles.get(i).getAbsolutePath());
			ArrayList<String> output = new ArrayList<>();
			// start timing
			long time = System.currentTimeMillis();
			// loop array list of input
			for (int j = 0; j < input.size(); j++) {
				String line = input.get(j);
				// split line to a space separated array (words)
				String[] words = line.split("\\s");
				// loop through words
				for (int k = 0; k < words.length; k++) {
					// loop through slang pairs
					for (int l = 0; l < slangs.size(); l++) {
						// if a word matches a slang replace it
						if (words[k].equals(slangs.get(l).getKey())) {
							words[k] = slangs.get(l).getValue();
						}
					}
				}
				output.add(String.join(" ", words));
			}
			time = System.currentTimeMillis() - time;
			IO.writeOutput(output, "./Algorithm2Output/output" + listFiles.get(i).getName());
			System.out.println(time);
		}

	}

}
