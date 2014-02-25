package com.gonghan.potterkata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/* 1: 8
 * 2: 8*2*95%
 * 3: 8*3*90%
 * 4: 8*4*80%
 * 5: 8*5*75%
 */
public class Potter_test {

	Potter potter;
	float delta;

	@Before
	public void init() {
		potter = new Potter();
		delta = 0.001f;
	}

	@Test
	public void testBasics() {
		int[] list0 = {};
		assertEquals(0, potter.price(list0), delta);
		int[] list1 = { 0 };
		assertEquals(8.0, potter.price(list1), delta);
		int[] list2 = { 1 };
		assertEquals(8.0, potter.price(list2), delta);
		int[] list3 = { 2 };
		assertEquals(8.0, potter.price(list3), delta);
		int[] list4 = { 3 };
		assertEquals(8.0, potter.price(list4), delta);
		int[] list5 = { 4 };
		assertEquals(8.0, potter.price(list5), delta);
	}

	@Test
	public void testSimpleDiscounts() {
		int[] list1 = { 0 };
		assertEquals(8.0, potter.price(list1), delta);
		int[] list2 = { 0, 1 };
		assertEquals(8.0 * 2 * 0.95, potter.price(list2), delta);
		int[] list3 = { 0, 1, 2 };
		assertEquals(8.0 * 3 * 0.90, potter.price(list3), delta);
		int[] list4 = { 0, 1, 2, 3 };
		assertEquals(8.0 * 4 * 0.80, potter.price(list4), delta);
		int[] list5 = { 0, 1, 2, 3, 4 };
		assertEquals(8.0 * 5 * 0.75, potter.price(list5), delta);
	}

	@Test
	public void testSeveralDiscounts() {
		int list1[] = { 0, 0, 1 };
		assertEquals(8.0 + 8.0 * 2 * 0.95, potter.price(list1), delta);
		int list2[] = { 0, 0, 1, 1 };
		assertEquals(2 * 8.0 * 2 * 0.95, potter.price(list2), delta);
		int list3[] = { 0, 0, 1, 2, 2, 3 };
		assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95), potter.price(list3), delta);
		int list4[] = { 0, 1, 1, 2, 3, 4 };
		assertEquals(8 + (8 * 5 * 0.75), potter.price(list4), delta);
	}

	@Test
	public void testEdgeCases() {
		int list1[] = { 0, 0, 1, 1, 2, 2, 3, 4 };
		assertEquals(2 * (8 * 4 * 0.8), potter.price(list1), delta);
		int list2[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3,
				3, 4, 4, 4, 4 };
		assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8),
				potter.price(list2), delta);
	}

//	@Test
//	public void testBigData() {
//		int list[]=new int[1000];
//		for(int i=0;i<500;i++){
//			list[i]=0;
//		}
//		for(int i=500;i<600;i++){
//			list[i]=1;
//		}
//		for(int i=600;i<700;i++){
//			list[i]=2;
//		}
//		for(int i=700;i<800;i++){
//			list[i]=3;
//		}
//		for(int i=800;i<1000;i++){
//			list[i]=4;
//		}
//		assertEquals(1,potter.price(list),delta);
//	}
	
//	@Test
//	public void testSixItems(){
//		
//	}
}
