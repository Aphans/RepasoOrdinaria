package Ejercicio11;

public class Main {
	public static void main(String[] args) {
	Secretario secretario = new Secretario("Ángel","Cu","03939333A","C/Hola",2000,604030303,2100);
	Secretario secretario1 = new Secretario("Lu","Po","03939333A","C/Hola",2000,604030303,2100);
	secretario.cambiarSupervisor(secretario1);
	System.out.println(secretario.toString());

}
}
