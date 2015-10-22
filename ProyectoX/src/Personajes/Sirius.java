/**
 * Es el enemigo mas inteligente de Boomberman, capaz de perseguirlo y muy veloz
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Personajes;


import mapa.Celda;
import Grafica.SiriusGrafico;

public class Sirius extends Enemigo {

	// Constructor
	public Sirius(Celda c) {
		super(c);
		p=new SiriusGrafico(celda.getPosX()*32,celda.getPosY()*32);
		puntaje = 50;
		especial = false;
		velocidad = 3;
	}

	// Metodos

	/**
	 * Describe el comportamiento del enemigo, en relacion a sus movimientos y
	 * ataques
	 */
	public void run() {
		/* A completar */
	}
}