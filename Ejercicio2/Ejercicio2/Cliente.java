package Ejercicio2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Cliente {
	private String dni;
	private static HashMap <String,Integer> productos = new HashMap<String,Integer>();
	Cliente(String dni){
		this.dni=dni;
	}
	public void comprar() {
		try {
			File file = new File("productos.txt");
			  Scanner scanner = new Scanner(file);
			    while(scanner.hasNext()){
			        String linea = scanner.nextLine();
			        String lineas [] = linea.split(" ");
			        String producto= lineas[0];
			        String cantidad = lineas[1];
			        Integer cantidadProducto=0;
			         cantidadProducto = cantidadProducto+Integer.valueOf(cantidad);
			        productos.put(producto,cantidadProducto);
			    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public  void añadirProducto(String producto,int cantidad) {
		File file = new File("productos.txt");
		BufferedWriter br = null ;
		try {
			 br = new BufferedWriter(new FileWriter(file,true));
			try {
				if(cantidad<=0) return;
				br.newLine();
				br.write(producto);
				br.write(" ");
				br.write(String.valueOf(cantidad));
				productos.put(producto, cantidad);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void eliminarProducto() {
		File file = new File("productos.txt");
		Scanner sc = new Scanner(System.in);
		String opcion;
		System.out.println("¿Desea eliminar un producto?S/N?");
		opcion = sc.next();
		opcion.toUpperCase();
		if(opcion.equals("N") | !opcion.equals("S"))return;
		if(opcion.equals("S")) {
			System.out.println("Indique el producto a eliminar");
			String producto = sc.next();
			System.out.println("Indica la cantidad del producto a eliminar");
			int cantidadEliminar = sc.nextInt();
			Integer cantidad = 0;
			if(cantidad==0)productos.remove(producto);
			String productos0 = null;
			for (Entry<String, Integer> entry : productos.entrySet()) {
				 if(producto.equals(entry.getKey())) {
				 cantidad = entry.getValue();
				cantidad-=cantidadEliminar;
				productos.put(producto, cantidad);
				try {
					Scanner scanner = new Scanner(file);
					String linea = scanner.next();
					String lineas[] = linea.split(" ");
					productos0= lineas[0];
					String cantidades = lineas[1];
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
						if(productos0.equals(producto)) {
							int canti = Integer.valueOf(cantidades);
							canti-=cantidadEliminar;
							bw.write(canti);
							if(canti==0) {
								bw.write(" ");
							}
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 }
			}
		}
			
		
	}
	public void mostrarProductos() {
		for (String key: productos.keySet()){  
			System.out.println(key+ " = " + productos.get(key));
		} 
	}
}
	


