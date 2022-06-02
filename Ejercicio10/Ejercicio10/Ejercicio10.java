package Ejercicio10;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio10{
	Scanner sc = new Scanner(System.in);
	private static int contador=0;
	public void pedirNotas() throws IOException {
		File file = new File("notas.obj");
		ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
		double media = 0;
		while(contador<=6) {
			System.out.println("Escribe el nombre de la asignatura");
			String nombre = sc.next();
			System.out.println("Escribe la nota del alumno");
			double nota = sc.nextDouble();
			media=+nota;
			Asignatura asig = new Asignatura(nombre,nota);
			ous.writeObject(asig);
			contador++;
		}
		ous.writeBytes("La nota media es:"+String.valueOf(media/6));
		ous.close();
	}
	public void leerFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			File file = new File("notas.obj");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			Asignatura asig;
			while((asig = (Asignatura) ois.readObject())!=null) {
				System.out.println(asig);
			}
			System.out.println(ois.readByte());
			ois.close();
		}
		catch(EOFException e) {

		}

	}
}