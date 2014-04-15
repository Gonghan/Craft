package com.gonghan.rover;

public interface Action {
	
	void turnLeft();
	void turnRight();
	void forward() throws Exception;
	void backward() throws Exception;
	
	void fly();
}
