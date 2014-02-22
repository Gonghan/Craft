package com.gonghan.coin_change_kata;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeKata {
	Map<Integer, Integer> dp;

	public int getCoins(double money) {
		return this.getCoins((int) (100 * money));
	}

	public int getCoins(int money) {
		if (dp == null) {
			dp = new HashMap<>();
		}
		if (dp.containsKey(money)) {
			return dp.get(money);
		}
		if (money == 0) {
			return 0;
		}
		if (money < 0) {
			return Integer.MAX_VALUE / 2;
		}
		int oneDollars = money / 100;
		money = money - oneDollars * 100;
		int min = Integer.MAX_VALUE;
		if (money > 0) {
			min = Math.min(min, getCoins(money - 25) + 1);
			min = Math.min(min, getCoins(money - 10) + 1);
			min = Math.min(min, getCoins(money - 5) + 1);
			min = Math.min(min, getCoins(money - 1) + 1);
			min = min + oneDollars;
		}else{
			min=oneDollars;
		}
		dp.put(money, min);
		return min;
	}

//	public static void main(String args[]) {
//		CoinChangeKata c = new CoinChangeKata();
//		long start=System.currentTimeMillis();
//		int result=c.getCoins(10.98);
//		long end=System.currentTimeMillis();
//		System.out.println(result);
//		System.out.println(end-start+" ms.");
//	}
}
