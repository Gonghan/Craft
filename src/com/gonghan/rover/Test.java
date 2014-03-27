package com.gonghan.rover;

import static org.junit.Assert.*;

import org.junit.Before;

public class Test {

	int grid[][];
	Grid g;
	@Before
	public void init(){
		grid=new int[100][100];
		grid[2][3]=1;
		grid[3][3]=1;
		g=new Grid(grid);
		
	}
	
	@org.junit.Test
	public void testNormalAction() {
		Rover rover=new Rover(g);
		rover.process("ffrff");
		assertEquals(rover.getX(),2);
		assertEquals(rover.getY(),2);
	}
	
	@org.junit.Test
	public void testObstacle() {
		Rover rover=new Rover(g);
		rover.process("ffrfff");
		assertEquals(rover.getX(),3);
		assertEquals(rover.getY(),2);
	}
	
	@org.junit.Test
	public void testOutside() {
		Rover rover=new Rover(g);
		rover.process("bbrbbb");
		assertEquals(rover.getX(),97);
		assertEquals(rover.getY(),98);
	}
}
