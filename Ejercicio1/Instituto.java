
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
			for (int i = 0; i < profesores.length; i++) {
				if(profesores[i].getDni().equals(dni)) {
					profesores[i].setJefe(jefe);
					return;
				}
			
			}
	}
	public String mostrarJefe(String dni) {
		for (int i = 0; i < profesores.length;) {
			if(profesores[i].getDni().equals(dni)) {
				return "Jefe del profesor:"+ profesores[i].getJefe().toString();
				}
			}
			System.out.println("El profesor no tiene jefe asignado");
			return null;
		
	}
	
	public void mostrarInstituto() {
		for (int i = 0; i < profesores.length;) {
			if(profesores[i] instanceof ProfesorSecundaria)
				if(profesores[i]!=null) {
			    System.out.println(profesores[i]);
				System.out.println("Alumnos:");
				((ProfesorSecundaria) profesores[i]).mostrarAlumnos();
				return;
				}
				else {
					return;
				}
				
				
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
