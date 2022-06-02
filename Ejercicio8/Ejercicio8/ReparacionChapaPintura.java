package Ejercicio8;

public class ReparacionChapaPintura extends Reparacion {
	@Override
	double calcularPrecio() {
		// TODO Auto-generated method stub
		return setPrecioFinal(getParteFija()+getPrecioMaterial()*1.3);
	}
	@Override
	public String toString() {
		return "ReparacionChapaPintura "+super.toString();
	}

}
