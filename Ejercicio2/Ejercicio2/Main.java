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
		System.out.println("�Desea a�adir un producto?S/N");
		opcion = sc.next();
		opcion.toUpperCase();
		if(opcion.equals("N") | !opcion.equals("S"))cliente.eliminarProducto();
		while(opcion.equals("S")) {
			opcion.toUpperCase();
			System.out.println("Elija el nombre del producto a a�adir");
			producto = sc.next();
			System.out.println("Elija la cantidad del producto a a�adir");
			cantidad = sc.nextInt();
			cliente.a�adirProducto(producto, cantidad);
			System.out.println("�Desea a�adir un producto?S/N");
			opcion = sc.next();
			opcion.toUpperCase();
		}
		cliente.sacarTicket();
		
	}

}
