package algorithm2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {

		ArrayList<File> listFiles = new ArrayList<File>();
		Collections.addAll(listFiles, new File("./inputcsv").listFiles());
		Collections.sort(listFiles);

		ArrayList<Pair> slangs = IO.readWordMap();

		for (int i = 0; i < 1; i++) {
			System.out.println(listFiles.get(i).getName());
			ArrayList<String> input = IO.readInput(listFiles.get(i).getAbsolutePath());
			ArrayList<String> output = new ArrayList<>();
			long time = System.currentTimeMillis();
			for (int j = 0; j < input.size(); j++) {
				String line = input.get(j);
				String[] data = line.split("\\s");
				for (int k = 0; k < data.length; k++) {
					for (int l = 0; l < slangs.size(); l++) {
						if (data[k].equals(slangs.get(l).getKey())) {
							data[k] = slangs.get(l).getValue();
						}
					}
				}
				output.add(String.join(" ", data));
			}
			time = System.currentTimeMillis() - time;
			IO.writeOutput(output, "./Algorithm2Output/output" + listFiles.get(i).getName());
			System.out.println(time);
		}

	}

}
