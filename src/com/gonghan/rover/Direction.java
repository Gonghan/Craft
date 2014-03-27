package com.gonghan.rover;

public class Direction {
	
	private char facing;
	private char faces[];

	public Direction(char facing) {
		this.facing=facing;
		this.faces=new char[]{'N','W','S','E'};
	}

	public void turnLeft(){
		int index=getPos();
		this.facing=this.faces[(index+1)%4];
	}
	
	public void turnRight(){
		int index=getPos();
		this.facing=this.faces[(index+3)%4];
	}
	
	private int getPos(){
		int index=0;
		for(int i=0;i<4;i++){
			if(this.facing==faces[i]){
				index=i;
				break;
			}
		}
		return index;
	}
	public char getFacing(){
		return facing;
	}
}
