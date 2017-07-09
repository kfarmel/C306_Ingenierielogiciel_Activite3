package com.m1.miage.sudoku.jeux;

/**
 * Implementation d'une grille.
 * 
 * @author Francis Konchou
 * @version 1.0
 */
public class GrilleImpl implements Grille {

	/**
	 * ligne.
	 */
	private final int lig = 9;

	/**
	 * colonne.
	 */
	private final int col = 9;

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
		grille = new char[lig][col];
		for (int i = 0; i < lig; ++i) {
			for (int j = 0; j < col; ++j) {
				grille[i][j] = Grille.possible[j];
			}
		}
	}

	/**
	 * checkGrille.
	 * 
	 * @param a
	 *            ligne
	 * @param b
	 *            colonne
	 */
	private void checkGrille(final int a, final int b) {

		if (a < 0 || a > this.lig) {
			throw new IllegalArgumentException();
		}

		if (b < 0 || b > this.col) {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * checkGrille.
	 * 
	 * @param x
	 *            ligne
	 * @param y
	 *            colonne
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
			if (v == Grille.possible[i] || v == Grille.EMPTY) {
				trouv = true;
			}
		}
		if (!trouv) {
			throw new IllegalArgumentException();
		}
		return true;
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
		for (int i = 0; i < lig; ++i) {
			for (int j = 0; j < col; ++j) {
				if (Grille.EMPTY == grille[i][j]) {
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
		return this.lig / this.col;
	}

	/**
	 * Recupere une valeur de la grille.
	 * 
	 * @param x
	 *            position x dans la grille
	 * @param y
	 *            position y dans la grille
	 * @return valeur dans la case x,y
	 * @throws IllegalArgumentException
	 *             si x ou y sont hors bornes (0-8)
	 */
	public char getValue(final int x, final int y)
			throws IllegalArgumentException {

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
	 * @throws IllegalArgumentException
	 *             si x ou y sont hors bornes (0-8)
	 * @throws IllegalArgumentException
	 *             si value n'est pas un caractere autorise ('1',...,'9',..)
	 * @return reponse si c'est possible
	 */
	public boolean possible(final int x, final int y, final char value)
			throws IllegalArgumentException {
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
	 * @throws IllegalArgumentException
	 *             si x ou y sont hors bornes (0-8)
	 * @throws IllegalArgumentException
	 *             si la valeur est interdite aux vues des autres valeurs de la
	 *             grille
	 * @throws IllegalArgumentException
	 *             si value n'est pas un caractere autorise ('1',...,'9')
	 */
	public void setValue(final int x, final int y, final char value)
			throws IllegalArgumentException {

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
