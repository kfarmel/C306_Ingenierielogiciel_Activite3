package com.m1.miage.sudoku.jeux;

/**
 * Grille
 * @author Francis Konchou
 * @version 1.0
 */
public interface Grille {

	/**
	 * @return largeur/hauteur de la grille
	 */
	public int getDimension();

	/**
	 * Affecte une valeur dans la grille
	 * 
	 * @param x
	 *            position x dans la grille
	 * @param y
	 *            position y dans la grille
	 * @param value
	 *            valeur a mettre dans la case
	 */
	public void setValue(int x, int y, char value);

	/**
	 * Recupere une valeur de la grille
	 * 
	 * @param x
	 *            position x dans la grille
	 * @param y
	 *            position y dans la grille
	 * @return valeur dans la case x,y
	 */
	public char getValue(int x, int y);

	/**
	 * Test si une grille est terminee
	 * 
	 * @return true si la grille est complete
	 */
	public boolean complete();

	/**
	 * Test si une valeur est possible dans la grille par rapport a ce qu'elle
	 * contient deja
	 * 
	 * @param x
	 *            position x dans la grille
	 * @param y
	 *            position y dans la grille
	 * @param value
	 *            valeur a mettre dans la case
	 */
	public boolean possible(int x, int y, char value);

}
