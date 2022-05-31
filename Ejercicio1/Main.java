
public class Main {
	public static void main(String[] args) {
		/*INSTITUTO*/
		Instituto instituto = new Instituto();
		/*PROFESORES*/
		ProfesorSecundaria s1= new ProfesorSecundaria("Ángel", "03188833A", "Programación");
		Profesor t1= new Profesor("Raquel", "02338833B", "Ventas");
		ProfesorTecnico s3= new ProfesorTecnico("Alberto", "023383333T", "Limpieza");
		s3.setJefe(t1);
		/*ALUMNOS*/
		Alumno alu1 = new Alumno("0002","Pepe");
		Alumno alu2 = new Alumno("003","Luis");
		/*Asignar alumnos a profesores*/
		boolean correcto = false;
		correcto = s1.altaAlumno(alu2);
		if(correcto) {
			System.out.println("La operación ha tenido exito");
		}
		else {
			System.out.println("La operación no ha tenido exito");
		}

		/*Dar de alta profesores al instituto*/
		correcto = instituto.altaProfesor(s1);
		if(correcto) System.out.println("El profesor"+s1.getDni()+"ha sido dado de alta");
		correcto = instituto.altaProfesor(t1);
		if(correcto) System.out.println("El profesor"+t1.getDni()+"ha sido dado de alta");
		correcto = instituto.altaProfesor(s3);
		if(correcto) System.out.println("El profesor"+s3.getDni()+"ha sido dado de alta");
		/*Mostrar alumnos*/
		System.out.println(s1.toString());
		s1.mostrarAlumnos();
		/*Alta profesor*/
		instituto.altaProfesor(s1);
		
		/*Mostrar instituto*/
		System.out.println("----INSTITUTO----");
		instituto.mostrarInstituto();
	}
	
}
