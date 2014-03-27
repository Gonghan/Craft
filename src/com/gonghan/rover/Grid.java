package com.gonghan.rover;

public class Grid {

	private int[][] grid;

	// 0=OK
	// 1=obstacle
	public Grid(int[][] grid) {
		this.grid = grid;
	}

	public boolean isObstacle(int x, int y) {
		return grid[x][y] == 1;
	}

	public boolean isOutSide(int x, int y) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
			return true;
		}
		return false;
	}

	public int wrapx(int x) {
		return (x + grid.length) % grid.length;
	}

	public int wrapy(int y) {
		return (y + grid[0].length) % grid[0].length;
	}
}
