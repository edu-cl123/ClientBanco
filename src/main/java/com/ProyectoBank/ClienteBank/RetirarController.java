package com.ProyectoBank.ClienteBank;

import java.io.IOException;

import ConexionSocket.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modeloPaqueteEnvio.PaqueteEnv;

public class RetirarController {
	
	@FXML
	private TextField importe;
	
	@FXML
	protected void initialize() {
		
	}
	
	public void ingresar() {
		float f = Float.parseFloat(importe.getText());
		
		//Object o = ModeloController.cuenta;

		PaqueteEnv ingreso=new PaqueteEnv(6, ModeloController.usuario,ModeloController.cuenta,false,f);
		try {
			Connection.sendDataToServer(ingreso);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void retirar() {
		float f = Float.parseFloat(importe.getText());
		
		//Object o = ModeloController.cuenta;

		PaqueteEnv ingreso=new PaqueteEnv(7, ModeloController.usuario,ModeloController.cuenta,false,f);
		try {
			Connection.sendDataToServer(ingreso);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
