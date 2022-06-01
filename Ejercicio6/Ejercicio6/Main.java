package Ejercicio6;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
public static void main(String[] args) {
	Vehiculos vehiculo = new Vehiculos();
	try {
		vehiculo.escribirVehiculos();
		vehiculo.escribirotrosVehiculos();
		vehiculo.mostrarVehiculos();
		vehiculo.mostrarVehiculoPorId(7);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
