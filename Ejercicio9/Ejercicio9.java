import java.util.Collections;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Ejercicio9 {
	public static void main(String[] args) {
		TreeMap <String,String> colores = new TreeMap <String,String>();
		colores.put("C1", "Rojo");
		colores.put("C2", "Green");
		colores.put("C4", "White");
		colores.put("C3", "Black");;
		colores.put("C5", "Blue");
		for (Entry<String, String> entry : colores.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			System.out.println("id:"+key+" color:"+val);
		}
		if(colores.containsValue("Rojo"))System.out.println("El valor rojo esta en la lista");
		
	}

}
