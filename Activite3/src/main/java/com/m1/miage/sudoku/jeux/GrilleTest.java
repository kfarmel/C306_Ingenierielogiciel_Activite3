package com.m1.miage.sudoku.jeux;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

/**
 * Grille Test
 * 
 * @author Francis Konchou
 * @version 1.0
 */
public class GrilleTest extends TestCase {
	
	private static Logger logger = Logger.getLogger(GrilleTest.class);
	
	/**
	 * Constructeur
	 * 
	 * @param nm
	 */
	public GrilleTest(){
		super();
	}

	/**
	 * test de la methode Complete
	 */
	public void testComplete() {

		GrilleImpl grille = new GrilleImpl();
		assertTrue(grille.complete());
		grille.setValue(5, 5, GrilleImpl.EMPTY);
		assertFalse(grille.complete());

	}
	
	/**
	 * test de la methode InComplete
	 */
	public void testInComplete() {

		GrilleImpl grille = new GrilleImpl();
		grille.setValue(5, 5, GrilleImpl.EMPTY);
		assertFalse(grille.complete());

	}

	/**
	 * test de la methode GetDimension
	 */
	public void testGetDimension() {

		GrilleImpl grille = new GrilleImpl();
		assertTrue(1 == grille.getDimension());
		assertFalse(2 == grille.getDimension());

	}

	/**
	 * test de la methode GetValue
	 */
	public void testGetValue() {

		GrilleImpl grille = new GrilleImpl();
		
		assertEquals('2', grille.getValue(0, 1));
		assertEquals('9', grille.getValue(0, 8));
		assertEquals('9', grille.getValue(2, 8));
		assertEquals('3', grille.getValue(2, 2));
		assertEquals('2', grille.getValue(2, 1));

		try {
			assertEquals('2', grille.getValue(20, 1));
		} catch (Exception e) {
			logger.error("assertEquals('2', grille.getValue(20, 1)) ", e);
		}

		try {
			assertEquals('2', grille.getValue(1, 13));
		} catch (Exception e) {
			logger.error("assertEquals('2', grille.getValue(1, 13)) ", e);
		}

		try {
			assertEquals('2', grille.getValue(-5, 13));
		} catch (Exception e) {
			logger.error("assertEquals('2', grille.getValue(-5, 13)) ", e);
		}

		try {
			assertEquals('2', grille.getValue(1, -6));
		} catch (Exception e) {
			logger.error("assertEquals('2', grille.getValue(1, -6)) ", e);
		}

	}

	/**
	 * test de la methode Possible
	 */
	public void testPossible() {
		
		GrilleImpl grille = new GrilleImpl();

		try {
			assertEquals(false, grille.possible(0, 1, 'f'));
		} catch (Exception e) {
			logger.error("assertEquals(false, grille.possible(0, 1, 'f')) ", e);
		}

		try {
			assertEquals(true, grille.possible(0, 1, '1'));
		} catch (Exception e) {
			logger.error("assertEquals(true, grille.possible(0, 1, '1')) ", e);
		}

		try {
			assertEquals(false, grille.possible(2, 1, 'x'));
		} catch (Exception e) {
			logger.error("assertEquals(false, grille.possible(2, 1, 'x')) ", e);
		}

		try {
			assertEquals(false, grille.possible(7, 1, 'b'));
		} catch (Exception e) {
			logger.error("assertEquals(false, grille.possible(7, 1, 'b'))", e);
		}

		try {
			assertEquals(false, grille.possible(10, 1, 'a'));
		} catch (Exception e) {
			logger.error("assertEquals(false, grille.possible(10, 1, 'a'))", e);
		}

	}

	/**
	 * test de la methode Possible
	 */
	public void testSetvalue() {

		GrilleImpl grille = new GrilleImpl();
		
		try {
			grille.setValue(0, 1, 'f');
		} catch (Exception e) {
			logger.error("grille.setValue(0, 1, 'f') ", e);
		}

		try {
			grille.setValue(0, 1, '1');
		} catch (Exception e) {
			logger.error("grille.setValue(0, 1, '1') ", e);
		}

		try {
			grille.setValue(6, 1, '2');
		} catch (Exception e) {
			logger.error("grille.setValue(6, 1, '2')", e);
		}

		try {
			grille.setValue(2, 1, 'x');
		} catch (Exception e) {
			logger.error("grille.setValue(2, 1, 'x') ", e);
		}

		try {
			grille.setValue(7, 1, 'b');
		} catch (Exception e) {
			logger.error("grille.setValue(7, 1, 'b')", e);
		}

		try {
			grille.setValue(-2, 15, 'a');
		} catch (Exception e) {
			logger.error("grille.setValue(-2, 15, 'a')", e);
		}

		try {
			grille.setValue(2, -7, '1');
		} catch (Exception e) {
			logger.error("grille.setValue(2, -7, '1')", e);
		}

	}

}
