package algorithmone;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordHashmap {
	private Map<String,String> hashmap;

	public WordHashmap() {
		Map<String, String> hashmap = new HashMap<String, String>();
        try{
            File f = new File("slangs.txt");
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine()){
                String data = scan.nextLine();
                String a [] = data.split("\\s", 2);
                if(a[0].equals("")){
                    continue;
                }else{
                    hashmap.put(a[0], a[1]);
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