package Ejercicio8;

public class ReparacionMecanica extends Reparacion {
	@Override
	double calcularPrecio() {
		if(!isFinalizado())  
			return setPrecioFinal(getParteFija()+getPrecioMaterial()*1.1);
		return 0;
		
	}
	@Override
	public String toString() {
		return "ReparacionMecanica "+super.toString();
	}


}
