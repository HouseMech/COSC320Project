package algorithmone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVImporter {
	public static void readCSV(String fileName, String[] csvArray, WordHashmap wordmap) {
		String returnedValue;
		try {
	        File file = new File("./inputcsv/" + fileName);
	        FileReader fr = new FileReader(file);
	        BufferedReader br = new BufferedReader(fr);
	        String line = "";
	        String editedTweet = "";
	        FileWriter csvWriter = new FileWriter("./outputcsv/" + fileName);
	        
	        csvWriter.append("text");
	        csvWriter.append("\n");
	        br.readLine(); // Remove header line
	        int count = 0;
	        while((line = br.readLine()) != null) {
	        	if(line.trim().length()==0){
	        	    continue; // rest of loop body is skipped
	        	}
	        	try {
		        	if(line.charAt(0) == '"') {
		        		line = line.substring(1);
		        	}
		        	if(line.charAt(line.length()-1) == '"') {
		        		line = line.substring(0,line.length()-1);
		        	}
	        	} catch(StringIndexOutOfBoundsException e) {
	        		continue;
	        	}

	           csvArray = line.toLowerCase().split(" "); // Split string based on delimiter. This is the array we will feed into our algorithm.
	           for (int i = 0; i < csvArray.length; i++) {
					returnedValue = wordmap.getKey(csvArray[i]);
					if (returnedValue != null) { 
						csvArray[i] = returnedValue;
					}
					
				}
	           editedTweet = "\"";
	           for (String word : csvArray) {
	        	   editedTweet += word + " "; //rebuild the new tweet with changed words
	           }
	           editedTweet += "\"";
	           csvWriter.append(String.join(",", editedTweet));
               csvWriter.append("\n");
               editedTweet = "";
               count++;
	           
	        }
	        System.out.println("Number of tweets: "+count);
	        br.close();
	        csvWriter.flush();
	        csvWriter.close();
	        
	        
	        } catch(IOException ioe) {
	           ioe.printStackTrace();
	        }
		
	}
	

}