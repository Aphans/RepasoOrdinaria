
public class Alumno {
	private String dni,nombre;
	public Alumno(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + "]";
	}
}
