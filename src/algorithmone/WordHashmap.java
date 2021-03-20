package algorithmone;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordHashmap {
	private Map<String,String> hashmap;

	public WordHashmap() {
		Map<String, String> hashmap = new HashMap<String, String>();
        try{
            File myFile = new File("slangs.txt");
            Scanner scan = new Scanner(myFile); // Creates scanner on slangs file
            while(scan.hasNextLine()){
                String data = scan.nextLine();
                String splitData [] = data.split("\\s", 2); // splits on the whitespace found, and allows for only 2 array indeces
                if(splitData[0].equals("")){ // Some lines are empty, if so then just continue to next line
                    continue;
                }else{
                    hashmap.put(splitData[0], splitData[1]); // Puts the key and value in correct position into hasmap
                }
                
            }
            scan.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
		this.hashmap = hashmap;
	}

	public String getKey(String key) {
		return hashmap.get(key);
	}	
	
}