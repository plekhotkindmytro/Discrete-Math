package project_1_4;

import static org.junit.Assert.*;

import org.junit.Test;

public class LiteralTest {

	@Test
	public void testConjunction() {
		Literal p = new Literal('p', false);
		Literal notP = new Literal('p', true);
		Literal q = new Literal('q', false);
		Literal notQ = new Literal('q', true);
		assertTrue(p.complements(notP));
		assertTrue(notP.complements(p));
		assertFalse(notP.complements(notP));
		assertFalse(p.complements(p));
		assertFalse(p.complements(q));
		assertFalse(p.complements(notQ));
		assertFalse(q.complements(p));
		assertFalse(q.complements(notP));

	}

}
