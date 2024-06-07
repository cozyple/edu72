package sub2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class RunManager {
	
	static Map<String, State> stateInfoMap;
	static Map<String, String> variableInfoMap;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		loadState();
		loadVariable();

		while(true) {

			    //scanner.next() 사용
				Scanner scanner = new Scanner((System.in));
			    String value = scanner.next();
			    
			    if(stateInfoMap.get(value) != null) {
			    	
			    	String print = stateInfoMap.get(value).getType() + " " + stateInfoMap.get(value).getUrl();
			    	
			    	String[] param = stateInfoMap.get(value).getParam();
			    	
			    	if(param != null) {
			    		
			    		for (int i = 0; i < param.length; i++) {
							if (i == 0) {
								print += "?";
							} else if (i > 0) {
								print += "&";
							}
							print += param[i] + "=" + variableInfoMap.get(param[i]);
						}
			    		
			    	}
			    	
			    	System.out.println(print);
			    	
			    	
			    }
		}
		
		
	}

	private static void loadVariable() throws Exception {
		// TODO Auto-generated method stub

		variableInfoMap = new HashMap<String, String>();

		try (Scanner sc = new Scanner(new File("VARIABLE.TXT"))){

		    while(sc.hasNext()) {
		        //sc.next() 사용
				String arr[] = sc.next().split("#");
				variableInfoMap.put(arr[0], arr[1]);
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
				String[] keys = null;
				
				if(arr.length > 3) {
					keys = arr[3].split(",");
				}
				
				State st = new State(arr[0], arr[1], arr[2], keys);
				stateInfoMap.put(arr[0], st);
		    }

		}
	}

}
