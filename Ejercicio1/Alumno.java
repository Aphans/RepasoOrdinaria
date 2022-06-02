
public class Alumno {
	private String dni,nombre;
	public String getDni() {
		return dni;
	}
	public Alumno(String dni, String nombre) {
		if(!validarDNI(dni));
		this.dni = dni;
		this.nombre = nombre;
	}
	public static boolean validarDNI(String dni) {
		if(dni.matches("[0-9]{8}[A-Z]")) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + "]";
	}
}
