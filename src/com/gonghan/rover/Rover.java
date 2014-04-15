package com.gonghan.rover;

public class Rover implements Action {
	private int x, y;
	private Direction direction;
	private Grid grid;

	public Rover(Grid grid) {
		this(0, 0, 'N', grid);
	}

	public Rover(int x, int y, char facing, Grid grid) {
		this.x = x;
		this.y = y;
		this.direction = new Direction(facing);
		this.grid = grid;
	}

	public void process(String command) {
		for (char c : command.toCharArray()) {
			switch (c) {
			case 'f':
				this.forward();
				break;
			case 'b':
				this.backward();
				break;
			case 'r':
				this.turnRight();
				break;
			case 'l':
				this.turnLeft();
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void turnLeft() {
		direction.turnLeft();
	}

	@Override
	public void turnRight() {
		direction.turnRight();
	}

	@Override
	public void forward() {
		int oldx = x;
		int oldy = y;
		char facing = direction.getFacing();
		switch (facing) {
		case 'N':
			y++;
			break;
		case 'S':
			y--;
			break;
		case 'E':
			x++;
			break;
		case 'W':
			x--;
			break;
		}
		if (grid.isOutSide(x, y)) {
			x = grid.wrapx(x);
			y = grid.wrapy(y);
		}
		if (grid.isObstacle(x, y)) {
			x = oldx;
			y = oldy;
			// throw new Exception("obstacle");
			x=-1;
			y=-1;
		}

	}

	@Override
	public void backward() {
		int oldx = x;
		int oldy = y;
		char facing = direction.getFacing();
		switch (facing) {
		case 'N':
			y--;
			break;
		case 'S':
			y++;
			break;
		case 'E':
			x--;
			break;
		case 'W':
			x++;
			break;
		}
		if (grid.isOutSide(x, y)) {
			x = grid.wrapx(x);
			y = grid.wrapy(y);
		}
		if (grid.isOutSide(x, y) || grid.isObstacle(x, y)) {
			x = oldx;
			y = oldy;
			//throw new Exception("obstacle");
			x=-1;
			y=-1;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Rover [x=" + x + ", y=" + y + ", direction="
				+ direction.getFacing() + "]";
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		// fly
	}

}
