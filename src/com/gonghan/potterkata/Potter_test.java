package com.gonghan.potterkata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Potter_test {

	Potter potter;

	@Before
	public void init() {
		potter = new Potter();
	}

	@Test
	public void testBasics() {
		int[]list={1};
		assertEquals(8.0d,potter.price(list));
	}
}
