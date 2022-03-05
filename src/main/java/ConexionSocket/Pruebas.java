package ConexionSocket;

import java.io.IOException;
import java.net.Socket;

import modelos.Admin;

public class Pruebas {
	
	public static void main(String[] args) {
		Connection.connectToServer();
		Admin a =new Admin(23,24);
		try {
			Connection.sendDataToServer(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	

}
