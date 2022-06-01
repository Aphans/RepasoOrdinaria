package Ejercicio4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Libro libro = new Libro();
		boolean salir = false;
		while(!salir) {
		System.out.println("1.Convertir"+"\n"+
				"2.Leer datos"+"\n"+
				"3.Añadir Libro"+"\n"+
				"4.Borrar libros que no sean de psychology"+"\n"+
				"5.Salir");
		int opcion = sc.nextInt();
		switch(opcion) {
		case 1:
			libro.convertir();
			break;
		case 2:
			try {
				libro.leerDatos();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 3:
			try {
				libro.añadirLibro();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			break;
		case 4:
			try {
				libro.borrarLibros();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			salir = true;
			break;
		}
	}
	}

}
