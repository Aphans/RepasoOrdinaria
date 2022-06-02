package Ejercicio8;

public abstract class Trabajo {
	private String id;
	private final String empiece="T";
	private static int contador=0;
	private int numeroHoras;
	private String descripcion;
	private boolean finalizado;
	private double parteFija = numeroHoras*30;
	private double precioFinal;
	Trabajo(){
		contador++;
		id=empiece+String.format("%07d", contador);
		numeroHoras=0;
		finalizado=false;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void finalizarTrabajo() {
		finalizado=true;
	}
	public double getParteFija() {
		return parteFija;
	}
	public double setPrecioFinal(double d) {
		return this.precioFinal = d;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void incrementarHoras(int numeroHoras) {
		if(!finalizado) {
			this.numeroHoras+=numeroHoras;
		}
		else {
			System.out.println("No se puede incrementar las horas.El trabajo esta finalizado");
		}
	}
	
	abstract double calcularPrecio();
	@Override
	public String toString() {
		return "id=" + id + ", numeroHoras=" + numeroHoras + ", descripcion=" + descripcion + ", finalizado="
				+ finalizado + "]";
	}

	
}
