package com.lgcns.test;

public class RunManager {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		VariableManager.load();
		StateManager.load();
		
		EngineServer server = new EngineServer();
		server.start();
	}


}
