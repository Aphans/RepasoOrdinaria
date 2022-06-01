package Ejercicio6;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Vehiculos implements Serializable {
	private String matricula;
	private long km;
	private int caballo;
	private int id=0;
	String matriculas[]={"1234-ABC","2345-FGT","7412-RET","5285-NBN","7896-JNB",
			"632-POI","1289-GTR"};
	long kms[]={100000,200000,150000,1200,3000,40000,180000};
	int caballos[]={95,110,150,125,110,150,180};
	public Vehiculos(int id,String matricula, long km, int caballo) {
		this.matricula = matricula;
		this.km = km;
		this.caballo = caballo;
		this.id=id;
	}
	public Vehiculos() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void escribirVehiculos() throws FileNotFoundException, IOException {
		int id=0;
		File file = new File("vehiculos.obj");
		ObjectOutputStream obo = new ObjectOutputStream(new FileOutputStream(file));
		try {
			for (int i = 0; i < caballos.length; i++) {
				String matricula = matriculas[i];
				Long km = kms[i];
				Integer caballo = caballos[i];
				id++;
				Vehiculos vehiculo = new Vehiculos(id,matricula,km,caballo);
				obo.writeObject(vehiculo);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			obo.close();
		}
	}
	public void escribirotrosVehiculos() throws FileNotFoundException, IOException {
		String matricula[]= {"2374-TRE","8521-PER"};
		long km []= {130000,25000};
		int caballos []= {110,120};
		String ma = null;
		long kms = 0;
		int caballo = 0;
		File file = new File("vehiculos.obj");
		MiObjeto obo = new MiObjeto(new FileOutputStream(file,true));
		for (int i = 0; i < caballos.length; i++) {
			ma = matricula[i];
			kms = km[i];
			caballo = caballos[i];
			id=7;
			id++;

		}
		Vehiculos vehiculo = new Vehiculos(id,ma,kms,caballo);
		obo.writeObject(vehiculo);
		obo.close();
	}
	public void mostrarVehiculos() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			File file = new File("vehiculos.obj");
			ObjectInputStream obo = new ObjectInputStream(new FileInputStream(file));
			Vehiculos vehiculo;
			while((vehiculo = (Vehiculos) obo.readObject())!=null) {
				System.out.println(vehiculo);

			}
		}
		catch(EOFException e) {
		}
		finally {

		}
	}

	public void mostrarVehiculoPorId(int id) throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			File file = new File("vehiculos.obj");
			ObjectInputStream obo = new ObjectInputStream(new FileInputStream(file));
			Vehiculos vehiculo;
			while((vehiculo = (Vehiculos) obo.readObject())!=null) {
				if(vehiculo.getId()==id) {
					System.out.println("El vehiculo con:"+id+" es:");
					System.out.println(vehiculo);

				}
			}
		}
		catch(EOFException e) {
		
		}
	}
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", matricula=" + matricula + ", km=" + km + ", caballo=" + caballo + "]";
	}
}
