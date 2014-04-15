package com.gonghan.coin_change_kata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChangeKata2 {
	Map<Integer, int[]> map;// money=>coin.number

	public int[] getCoins(double money) {
		map = new HashMap<>();
		return this.getCoins((int) (100 * money), new int[5]);
	}

	private int[] getCoins(int money, int result[]) {
		if (map.containsKey(money)) {
			return map.get(money);
		}
		if (money < 0) {
			return null;
		}
		if (money == 0) {
			return result;
		}
		if (money >= 100) {
			result[0] = money / 100;
			money = money - result[0] * 100;
		}
		int[] tmp = new int[5];
		if (money > 0) {
			int[] cloned = Arrays.copyOf(result, 5);
			cloned[1] = cloned[1] + 1;
			int[] v1 = getCoins(money - 25, cloned);
			cloned = Arrays.copyOf(result, 5);
			cloned[2] = cloned[2] + 1;
			int[] v2 = getCoins(money - 10, cloned);
			cloned = Arrays.copyOf(result, 5);
			cloned[3] = cloned[3] + 1;
			int[] v3 = getCoins(money - 5, cloned);
			cloned = Arrays.copyOf(result, 5);
			cloned[4] = cloned[4] + 1;
			int[] v4 = getCoins(money - 1, cloned);
			int[][] vs = { v1, v2, v3, v4 };
			tmp = v1;
			for (int[] v : vs) {
				if (numOfCoins(v) < numOfCoins(tmp)) {
					tmp = v;
				}
			}
		}
		map.put(money, tmp);
		return tmp;
	}

	private int numOfCoins(int[] result) {
		if (result == null) {
			return Integer.MAX_VALUE;
		}
		int s = 0;
		for (int i : result) {
			s += i;
		}
		return s;
	}

//	public static void main(String args[]) {
//		CoinChangeKata2 c = new CoinChangeKata2();
//		for (double i = 0; i < 1; i += 0.01) {
//			int tmp[] = c.getCoins(i);
//			String output = String.format("%d,%d,%d,%d,%d", (int)(100*i),
//					tmp[1], tmp[2], tmp[3], tmp[4]);
//			System.out.println(output);
//		}
//	}
}
