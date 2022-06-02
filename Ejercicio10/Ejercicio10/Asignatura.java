package Ejercicio10;

import java.io.Serializable;

public class Asignatura implements Serializable{
	private String nombre;
	private double nota;
	Asignatura(String nombre,double nota){
		this.nombre=nombre;
		this.nota=nota;
	}
	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", nota=" + nota + "]";
	}

}
