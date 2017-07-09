package com.m1.miage.sudoku.jeux;

import junit.framework.TestCase;

/**
 * Grille Test
 * 
 * @author Francis Konchou
 * @version 1.0
 */
public class GrilleTest extends TestCase {
	

	private GrilleImpl grille = new GrilleImpl();

	
	/**
	 * Constructeur
	 * 
	 * @param nm
	 */
	public GrilleTest(String nm) {
		super(nm);
	}

	/**
	 * test de la methode Complete
	 */
	public void testComplete() {

		assertTrue(grille.complete());
		grille.setValue(5, 5, Grille.EMPTY);
		assertFalse(grille.complete());

	}

	/**
	 * test de la methode GetDimension
	 */
	public void testGetDimension() {

		assertTrue(1 == grille.getDimension());
		assertFalse(2 == grille.getDimension());
		assertFalse(0 == grille.getDimension());

	}

	/**
	 * test de la methode GetValue
	 */
	public void testGetValue() {

		assertEquals('2', grille.getValue(0, 1));
		assertEquals('9', grille.getValue(0, 8));
		assertEquals('9', grille.getValue(2, 8));
		assertEquals('3', grille.getValue(2, 2));
		assertEquals('2', grille.getValue(2, 1));

		try {
			assertEquals('2', grille.getValue(20, 1));
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			assertEquals('2', grille.getValue(1, 13));
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			assertEquals('2', grille.getValue(-5, 13));
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			assertEquals('2', grille.getValue(1, -6));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * test de la methode Possible
	 */
	public void testPossible() {

		try {
			assertEquals(false, grille.possible(0, 1, 'f'));
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			assertEquals(true, grille.possible(0, 1, '1'));
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			assertEquals(true, grille.possible(6, 1, '2'));
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			assertEquals(false, grille.possible(2, 1, 'x'));
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			assertEquals(false, grille.possible(7, 1, 'b'));
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			assertEquals(false, grille.possible(10, 1, 'a'));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * test de la methode Possible
	 */
	public void testSetvalue() {

		try {
			grille.setValue(0, 1, 'f');
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			grille.setValue(0, 1, '1');
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			grille.setValue(6, 1, '2');
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			grille.setValue(2, 1, 'x');
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			grille.setValue(7, 1, 'b');
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			grille.setValue(10, 1, 'a');
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			grille.setValue(2, 15, 'a');
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			grille.setValue(-2, 15, 'a');
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			grille.setValue(2, -7, '1');
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
