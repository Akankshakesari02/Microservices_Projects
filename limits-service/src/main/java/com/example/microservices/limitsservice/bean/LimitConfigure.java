package com.example.microservices.limitsservice.bean;

public class LimitConfigure {
	
	private int minimum;
	private int maximum;
	
	public LimitConfigure() {
		// TODO Auto-generated constructor stub
	}
	public LimitConfigure(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	

}
