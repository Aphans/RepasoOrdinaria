import java.io.Serializable;

public class ProfesorTecnico extends Profesor implements Serializable{
	private int numeroHoras;
	ProfesorTecnico(String dni, String nombre, String nombreDepartamento) {
		super(dni, nombre, nombreDepartamento);
	}
	public void asignarHoras(int numeroHoras) {
		this.numeroHoras+=numeroHoras;
	}
	public double calcularSalario() {
		return numeroHoras*20;
	}
	@Override
	public String toString() {
		return "ProfesorTecnico "+super.toString()+"numeroHoras=" + numeroHoras;
	}

}
