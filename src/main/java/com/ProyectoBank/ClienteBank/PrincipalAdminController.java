package com.ProyectoBank.ClienteBank;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modeloPaqueteEnvio.PaqueteEnv;

public class PrincipalAdminController {
	
	@FXML
	private Label lNombre;
	

	@FXML
	protected void initialize() {
		
	}
	
	@FXML
	private void Obtenertodos() {
		PaqueteEnv paquete =new PaqueteEnv(9,ModeloController.usuario,ModeloController.cuenta,false);
		try {
			ConexionSocket.Connection.sendDataToServer(paquete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void ObtenerCuentas() {
		PaqueteEnv paquete =new PaqueteEnv(10,ModeloController.usuario,ModeloController.cuenta,false);
		try {
			ConexionSocket.Connection.sendDataToServer(paquete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
