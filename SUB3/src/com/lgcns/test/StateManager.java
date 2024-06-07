package com.lgcns.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lgcns.test.StateManager.StatesDto.StateDto;

public class StateManager {
	
	private static Map<String, State> stateInfoMap = new ConcurrentHashMap<String, State>();
	
	public class StatesDto {
		public Map<String, StateDto> state;
		
		public class StateDto {
			public String type;
			public String url;
			public List<String> parameters;
		}
		
	}
	
	public static State get(String key) {
		return stateInfoMap.get(key);
	}

	public static void load() throws JsonSyntaxException, IOException {
		// TODO Auto-generated method stub
		StatesDto statesDto = new Gson().fromJson(new String(Files.readAllBytes(Paths.get("STATE.JSON"))),
				StatesDto.class);
		
		for (Entry<String, StateDto> entry : statesDto.state.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			
			stateInfoMap.put(entry.getKey(), makeState(entry.getKey(), entry.getValue()));
			
		}
	}

//	private static State makeState(String key, StateDto value) {
//		// TODO Auto-generated method stub
//		
//		return new ActionState(key, value.url, value.parameters);
//	}
	
	private static State makeState(String stateName, StateDto stateDto) {
		if ("action".equals(stateDto.type)) {
			return new ActionState(stateName, stateDto.url, stateDto.parameters);

		}
		return null;
	}
	
	

}
