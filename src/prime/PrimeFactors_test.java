package prime;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PrimeFactors_test {
	
	PrimeFactors pf;
	
	@Before
	public void init(){
		pf=new PrimeFactors();
	}
	
	private List<Integer> list(int... ints) {
	    List<Integer> list = new ArrayList<Integer>();
	    for (int i : ints)
	      list.add(i);
	    return list;
	  }

	
	
	@Test
	public void test() {
		assertEquals(list(),pf.generate(-1));
		assertEquals(list(),pf.generate(0));
		assertEquals(list(),pf.generate(1));
		assertEquals(list(2),pf.generate(2));
		assertEquals(list(3),pf.generate(3));
		assertEquals(list(2,2),pf.generate(4));
		assertEquals(list(5),pf.generate(5));
		assertEquals(list(2,3),pf.generate(6));
		assertEquals(list(7),pf.generate(7));
		assertEquals(list(2,2,2),pf.generate(8));
	}

	
}
