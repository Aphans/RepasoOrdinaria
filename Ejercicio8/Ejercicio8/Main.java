package Ejercicio8;

public class Main {
	public static void main(String[] args) {
		ReparacionMecanica rm = new ReparacionMecanica();
		rm.setDescripcion("Reparar coche");
		rm.calcularPrecio();
		rm.incrementarHoras(30);
		rm.finalizarTrabajo();
       System.out.println(rm.toString());
	}

}
