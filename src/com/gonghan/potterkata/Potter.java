package com.gonghan.potterkata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
 * One copy of any of the five books costs 8 EUR.
 * If, however, you buy two different books from the series,
 * you get a 5% discount on those two books. If you buy 3 
 * different books, you get a 10% discount. With 4 different
 * books, you get a 20% discount. If you go the whole hog,
 * and buy all 5, you get a huge 25% discount.
 * 
 * 1: 8
 * 2: 8*2*95%
 * 3: 8*3*90%
 * 4: 8*4*80%
 * 5: 8*5*75%
 * 
 */
public class Potter {

	Map<Integer, Double> ruleMap;
	Map<String, Double> dp;
	final double BASE_PRICE = 8d;

	public double price(int[] list) {
		// nums[i] shows the number of the ith book in the list
		dp = new HashMap<>();
		ruleMap = new HashMap<>();
		ruleMap.put(0, 0d);
		ruleMap.put(1, 1d);
		ruleMap.put(2, 0.95d);
		ruleMap.put(3, 0.90d);
		ruleMap.put(4, 0.80d);
		ruleMap.put(5, 0.75d);
		int[] nums = new int[ruleMap.keySet().size()];
		for (int i : list) {
			nums[i]++;
		}
		Arrays.sort(nums);
		return calculatePrice(nums);
	}

	private double calculatePrice(int[] nums) {
		if (isAllZero(nums)) {
			return 0d;
		}
		String numsString = arrayToString(nums);
		if (dp.containsKey(numsString)) {
			return dp.get(numsString);
		}

		// generate all possible permutations
		ArrayList<ArrayList<Integer>> permutations = getPermutations(nums);

		double minimum = Double.MAX_VALUE;
		for (ArrayList<Integer> list : permutations) {
			if (list.isEmpty()) {
				continue;
			}

			for (int i : list) {
				nums[i]--;
			}
			int listSize = list.size();
			minimum = Math.min(
					calculatePrice(nums) + BASE_PRICE * ruleMap.get(listSize)
							* listSize, minimum);
			// recover
			for (int i : list) {
				nums[i]++;
			}
		}
		dp.put(numsString, minimum);
		return minimum;
	}

	private ArrayList<ArrayList<Integer>> getPermutations(int[] array) {
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
		permutations.add(new ArrayList<Integer>());
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				int psize = permutations.size();
				for (int j = 0; j < psize; j++) {
					ArrayList<Integer> tmplist = new ArrayList<>(
							permutations.get(j));
					tmplist.add(i);
					permutations.add(tmplist);
				}
			}
		}
		return permutations;
	}

	private String arrayToString(int[] array) {
		String result = "";
		for (int i : array) {
			result += i + ",";
		}
		return result;
	}

	private boolean isAllZero(int[] array) {
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		if (sum == 0) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		Potter p = new Potter();
		int list[] = { 1, 3, 2, 4, 0 };
		System.out.println(p.price(list));
	}
}
