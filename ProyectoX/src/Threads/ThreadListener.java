package Threads;

import Grafica.*;

public class ThreadListener extends Thread {
	protected Juego gui;

	public ThreadListener(Juego j) {
		gui = j;
	}

	public void run() {
		while (true) {
			gui.termine();
			if (!gui.estaBloqueado()) {
				try{
					sleep(000000001);
				}catch (Exception e){}
				gui.mover();
				gui.bloqueado(false);
			}
		}
	}
}
