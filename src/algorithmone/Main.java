package algorithmone;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //use scanner purely for test purposes. Add list of tweets later.
		String userInput = "";
		String[] userInputArray;
		String returnedValue;
		WordHashmap wordmap = new WordHashmap();
		while (true) {
			userInput = sc.nextLine();
			
			userInputArray = userInput.split(" "); //Split string based on delimiter. This is the array we will feed into our algorithm.
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
		}

	}

}
