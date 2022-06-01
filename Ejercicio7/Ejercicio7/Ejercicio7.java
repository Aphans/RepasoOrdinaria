package Ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero = 0;
		File file = new File("datos.dat");	
		BufferedWriter bw =null;
		try {
		 bw = new BufferedWriter(new FileWriter(file));
		System.out.println("Escribe números");
		do {
			numero = sc.nextInt();
			if(numero!=-1)
			bw.write(String.valueOf(numero));
			bw.newLine();
		}while(numero!=-1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			finally {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String linea;
			while((linea=br.readLine())!=null) {
				System.out.println((linea));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

