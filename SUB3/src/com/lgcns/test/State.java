package com.lgcns.test;

public abstract class State {

	private String name;

	public State(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	protected abstract void run() throws Exception;
}
