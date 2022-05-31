
public class Jefe extends Profesor {

	Jefe(String dni, String nombre, String nombreDepartamento) {
		super(dni, nombre, nombreDepartamento);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Jefe "+super.toString();
	}

}
