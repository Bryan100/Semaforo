package Modelo;

public class Operario extends Thread {

	private Bodega bodega;

	public Operario(Bodega bodega) {
		this.bodega = bodega;
	}

	@Override
	public void run() {
		
		while (true) {
			
			int tipo = (int)(Math.random()*2 + 1);
			
			try {
				
				bodega.descargarPaquete(tipo);
				
				sleep(1000);

			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	}

}
