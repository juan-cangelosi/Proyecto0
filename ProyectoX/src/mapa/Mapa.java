package mapa;
import java.util.Random;

import Bomba.*;
import Personajes.*;
import PowerUp.Bombality;
import PowerUp.Fatality;
import PowerUp.Masacrality;
import PowerUp.PowerUp;
import PowerUp.SpeedUp;
/**
 * Clase Mapa representa al mapa del juego, que sera de 31x13 celdas.
 */
public class Mapa {
	//atributos
	protected Celda[][] celdas;
	protected Enemigo[] enemigos;
	protected int paredesDest=125;
	
	/**
	 * Crea un nuevo Mapa de 31x13, inicializando los bordes, las paredes y el piso
	 */
	public Mapa(){
		celdas=new Celda[31][13];
		enemigos=new Enemigo[6];
		inicializarBordes();
		colocarParedes();
		inicializarEnemigos();
		colocarEnemigos();
		inicializarPiso();
		
	}
	/**
	 * Retorna la celda en las coordenadas x, y
	 */
	public Celda getCelda(int x, int y){
		return celdas[x][y];
	}
	/**
	 * Metodo auxiliar que inicializa los bordes como paredes indestructibles
	 */
	
	private void inicializarBordes(){
		for( int i= 0; i<13; i++){
			celdas[0][i]=new Celda(new Pared(),this,0,i);
			celdas[30][i]=new Celda(new Pared(),this,30,i);
		}
		//los bordes ya se inicializaron con el loop superior
		for(int i=1; i<30; i++){
			celdas[i][0]=new Celda(new Pared(),this,i,0);
			celdas[i][12]=new Celda(new Pared(),this,i,12);
		}
	}
	/**
	 * Metodo auxiliar que inicializa todo las celdas nulas como piso
	 */
	private void inicializarPiso(){
		for(int i=0; i<31;i++){
			for(int j=0; j<13; j++){
				if(celdas[i][j]==null){
					celdas[i][j]=new Celda(new Piso(),this,i,j);
				}
			}
		}
	}
	/**
	 * Metodo auxiliar que coloca las paredes indestructibles y luego coloca las destructibles en lo que queda libre
	 * del mapa, agregando los powerups correspondientes a las mismas.
	 */
	
	private void colocarParedes(){
		Random generador=new Random();
		for(int i=2;i<=28;i=(i+2)){
			for(int j=2;j<=10;j=(j+2)){
				celdas[i][j]=new Celda(new Pared(),this,i,j);
			}
		}
		int cantParedesDes=0;
		int cantPowerUps=0;
		PowerUp powerups[]=inicializarPowerUps();
		
		while(cantParedesDes<paredesDest){
			int posX=0;
			int posY=0;
			while((posX<2 && posY<2) || (posX>11 && posY>29) || celdas[posX][posY]!=null){
				posX=1+generador.nextInt(29);
				posY=1+generador.nextInt(11);
			}
			celdas[posX][posY]=new Celda(new ParedDestruible(),this,posX,posY);
			cantParedesDes++;
			if(cantPowerUps<powerups.length){
				celdas[posX][posY].setPowerUp(powerups[cantPowerUps]);
				cantPowerUps++;
			}
		}
	}
	/**
	 * Metodo auxiliar que inicializa el arreglo de enemigos
	 */
	private void inicializarEnemigos(){
		enemigos[0]=new Rugulos(null);
		enemigos[1]=new Rugulos(null);
		enemigos[2]=new Rugulos(null);
		enemigos[3]=new Altair(null);
		enemigos[4]=new Altair(null);
		enemigos[5]=new Sirius(null);
	}
	/**
	 * Metodo auxiliar que coloca los enemigosen las celdas correspondientes
	 */
	private void colocarEnemigos(){
		Random generador=new Random();
		int posX=0;
		int posY=0;
		for(int i=0; i<enemigos.length-1;i++){
			while((posX<2 && posY<2) || (posX>11 && posY>29) || celdas[posX][posY]!=null){
				posX=1+generador.nextInt(29);
				posY=1+generador.nextInt(11);
			}
			celdas[posX][posY]=new Celda(new Piso(),this,posX,posY);
			celdas[posX][posY].setEnemigo(enemigos[i]);
		}
		celdas[29][12]=new Celda(new Piso(),this,29,12);
		celdas[29][12].setEnemigo(enemigos[5]);
	}
	/**
	 * Metodo auxiliar que crea y devuelve un arreglo de powerUps
	 */
	private PowerUp[] inicializarPowerUps(){
		PowerUp powerups[]=new PowerUp[11];
		for(int i=0; i<4; i++){
			powerups[i]=new SpeedUp();
		}
		for(int i=4; i<7;i++){
			powerups[i]=new Fatality();
			powerups[i+3]=new Bombality();
		}
		powerups[10]=new Masacrality();
		return powerups;
	}
	public int getCantParedesDest(){
		return paredesDest;
	}
	public void decrementarPared(){
		paredesDest--;
	}
}
