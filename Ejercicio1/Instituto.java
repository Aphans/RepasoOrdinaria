
public class Instituto {
	private static double gastosTotales;
	Profesor [] profesores=new Profesor[10];
	Instituto() {
		gastosTotales=0;
	}
	public boolean altaProfesor(Profesor p) {
		for (int i = 0; i < profesores.length;) {
			if(profesores[i]==null)
				profesores[i] = p;
			return true;
		}
		return false;
	}
	public boolean bajaProfesor(String dni) {
		for (int i = 0; i < profesores.length; ) {
			if(profesores[i].getDni().equals(dni))
				profesores[i]=null;
			return true;
		}
		return false;
	}
	public void asignarJefe(String dni,Profesor jefe) {
		if(jefe instanceof Jefe) {
			for (int i = 0; i < profesores.length; i++) {
				if(profesores[i].getDni().equals(dni))
					profesores[i].setJefe((Jefe)jefe);
			}
		}
		System.out.println("Debe pasar un profesor que sea jefe");
	}
	public void mostrarJefe(String dni) {
		for (int i = 0; i < profesores.length; i++) {
			if(profesores[i].getDni().equals(dni))
				if(!profesores[i].getDni().equals(null)) {
				profesores[i].getJefe();
				}
				System.out.println("El profesor no tiene jefe asignado");
		}
	}
	public void mostrarInstituto() {
		for (int i = 0; i < profesores.length; i++) {
			if(profesores[i] instanceof ProfesorSecundaria)
			    profesores[i].toString();
				((ProfesorSecundaria) profesores[i]).mostrarAlumnos();
		}
	}
	public double gastosInstituto() {
		for (int i = 0; i < profesores.length;) {
			if(profesores[i] instanceof ProfesorSecundaria) {
				gastosTotales+=((ProfesorSecundaria) profesores[i]).calcularSalario();
			}
			else {
				gastosTotales+= ((ProfesorTecnico) profesores[i]).calcularSalario();
			}
			return gastosTotales;
			
		}
		return 0;
	}
	public void añadirAlumnos(String dni,Alumno a) throws InvalidoExcepcion {
		for (int i = 0; i < profesores.length; i++) {
			if(profesores[i].getDni().equals(dni)) {
				if(profesores[i] instanceof ProfesorSecundaria) {
					((ProfesorSecundaria) profesores[i]).altaAlumno(a);
				}
			}
			else {
				throw new InvalidoExcepcion("El dni del profesor no ha sido encontrado");
			}
		}
	}

}
