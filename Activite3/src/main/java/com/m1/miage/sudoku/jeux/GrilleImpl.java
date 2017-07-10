package com.m1.miage.sudoku.jeux;

/**
 * Implementation d'une grille.
 * 
 * @author Francis Konchou
 * @version 1.0
 */
public class GrilleImpl implements Grille {
	
	/**
	 * Caractere de case vide
	 */
	public static final char EMPTY = '@';

	/**
	 * Caractere possible a mettre dans la grille
	 * 
	 * pour une grille 9x9 : 1..9
	 * 
	 * pour une grille 16x16: 0..9-a..f
	 */
	protected static final char[] tab_possible = new char[] { '1', '2', '3', '4', '5', '6','7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * LIGNEne.
	 */
	private static final int LIGNE = 9;

	/**
	 * COLONEonne.
	 */
	private static final int COLONE = 9;

	/**
	 * grille.
	 */
	private char[][] grille;

	/**
	 * Le constructeur. Cree la grille, les cases internes, les groupes et les
	 * verrous.
	 **/
	public GrilleImpl() {
		
		/**
		 * creer la grille.
		 */
		grille = new char[LIGNE][COLONE];
		for (int i = 0; i < LIGNE; ++i) {
			for (int j = 0; j < COLONE; ++j) {
				grille[i][j] = tab_possible[j];
			}
		}
		
	}

	/**
	 * checkGrille.
	 * 
	 * @param a
	 *            LIGNEne
	 * @param b
	 *            COLONEonne
	 */
	private void checkGrille(final int a, final int b) {

		if (a < 0 || a > LIGNE) {
			throw new IllegalArgumentException();
		}

		if (b < 0 || b > COLONE) {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * checkGrille.
	 * 
	 * @param x
	 *            LIGNEne
	 * @param y
	 *            COLONEonne
	 * @param v
	 *            valeur
	 * @return si insertion possible
	 */
	private boolean checkGrille(final int x, final int y, final char v) {

		/**
		 * controle borne du tableau.
		 */
		checkGrille(x, y);

		/**
		 * controle de la valeur.
		 */
		boolean trouv = false;
		for (int i = 0; i < x; ++i) {
			if (v == tab_possible[i] || v == EMPTY) {
				trouv = true;
			}
		}
		
		return trouv;
	
	}

	/**
	 * Test si une grille est terminee.
	 * 
	 * @return true si la grille est complete
	 */
	public boolean complete() {
		/**
		 * check complete.
		 */
		for (int i = 0; i < LIGNE; ++i) {
			for (int j = 0; j < COLONE; ++j) {
				if (EMPTY == grille[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

	/**
	 * @return largeur/hauteur de la grille
	 */
	public int getDimension() {
		// value
		return LIGNE / COLONE;
	}

	/**
	 * Recupere une valeur de la grille.
	 * 
	 * @param x
	 *            position x dans la grille
	 * @param y
	 *            position y dans la grille
	 * @return valeur dans la case x,y
	 */
	public char getValue(final int x, final int y) {

		/**
		 * control Grille
		 */
		checkGrille(x, y);

		/**
		 * get value
		 */
		return grille[x][y];

	}

	/**
	 * Test si une valeur est possible dans la grille par rapport a ce qu'elle
	 * contient deja.
	 * 
	 * @param x
	 *            position x dans la grille
	 * @param y
	 *            position y dans la grille
	 * @param value
	 *            valeur a mettre dans la case
	 * @return reponse si c'est possible
	 */
	public boolean possible(final int x, final int y, final char value){
		/**
		 * checkGrille
		 */
		return checkGrille(x, y, value);
	}
	
	/**
	 * Affecte une valeur dans la grille.
	 * 
	 * @param x
	 *            position x dans la grille
	 * @param y
	 *            position y dans la grille
	 * @param value
	 *            valeur a mettre dans la case
	 */
	public void setValue(final int x, final int y, final char value){

		/**
		 * checkGrille
		 */
		checkGrille(x, y, value);

		/**
		 * MAj
		 */
		grille[x][y] = value;

	}

	

}
