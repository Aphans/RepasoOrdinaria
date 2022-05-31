package Ejercicio2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opcion ,producto;
		int cantidad ;
		Cliente cliente = new Cliente("03177381T");
		cliente.comprar();
		cliente.mostrarProductos();
		System.out.println("¿Desea añadir un producto?S/N");
		opcion = sc.next();
		opcion.toUpperCase();
		if(opcion.equals("N") | !opcion.equals("S"))cliente.eliminarProducto();
		while(opcion.equals("S")) {
			opcion.toUpperCase();
			System.out.println("Elija el nombre del producto a añadir");
			producto = sc.next();
			System.out.println("Elija la cantidad del producto a añadir");
			cantidad = sc.nextInt();
			cliente.añadirProducto(producto, cantidad);
			System.out.println("¿Desea añadir un producto?S/N");
			opcion = sc.next();
			opcion.toUpperCase();
		}
		cliente.sacarTicket();
		
	}

}
