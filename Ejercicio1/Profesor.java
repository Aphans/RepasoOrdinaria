import java.io.Serializable;

public class Profesor implements Serializable{
	private String dni,nombre,nombreDepartamento;
	private Profesor jefe;
	Profesor(String dni,String nombre,String nombreDepartamento){
		this.dni=dni;
		this.nombre=nombre;
		this.nombreDepartamento=nombreDepartamento;
	}
	public String getDni() {
		return dni;
	}
	public Profesor getJefe() {
		return jefe;
	}

	public void setJefe(Profesor t1) {
		this.jefe = t1;
	}
	@Override
	public String toString() {
		return "dni=" + dni + ", nombre=" + nombre + ", nombreDepartamento=" + nombreDepartamento + "]";
	}
	
}
