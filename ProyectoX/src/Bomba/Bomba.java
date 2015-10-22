/**
 * Clase con el proposito de brindar un bomba capaz de destruir los enemigos del mapa
 * asi como de destruir las paredes que lo permitan
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Bomba;

import mapa.Celda;
import Grafica.BombaGrafica;
import java.lang.Thread;

public class Bomba extends Thread {
	// Atributos de Instancia
	protected int radio;
	protected Celda c;
	protected AbstractFactory a;
	protected BombaGrafica b;

	// Constructor
	public Bomba(Celda celda, AbstractFactory a) {
		this.a = a;
		c = celda;
		radio = 1;
	}

	// Metodos
	/**
	 * Permite modificar el radio de explosion de la bomba
	 * 
	 * @param i
	 *            es la nueva magnitud de la explosion de la bomba
	 */
	public void setRadio(int i) {
		radio = i;
	}

	/**
	 * Activa el timer de la bomba, que luego explotara
	 */
	public void activar() {
		a.bombaMas();
		b.colocarBomba();
		run();
	}
	
	/**
	 * Espera 5 segundos y luego explota la bomba
	 */
	public void run() {
		try {
			Thread.sleep(5000);
			explotar();
		} catch (InterruptedException e) {
			
		}
	}

	// Consultas

	/**
	 * revisa celda a celda del mapa dentro del radio, destruye las
	 * destructibles y mata a los personajes de las transitables
	 * 
	 * @return retorna el puntaje obtenido de matar 0 o mas personajes
	 */
	public int explotar() {
		int puntaje = 0;
		a.bombaMenos();
		b.explotarBomba();
		puntaje = c.explotarBomba();
		/*
		 * Celda c1 = c.getMapa().getCelda(c.getPosX() + 1, c.getPosY());
		 * puntaje += c1.explotarBomba();
		 * 
		 * c1 = c.getMapa().getCelda(c.getPosX() - 1, c.getPosY()); puntaje +=
		 * c1.explotarBomba();
		 * 
		 * c1 = c.getMapa().getCelda(c.getPosX(), c.getPosY() + 1); puntaje +=
		 * c1.explotarBomba();
		 * 
		 * c1 = c.getMapa().getCelda(c.getPosX(), c.getPosY() - 1); puntaje +=
		 * c1.explotarBomba();
		 */

		return puntaje;
	}

	/**
	 * Devuelve el radio de la bomba
	 * 
	 * @return retorna el radio de explosion de la bomba
	 */
	public int getRadio() {
		return radio;
	}

	/**
	 * Devuelve la celda en la cual la bomba esta colocada
	 * 
	 * @return retorna la celda donde se encuentra la bomba
	 */
	public Celda getCelda() {
		return c;
	}

}