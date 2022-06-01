package Ejercicio3;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Persona implements Serializable {
	private String dni,nombre;
	private int edad;
	private String dnis[]= {"12345678A","98765432B","78234212Z"};
	private String nombres[]= {"Lucas González","Anacleto Jiménez","María Zapata"};
	private int edades [] = {30,28,35};
	Persona(String dni,String nombre,int edad){
		this.dni=dni;
		this.nombre=nombre;
		this.edad=edad;
	}
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	public void escribirObjetos() throws FileNotFoundException, IOException {
		File file = new File("personas.dat");
		MiObjectOuputStream obj = new MiObjectOuputStream(new FileOutputStream(file,true));//Si el archivo existe
		ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));//Si el archivo no existe
		try {
			//Si el archivo existe usa MiObjectOuputStream
			if(file.exists()) {
				for (int i = 0; i < dnis.length; i++) {
					String dni = dnis[i];
					String nombre = nombres[i];
					int edad = edades[i];
					Persona persona = new Persona(dni,nombre,edad);
					obj.writeObject(persona);
				}
			}
			//Si el archivo no  existe usa ObjectOutputStream
			else {
				for (int i = 0; i < dnis.length; i++) {
					String dni = dnis[i];
					String nombre = nombres[i];
					int edad = edades[i];
					Persona persona = new Persona(dni,nombre,edad);
					ous.writeObject(persona);
			}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//Cerrar para poder leer el archivo 
			obj.close();
			ous.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void leerPersonas() throws FileNotFoundException, IOException {

		Persona persona = null;
		File f = new File("personas.dat");
		FileInputStream fi = new FileInputStream(f);
		ObjectInputStream datos = new ObjectInputStream(fi);

		while (true) {
			try {
				//ReadObject lee objetos de clases génericas,por eso se castea
				persona = (Persona) datos.readObject();
				System.out.println(persona); 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EOFException e) {
				// TODO Auto-generated catch block
			} 
		}
	}

	//ToString para imprimir bien los objetos 
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
}
