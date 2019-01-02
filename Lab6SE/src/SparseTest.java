import static org.junit.Assert.*;
import org.junit.Test;
public class SparseTest {
	@Test
	public void testCompare() {
		Sparse<Integer> i1 = new Sparse<Integer>();
		assertTrue(-1 == i1.minIndex());
		assertTrue(-1 == i1.maxIndex());
		assertTrue(0== i1.size());
		assertTrue(null == i1.get(1));

		i1.add(0,1);
		i1.add(1,2);
		assertTrue(1 == i1.get(0));
		assertTrue(2 == i1.get(1));

		assertTrue(0== i1.minIndex());
		assertTrue(1== i1.maxIndex());
		assertTrue(2== i1.size());
		i1.removeAt(0);
		i1.removeAt(1);
		assertTrue(null == i1.get(0));
		assertTrue(null == i1.get(1));

		assertTrue(-1== i1.minIndex());
		assertTrue(-1== i1.maxIndex());
		assertTrue(0 == i1.size());
		
		i1.add(1,2);
		i1.add(1,2);
		i1.add(1,2);
		assertTrue(1 == i1.size());
		i1.add(0,1);
		i1.add(3,2);
		i1.add(100,2);
		i1.add(8,4);
		i1.add(17,5);
		i1.removeElem(2);
		
		assertTrue(null == i1.get(2));

		assertTrue(2 == i1.get(100));
		assertTrue(2 == i1.get(3));




		
		Sparse<String> i2 = new Sparse<String>();
		assertEquals(-1 , i2.minIndex());
		assertEquals(-1 , i2.maxIndex());
		assertEquals(0, i2.size());
		i2.add(0,"A");
		i2.add(1,"B");
		assertEquals(0, i2.minIndex());
		assertEquals(1, i2.maxIndex());
		assertEquals(2, i2.size());
		i2.removeAt(0);
		i2.removeAt(1);
		assertEquals(-1, i2.minIndex());
		assertEquals(-1, i2.maxIndex());
		assertEquals(0, i2.size());
		
		
		i2.add(1,"a");
		i2.add(1,"a");
		i2.add(1,"a");
		assertTrue(1 == i2.size());
		i2.add(0,"z");
		i2.add(3,"c");
		i2.add(100,"aaa");
		i2.add(8,"h");
		i2.add(17,"kjasld");
		i2.removeElem("aaa");
		
		assertTrue(null == i2.get(100));

		assertEquals("h", i2.get(8));
		assertEquals("c", i2.get(3));
		assertEquals(0, i2.minIndex());
		assertEquals(17, i2.maxIndex());

		
	}
}
