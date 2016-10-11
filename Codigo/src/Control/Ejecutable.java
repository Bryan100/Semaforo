package Control;

import Modelo.*;

public class Ejecutable {

	private static Operario miOperario;
	private static Empacador miEmpacador;
	private static Bodega miBodega;

	public static void main(String[] args) {

		miBodega = new Bodega();
		miOperario = new Operario(miBodega);
		miEmpacador = new Empacador(miBodega);

		miOperario.start();
		miEmpacador.start();

	}
}
