package algorithmone;
import java.util.*;

public class WordHashmap {
	private Map<String,String> hashmap;

	public WordHashmap() {
		Map<String, String> hashmap = new HashMap<String, String>() {{
		    put("btw", "by the way");
		    put("ttyl", "talk to you later");
		}};
		this.hashmap = hashmap;
	}

	public String getKey(String key) {
		return hashmap.get(key);
	}	
	
}
