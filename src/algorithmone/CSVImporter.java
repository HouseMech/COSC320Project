package algorithmone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVImporter {
	public static void readCSV(String fileName, String[] csvArray, WordHashmap wordmap) {
		String delimiter = ",";
		String returnedValue;
		try {
	        File file = new File("./inputcsv/" + fileName);
	        FileReader fr = new FileReader(file);
	        BufferedReader br = new BufferedReader(fr);
	        String line = "";
	        String[] columns;
	        String editedTweet = "";
	        FileWriter csvWriter = new FileWriter("./outputcsv/" + fileName);
	        
	        csvWriter.append("text");
	        csvWriter.append("\n");
	        br.readLine(); //Remove header line
	        while((line = br.readLine()) != null) {
	           columns = line.split(delimiter);
	           if (columns.length == 6) {
		           csvArray = columns[5].toLowerCase().split(" "); //Split string based on delimiter. This is the array we will feed into our algorithm.
		           for (int i = 0; i < csvArray.length; i++) {
						returnedValue = wordmap.getKey(csvArray[i]);
						if (returnedValue != null) { 
							csvArray[i] = returnedValue;
						}
						
					}
		           for (String word : csvArray) {
		        	   editedTweet += word + " "; //rebuild the new tweet with changed words
		           }
		           System.out.println(editedTweet);
		           csvWriter.append(String.join(",", editedTweet));
	               csvWriter.append("\n");
	               editedTweet = "";
	           }
	        }
	        br.close();
	        csvWriter.flush();
	        csvWriter.close();
	        
	        
	        } catch(IOException ioe) {
	           ioe.printStackTrace();
	        }
		
	}
	

}
