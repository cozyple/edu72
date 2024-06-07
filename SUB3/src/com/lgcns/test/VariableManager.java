package com.lgcns.test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class VariableManager {
	
	public static Map<String, String> variableInfoMap;
	

	public static synchronized String get(String key) {
		return variableInfoMap.get(key);
	}

	public static synchronized void put(String key, String value) {
		variableInfoMap.put(key, value);
	}

	public static synchronized void load() throws JsonSyntaxException, IOException {
		// TODO Auto-generated method stub
		Type type = new TypeToken<Map<String, String>>() {}.getType();
		variableInfoMap = Collections.synchronizedMap(new Gson().fromJson(new String(Files.readAllBytes(Paths.get("VARIABLE.JSON"))), type));
		
		for (Entry<String, String> entry : variableInfoMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());			
		}
	}

}
