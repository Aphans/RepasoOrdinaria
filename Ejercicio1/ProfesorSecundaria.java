import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProfesorSecundaria extends Profesor implements Serializable{
	private Libro libro;
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	static int contadorAlumnos=0;
	//Profesor secundaria sin asignar libro
	ProfesorSecundaria(String dni,String nombre, String nombreDepartamento) {
		super(dni, nombre,nombreDepartamento);
	}
	//Profesor secundaria con libro
	ProfesorSecundaria(String dni,String nombre,String nombreDepartamento,Libro libro){
		super(dni,nombre,nombreDepartamento);
		this.libro=libro;
	}
	/**
	 * 
	 * @param alumno. Se pasa el alumno que desea añadir a la lista de cada profesor de secundaria
	 * @return
	 */
	public boolean altaAlumno(Alumno alumno) {
		if(Alumno.validarDNI(alumno.getDni())) {
		if(contadorAlumnos<3) {
			alumnos.add(alumno);
			contadorAlumnos++;
			return true;
		}
		}
		return false;
	}
	public void mostrarAlumnos() {
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println(alumnos);
		}
	}
	public double calcularSalario() {
		return alumnos.size()*200;
	}
	@Override
	public String toString() {
		return "ProfesorSecundaria "+super.toString();
	}
}
