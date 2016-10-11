package Modelo;

import java.util.concurrent.Semaphore;

public class Bodega {

	private final static int CAPACIDAD_MAXIMA = 200;
	private final static int VOLUMEN_ARTICULO_TIPO_UNO = 10;
	private final static int VOLUMEN_ARTICULO_TIPO_DOS = 15;
	private final static int TIPO_UNO = 1;
	private final static int TIPO_DOS = 2;

	private int cantidadTipoUno, cantidadtipoDos, capacidadBodega;

	private Semaphore cantidadAT1Guardados;
	private Semaphore cantidadAT2Guardados;
	private Semaphore volumenDisponible;
	private Semaphore mutex;

	public Bodega() {

		cantidadTipoUno = 0;
		cantidadtipoDos = 0;

		capacidadBodega = CAPACIDAD_MAXIMA;

		cantidadAT1Guardados = new Semaphore(cantidadTipoUno);
		cantidadAT2Guardados = new Semaphore(cantidadtipoDos);
		volumenDisponible = new Semaphore(CAPACIDAD_MAXIMA);

		mutex = new Semaphore(1);

		System.out.println("Bodega inicializada!");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");

	}

	public void descargarPaquete(int tipo) throws InterruptedException {

		if (tipo == TIPO_UNO) {

			
			volumenDisponible.acquire(VOLUMEN_ARTICULO_TIPO_UNO);

			mutex.acquire();

			capacidadBodega = capacidadBodega - VOLUMEN_ARTICULO_TIPO_UNO;
			cantidadTipoUno++;

			mutex.release();

			cantidadAT1Guardados.release(1);

			System.out.println("Se guardó un articulo Tipo Uno !");

			darEstadoActual();

		} else if (tipo == TIPO_DOS) {


			volumenDisponible.acquire(VOLUMEN_ARTICULO_TIPO_DOS);

			mutex.acquire();

			capacidadBodega = capacidadBodega - VOLUMEN_ARTICULO_TIPO_DOS;
			cantidadtipoDos++;

			mutex.release();

			cantidadAT2Guardados.release(1);

			System.out.println("Se guardó un articulo Tipo Dos !");
			
			darEstadoActual();

		}
	}

	public void crearPaquete() throws InterruptedException {
		
		cantidadAT1Guardados.acquire(3);
		cantidadAT2Guardados.acquire(4);

		mutex.acquire();

		cantidadTipoUno -= 3;
		cantidadtipoDos -= 4;
		capacidadBodega += 90;

		mutex.release();

		volumenDisponible.release(90);

		System.out.println("Se generó un paquete !");

		darEstadoActual();

	}

	private void darEstadoActual() {

		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("La Bodega Tiene:");
		System.out.println("Cantidad Articulos Tipo Uno: " + cantidadTipoUno);
		System.out.println("Cantidad Articulos Tipo Dos: " + cantidadtipoDos);

		System.out.println("Volumen Ocupado:" + (CAPACIDAD_MAXIMA - capacidadBodega));
		
		System.out.println("");
	}
}
