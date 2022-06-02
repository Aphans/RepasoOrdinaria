package Ejercicio11;

public abstract class Empleado {
	private String nombre,apellidos,DNI,dirección;
	private int añosAntiguedad,telefono;
	private double salario;
	private Empleado supervisor;
	public Empleado(String nombre, String apellidos, String dNI, String dirección, int añosAntiguedad, int telefono,
			double salario) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
		this.dirección = dirección;
		this.añosAntiguedad = añosAntiguedad;
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
		return "nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + ", dirección=" + dirección
				+ ", añosAntiguedad=" + añosAntiguedad + ", telefono=" + telefono + ", salario=" + salario+"\n"
				+ "supervisor=" + "\n"+
				supervisor + "";
	}
	

}
