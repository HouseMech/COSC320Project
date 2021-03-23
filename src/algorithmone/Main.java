package algorithmone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//TODO: Clean these things up
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //use scanner to get filenames
		String userInput = "";
		String[] csvArray = {};
		
		
		WordHashmap wordmap = new WordHashmap();
		System.out.println("Input filename of csv");
		while (true) {
			userInput = sc.nextLine();
			CSVImporter.readCSV(userInput, csvArray, wordmap);
			
		   }
		
			
		}
	
	

 }
