package Ejercicio3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOuputStream extends ObjectOutputStream{

	public MiObjectOuputStream() throws IOException, SecurityException {
		super();
		// TODO Auto-generated constructor stub
	}
	public MiObjectOuputStream(OutputStream out) throws IOException{
		super(out);
	}
	protected void writeStreamHeader() throws IOException{
		
	}

}
