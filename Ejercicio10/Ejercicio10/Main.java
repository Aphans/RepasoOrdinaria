package Ejercicio10;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Ejercicio10 e = new Ejercicio10();
		try {
			e.pedirNotas();
			e.leerFichero();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
