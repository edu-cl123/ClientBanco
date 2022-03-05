package com.ProyectoBank.ClienteBank;

import java.io.IOException;

import ConexionSocket.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modeloPaqueteEnvio.PaqueteEnv;
import modelos.Cuenta;
import modelos.Usuario;

public class RegistroController {
	
	@FXML
	private TextField txDni;
	
	@FXML
	private TextField txPin;
	
	@FXML
	private TextField txFullName;
	
	
	@FXML
	protected void initialize() {

	}
	
	@FXML
	private void Resgistro() {
		
		Usuario usuario =new Usuario("",txFullName.getText(),Integer.parseInt(txPin.getText()),txDni.getText(),ModeloController.admin);
		PaqueteEnv paquete =new PaqueteEnv(4,usuario, new  Cuenta(),false);
		try {
			Connection.sendDataToServer(paquete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
