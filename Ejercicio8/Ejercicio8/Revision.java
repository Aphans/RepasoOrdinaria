package Ejercicio8;

public class Revision extends Trabajo{
	@Override
	double calcularPrecio() {
		// TODO Auto-generated method stub
		return setPrecioFinal(getParteFija()+20);
	}
	@Override
	public String toString() {
		return "Revision "+super.toString();
	}

}
