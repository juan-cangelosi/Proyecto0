package mapa;

import Bomba.Bomba;
import Personajes.*;
import PowerUp.*;
import Grafica.*;
/**
 * Clase ParedDestruible representa a las paredes que al explotar la bomba se destruyen y pueden ser atravesadas
 * por bomberman en modos dios y por Altair.
 */
public class ParedDestruible implements EstadoCelda {

	/**
	 * La pared Destruible solo puede ser avanzada por bomberman si es especial
	 */
	public void serAvanzado(Bomberman b,PowerUp p, Celda c, int n){
		System.out.println("pared dest");
		if(b.esEspecial()){
			c.setBomberman(b);
			PersonajeGrafico pg= b.grafico();
			switch(n){
			case 0: {pg.arriba(); break;}
			case 1: {pg.abajo(); break;}
			case 2: {pg.izquierda(); break;}
			case 3: {pg.derecha(); break;}
			}
		}

	}
	/**
	 * La pared destruible solo puede ser avanzada por el enemigo que es especial, es decir rugulos.
	 */
	public void serAvanzado(Enemigo e, Celda c, int n){
		if(e.esEspecial()){
			c.setEnemigo(e);
			PersonajeGrafico pg= e.grafico();
			switch(n){
			case 0: {pg.arriba(); break;}
			case 1: {pg.abajo(); break;}
			case 2: {pg.izquierda(); break;}
			case 3: {pg.derecha(); break;}
			}
		}
	}
	/**
	 * Al ser destruida la pared retorna el puntaje de la destruccion y setea el estado de la celda c en piso
	 * tambien se decrementa la cantidad de paredes restantes en el mapa.
	 */
	public int destruir(Celda c){
		c.setEstado(new Piso());
		c.getMapa().decrementarPared();
		c.mostrarPowerUp();
		return 10;
	}
	/**
	 * Una pared destruible no puede tener bombas
	 */
	public void ocuparBomba(Bomba b,Celda c){
	}
	
	/**
	 * Se le envia a las celdas adyacentes el mensaje explosion con el radio disminuido
	 */
	public int explosionArriba(Celda c,int r){
		return destruir(c);
	}
	/**
	 * Se le envia a las celdas adyacentes el mensaje explosion con el radio disminuido
	 */
	public int explosionAbajo(Celda c,int r){
		return destruir(c);		
	}
	/**
	 * Se le envia a las celdas adyacentes el mensaje explosion con el radio disminuido
	 */
	public int explosionIzq(Celda c,int r){
		return destruir(c);
	}
	/**
	 * Se le envia a las celdas adyacentes el mensaje explosion con el radio disminuido
	 */
	public int explosionDer(Celda c,int r){
		return destruir(c);
	}
	public void setImagen(EstadoGrafico e){
		e.setParedDestruible();
	}

}
