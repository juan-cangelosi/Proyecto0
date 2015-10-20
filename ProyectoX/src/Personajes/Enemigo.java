/**
 * Es la clase abstracta que engloba todo lo que los enemigos disponene para hacer
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Personajes;

import InteligenciaArtificial.IA;
import Logica.Celda;

public abstract class Enemigo extends Personaje implements IA {
	// Atributos de Instancia
	protected int puntaje;

	// Constructor
	protected Enemigo(Celda c) {
		super(c);
	}

	// Metodos Abstractos
	/**
	 * Establece al enemigo como muerto
	 * 
	 * @return retorna el puntaje que el enemigo posee al morir
	 */
	public abstract int morir();

	/**
	 * Describe el comportamiento del enemigo, en relacion a sus movimientos y
	 * ataques
	 */
	public abstract void loop();

	// Metodos

	/**
	 * Mueve al enemigo hacia arriba
	 */
	public void arriba() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x, y + 1);
		celda.ocuparBomberMan(null);
		c.ocuparEnemigo(this);
	}

	/**
	 * Mueve al enemigo hacia abajo
	 */
	public void abajo() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x, y - 1);
		celda.ocuparBomberMan(null);
		c.ocuparEnemigo(this);
	}

	/**
	 * Mueve al enemigo hacia la izquierda
	 */
	public void izquierda() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x - 1, y);
		celda.ocuparBomberMan(null);
		c.ocuparEnemigo(this);
	}

	/**
	 * Mueve al enemigo hacia la derecha
	 */
	public void derecha() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x + 1, y);
		celda.ocuparBomberMan(null);
		c.ocuparEnemigo(this);
	}
}