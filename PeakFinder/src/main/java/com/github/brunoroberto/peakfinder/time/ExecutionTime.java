package com.github.brunoroberto.peakfinder.time;

public class ExecutionTime {

	private long time;

	public void start() {
		this.time = System.currentTimeMillis();
	}

	public void stop() {
		this.time = System.currentTimeMillis() - this.time;
	}

	public long getExecutionTimeMillis() {
		return this.time;
	}

}
