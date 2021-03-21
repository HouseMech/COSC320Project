package algorithmone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//TODO: Clean these things up
public class Main {

	public static void main(String[] args) {
		String delimiter = ",";
		Scanner sc = new Scanner(System.in); //use scanner purely for test purposes. Add list of tweets later.
		String userInput = "";
		String[] userInputArray;
		String returnedValue;
		
		WordHashmap wordmap = new WordHashmap();
		System.out.println("Input filename of csv");
		while (true) {
			userInput = sc.nextLine();
			
			try {
		         File file = new File(userInput);
		         FileReader fr = new FileReader(file);
		         BufferedReader br = new BufferedReader(fr);
		         String line = "";
		         String[] tempArr;
		         br.readLine(); //Remove header line
		         while((line = br.readLine()) != null) {
		            tempArr = line.split(delimiter);
		            userInputArray = tempArr[tempArr.length - 1].toLowerCase().split(" "); //Split string based on delimiter. This is the array we will feed into our algorithm.
					for (int i = 0; i < userInputArray.length; i++) {
						returnedValue = wordmap.getKey(userInputArray[i]);
						if (returnedValue != null) { 
							userInputArray[i] = returnedValue;
						}
						
					}
					for (int i = 0; i < userInputArray.length; i++) {
						System.out.print(userInputArray[i] + " ");
					}
					System.out.println("\n");
		            //System.out.println(tempArr[tempArr.length - 1]);
		            //System.out.println();
		         }
		         br.close();
		         
		         
		         } catch(IOException ioe) {
		            ioe.printStackTrace();
		         }
		   }
		
			
		}
	
	

 }
