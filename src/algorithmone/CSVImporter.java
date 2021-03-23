package algorithmone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVImporter {
	public static void readCSV(String userInput, String[] csvArray, WordHashmap wordmap) {
		String delimiter = ",";
		String returnedValue;
		try {
	        File file = new File(userInput);
	        FileReader fr = new FileReader(file);
	        BufferedReader br = new BufferedReader(fr);
	        String line = "";
	        String[] tempArr;
	        br.readLine(); //Remove header line
	        while((line = br.readLine()) != null) {
	           tempArr = line.split(delimiter);
	           csvArray = tempArr[tempArr.length - 1].toLowerCase().split(" "); //Split string based on delimiter. This is the array we will feed into our algorithm.
				for (int i = 0; i < csvArray.length; i++) {
					returnedValue = wordmap.getKey(csvArray[i]);
					if (returnedValue != null) { 
						csvArray[i] = returnedValue;
					}
					
				}
				for (int i = 0; i < csvArray.length; i++) {
					System.out.print(csvArray[i] + " ");
				}
				System.out.println("\n");
	        }
	        br.close();
	        
	        
	        } catch(IOException ioe) {
	           ioe.printStackTrace();
	        }
		
	}
	

}
