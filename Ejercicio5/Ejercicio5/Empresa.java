package Ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa {
	Scanner sc = new Scanner(System.in);
	List <Empleado> empleados = new ArrayList<Empleado>();
	public Empresa() {
	}
	public int cantidadEmpleados() {
		return empleados.size();
	}
	public void añadirEmpleado() {
		System.out.println("Indique el nombre");
		String nombre = sc.next();
		System.out.println("Indique el año de incorporación");
		int año = sc.nextInt();
		Empleado empleado = new Empleado(nombre,año);
		empleado.asignarDepartamento();
		empleado.asignarOficio();
		empleados.add(empleado);
	}
	public void borrarEmpleado(Empleado emp) {
		empleados.remove(emp);
	}
	public void mostrarEmpleadosPorOficio(Oficio oficio) {
		List <Empleado> empleadosOficio = new ArrayList <Empleado>();
		for (int i = 0; i < empleados.size(); i++) {
			if(empleados.get(i).getOficio().equals(oficio)) {
				empleadosOficio.add(empleados.get(i));
				System.out.println(empleadosOficio);}
		}
	
	}
}
