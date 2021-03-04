package ch.hslu.einfuehrung;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

class AllocationTest {

	
		Allocation alc = new Allocation(0, 32);
		Allocation alc2 = new Allocation(32, 16);
		Allocation alc3 = new Allocation(32, 16);
	

	@Test
	void testHashCode() {
		assertEquals(false, alc.equals(alc2));
	}

	@Test
	void testGetAddress() {
		assertEquals(0, alc.getAddress());
	}

	@Test
	void testGetSize() {
		assertEquals(32, alc.getSize());
	}
	
	@Test
	public void equalsContract() {
	    EqualsVerifier.forClass(Allocation.class).verify();
	}
	
	@Test
	public void testComparable() {
		assertEquals(-1, alc.compareTo(alc2));
		assertEquals(1, alc2.compareTo(alc));
		assertEquals(0, alc2.compareTo(alc3));
	}

	// AssertJ 
	/*	@Test 
	void testWithAssertJ() {
	assertThat(alc)
	.hasAddress(0)
    .hasSize(32);
	} */

}
