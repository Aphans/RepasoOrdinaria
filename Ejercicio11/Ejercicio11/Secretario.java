package Ejercicio11;

public class Secretario extends Empleado {
	private String despacho;
	private int numeroFax;
	public Secretario(String nombre, String apellidos, String dNI, String direcci�n, int a�osAntiguedad, int telefono,
			double salario) {
		super(nombre, apellidos, dNI, direcci�n, a�osAntiguedad, telefono, salario);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void incrementarSalario(double salario) {
		setSalario(((getSalario()+salario)/100)*5);

	}
	@Override
	public String toString() {
		return "Secretario"+super.toString();
	}

}
