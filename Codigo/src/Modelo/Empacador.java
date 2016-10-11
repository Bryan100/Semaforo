package Modelo;

public class Empacador extends Thread {

	private Bodega bodega;

	public Empacador(Bodega bodega) {
		
		this.bodega = bodega;
	}

	@Override
	public void run() {

		while (true) {
			
			try {
				bodega.crearPaquete();

				sleep(1100);
				
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}
