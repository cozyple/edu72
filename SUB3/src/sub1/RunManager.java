package sub1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RunManager {
	
	static Map<String, State> stateInfoMap;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		loadState();
		
		
		
		while(true) {

			    //scanner.next() 사용
				Scanner scanner = new Scanner((System.in));
			    String value = scanner.next();
			    
			    if(stateInfoMap.get(value) != null) {
	
			    	System.out.println(String.format("%s %s", stateInfoMap.get(value).getType(), stateInfoMap.get(value).getUrl()));	
			    }
		}
		
		
	}

	private static void loadState() throws Exception {
		// TODO Auto-generated method stub
		
		stateInfoMap = new HashMap<String, State>();

		try (Scanner sc = new Scanner(new File("STATE.TXT"))){

		    while(sc.hasNext()) {
		        //sc.next() 사용
				String arr[] = sc.next().split("#");
				
				State st = new State(arr[0], arr[1], arr[2]);
				stateInfoMap.put(arr[0], st);
		    }

		}
	}

}
