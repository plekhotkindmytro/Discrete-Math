package project_1_1;

import static org.junit.Assert.*;
import static project_1_1.Algorithms.*;

import org.junit.Test;

public class AlgorithmsTest {

	@Test
	public void testConjunction() {
		assertTrue(conjunction(true, true));
		assertFalse(conjunction(true, false));
		assertFalse(conjunction(false, true));
		assertFalse(conjunction(false, false));
	}

	@Test
	public void testDisjunction() {
		assertTrue(disjunction(true, true));
		assertTrue(disjunction(true, false));
		assertTrue(disjunction(false, true));
		assertFalse(disjunction(false, false));
	}

	@Test
	public void testAlternativeDisjunction() {
		assertFalse(alternativeDisjunction(true, true));
		assertTrue(alternativeDisjunction(true, false));
		assertTrue(alternativeDisjunction(false, true));
		assertFalse(alternativeDisjunction(false, false));
	}

	@Test
	public void testImplication() {
		assertTrue(implication(true, true));
		assertFalse(implication(true, false));
		assertTrue(implication(false, true));
		assertTrue(implication(false, false));
	}

	@Test
	public void testEquivalence() {
		assertTrue(equivalence(true, true));
		assertFalse(equivalence(true, false));
		assertFalse(equivalence(false, true));
		assertTrue(equivalence(false, false));
	}

}
