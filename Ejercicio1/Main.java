import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		/*INSTITUTO*/
		Instituto instituto = new Instituto();
		/*PROFESORES*/
		File file = new File("profesores.txt");
		try {
			String cadena;
			FileReader f = new FileReader("profesores.txt"); 
			BufferedReader b = new BufferedReader(f); 
			FileObjectInput filei = new F();
			String [] dni = null;
			while((cadena = b.readLine())!=null) { 
			   dni = cadena.split(dni[0]);
			   for (int i = 0; i < cadena.length(); i++) {
				  
			}
			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProfesorSecundaria s1= new ProfesorSecundaria("03188833A", "Ángel", "Programación");
		Profesor t1= new Profesor("02338833B", "Raquel", "Ventas");
		ProfesorTecnico s3= new ProfesorTecnico("023383333T", "Alberto", "Limpieza");
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
		//if(correcto) System.out.println("El profesor"+s1.getDni()+"ha sido dado de alta");
		correcto = instituto.altaProfesor(t1);
	//	if(correcto) System.out.println("El profesor"+t1.getDni()+"ha sido dado de alta");
		correcto = instituto.altaProfesor(s3);
	//	if(correcto) System.out.println("El profesor"+s3.getDni()+"ha sido dado de alta");
		/*Mostrar alumnos*/
		System.out.println("Profesor:");
		System.out.println(s1.toString());
		System.out.println("Alumnos:");
		s1.mostrarAlumnos();
		/*Alta profesor*/
		instituto.altaProfesor(s1);
		/*Bajaa profesor*/
		instituto.bajaProfesor("03188833A");
		/*Mostrar instituto*/
		System.out.println("----INSTITUTO----");
		instituto.mostrarInstituto();
		/*Mostrar jefe*/
		instituto.asignarJefe("03188833A", s3);
		System.out.println(instituto.mostrarJefe("03188833A"));
	}
	
}
