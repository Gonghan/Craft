package com.gonghan.coin_change_kata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CoinChangeKata3 {
	public int[] getCoins(double money) {
		return this.getCoins((int) (100 * money));
	}

	private int[] getCoins(int money) {
		int result[] = new int[5];
		result[0] = money / 100;
		money = money - 100 * result[0];
		try {
			Scanner scanner = new Scanner(new File("map.txt"));
			while (scanner.hasNext()) {
				String line = scanner.next();
				String[] strs = line.split(",");
				int m = Integer.parseInt(strs[0]);
				if (m == money)
					for (int i = 1; i < 5; i++)
						result[i] = Integer.parseInt(strs[i]);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static void main(String args[]){
		CoinChangeKata3 c=new CoinChangeKata3();
		for(int i:c.getCoins(14.57)){
			System.out.println(i);
		}
	}
}
