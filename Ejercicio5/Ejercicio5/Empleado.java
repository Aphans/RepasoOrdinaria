package Ejercicio5;

import java.util.Scanner;

public class Empleado {
	private int id=0;
	private String nombre;
	private int añoIncorporacion;
	Departamento departamento;
	Oficio oficio;
	Scanner sc = new Scanner(System.in);
	Empleado(String nombre,int añoIncorporacion) {
		this.nombre=nombre;
		this.añoIncorporacion=añoIncorporacion;
		id++;
	}
	public Oficio getOficio() {
		return oficio;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}
	public void asignarDepartamento() {
		System.out.println("Elija un departamento a asignar:"+"\n"+
				"10.VENTAS"+"\n"+
				"20.MARKETING"+"\n"+
				"30.DESARROLLO");
		int opcion = sc.nextInt();
		switch(opcion) {
		case 10:
			departamento = Departamento.VENTAS;
			break;
		case 20:
			departamento = Departamento.MARKETING;
			break;
		case 30:
			departamento = Departamento.DESARROLLO;
			break;
		}
		this.setDepartamento(departamento);
	}

	public void asignarOficio() {
		System.out.println("Elija un oficio a asignar:"+"\n"+
				"1.PROGRAMADOR"+"\n"+
				"2.ANALISTA"+"\n"+
				"30.JEFEPROYECTO");
		int opcion = sc.nextInt();
		switch(opcion) {
		case 1:
			oficio = Oficio.PROGRAMADOR;
			break;
		case 2:
			oficio = Oficio.ANALISTA;
			break;
		case 3:
			oficio = Oficio.JEFEPROYECTO;
			break;
		}
		this.setOficio(oficio);
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", añoIncorporacion=" + añoIncorporacion
				+ ", departamento=" + departamento + ", oficio=" + oficio + "]";
	}


}
