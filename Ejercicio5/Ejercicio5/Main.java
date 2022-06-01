package Ejercicio5;

public class Main {
	public static void main(String[] args) {
	Empresa empresa = new Empresa();
	empresa.añadirEmpleado();
	System.out.println(empresa.cantidadEmpleados());
	Oficio oficio = null;
	empresa.mostrarEmpleadosPorOficio(oficio.PROGRAMADOR);
	empresa.cantidadEmpleados();

}
}
