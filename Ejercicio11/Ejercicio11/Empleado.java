package Ejercicio11;

public abstract class Empleado {
	private String nombre,apellidos,DNI,direcci�n;
	private int a�osAntiguedad,telefono;
	private double salario;
	private Empleado supervisor;
	public Empleado(String nombre, String apellidos, String dNI, String direcci�n, int a�osAntiguedad, int telefono,
			double salario) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
		this.direcci�n = direcci�n;
		this.a�osAntiguedad = a�osAntiguedad;
		this.telefono = telefono;
		this.salario = salario;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public void cambiarSupervisor(Empleado supervisor) {
		this.supervisor = supervisor;
	}
	public abstract void incrementarSalario(double salario);
	@Override
	public String toString() {
		return "nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + ", direcci�n=" + direcci�n
				+ ", a�osAntiguedad=" + a�osAntiguedad + ", telefono=" + telefono + ", salario=" + salario+"\n"
				+ "supervisor=" + "\n"+
				supervisor + "";
	}
	

}
