package Ejercicio8;

public abstract class Reparacion extends Trabajo{
	public Reparacion(int precioMaterial) {
		super();
		this.precioMaterial = precioMaterial;
	}
	private int precioMaterial;
	Reparacion(){
		this.precioMaterial=0;
	}
	public int getPrecioMaterial() {
		return precioMaterial;
	}
	public void usarMaterial(int importe) {
		if(!isFinalizado())
		precioMaterial+=importe;
	}


}
