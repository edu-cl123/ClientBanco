package com.ProyectoBank.ClienteBank;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modeloPaqueteEnvio.PaqueteEnv;
import modelos.Admin;
import modelos.Cuenta;
import modelos.Usuario;

public class LoginAdminController {
	
	@FXML
	private TextField txIdCard;
	@FXML
	private TextField txPin;

	@FXML
	protected void initialize() {

	}

	@FXML
	public void enviarAdmin() {
		
		Admin a =new Admin(Integer.parseInt(txIdCard.getText()),Integer.parseInt(txPin.getText()));
		
		PaqueteEnv p=new PaqueteEnv(1,new Usuario(),new Cuenta(),a,false);
		System.out.println("Cambios");
		try {
			ConexionSocket.Connection.sendDataToServer(p);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
