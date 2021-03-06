package Ejercicio4;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Scanner;

public class Libro implements Serializable {
	private String titulo,tipo;
	private double precio;
	private static final long serialVersionUID = 4L; //Si no al ejecutar cada vez se deserializa el objeto y se crea una deserialización distitna
	Libro(String titulo,String tipo,double precio){
		this.titulo=titulo;
		this.tipo=tipo;
		this.precio=precio;
	}
	public Libro() {
		// TODO Auto-generated constructor stub
	}
	public String getTipo() {
		return tipo;
	}
	public void convertir() {
		File file = new File("datos.txt");
		File filePsicología = new File("librosPsicologia.obj");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String linea;
			while((linea=br.readLine())!=null) {
				String lineado[] = linea.split("#");
				String titulo = lineado[0];
				String tipo = lineado[1];
				Double precio = Double.valueOf(lineado[2]);
				Libro libro = new Libro(titulo,tipo,precio);
				if(!filePsicología.exists()) {
					ObjectOutputStream objecoutput = new ObjectOutputStream(new FileOutputStream(filePsicología));
					objecoutput.writeObject(libro);
					objecoutput.close();
					
				}
				else {
					MiObjeto miobjeto = new MiObjeto(new FileOutputStream(filePsicología,true));
					miobjeto.writeObject(libro);
					miobjeto.close();
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	public void leerDatos() throws FileNotFoundException, IOException {
		File filePsicología = new File("librosPsicologia.obj");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePsicología));
		try {
			Libro libro;
			while((libro = (Libro) ois.readObject())!=null) {
				System.out.println(libro);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(EOFException e) {
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		ois.close();
		}
	
	@SuppressWarnings("resource")
	public void añadirLibro() throws FileNotFoundException, IOException {
		File filePsicología = new File("librosPsicologia.obj");
		MiObjeto miobjeto = new MiObjeto(new FileOutputStream(filePsicología,true));
		Scanner sc = new Scanner(System.in);
		Libro libro = null;
		try {
			System.out.println("Desea añadir un libro?S/N");
			String opcion = sc.next();
			opcion.toUpperCase();
			if(opcion.equals("S")) {
				System.out.println("Indique el titulo del libro");
				String titulo = sc.next();
				System.out.println("indique el tipo del libro");
				String tipo = sc.next();
				System.out.println("Indique el precio del libro");
				double precio = sc.nextDouble();
				libro = new Libro(titulo,tipo,precio);
				miobjeto.writeObject(libro);
				System.out.println("El contenido del fichero es:");
				libro.leerDatos();
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		miobjeto.close();
		}

	public void borrarLibros() throws FileNotFoundException, IOException, ClassNotFoundException {
		File filePsicología = new File("librosPsicologia.obj");
		File filesoloPsicología = new File("librossoloPsicologia.obj");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePsicología));
		ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(filesoloPsicología));
		try {
		Libro libro;
		int contadorEliminados=0;
		while((libro = (Libro) ois.readObject())!=null){
			if(libro.getTipo().equals("psychology")) {
				ous.writeObject(libro);
			}
			else {
				contadorEliminados++;
			}
		}
		if(contadorEliminados==0){
			System.out.println("No se ha eliminado ningún objeto");
		}
		else {
			System.out.println("Se han eliminado:"+contadorEliminados);
		}
		}
		catch (EOFException exc) {
		}
			ois.close();
			ous.close();
		Files.delete(filePsicología.toPath());
		filesoloPsicología.renameTo(filePsicología);
		
	}
	@Override
	public String toString() {
		return "titulo=" + titulo + ", tipo=" + tipo + ", precio=" + precio + "";
	}
}
