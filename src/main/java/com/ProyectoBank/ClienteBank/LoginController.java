package com.ProyectoBank.ClienteBank;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modeloPaqueteEnvio.PaqueteEnv;
import modelos.Admin;
import modelos.Usuario;

public class LoginController {
	@FXML
	private TextField txIdCard;
	@FXML
	private TextField txPin;

	@FXML
	protected void initialize() {

	}

	@FXML
	public void enviarUsario() {

		
		Usuario a = new Usuario(txIdCard.getText(), "", Integer.parseInt(txPin.getText()), "", ModeloController.admin);
		PaqueteEnv p=new PaqueteEnv(3,a,false);
		System.out.println("Cambios");
		try {
			ConexionSocket.Connection.sendDataToServer(p);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void Registro() {
		try {
			App.loadScene(new Stage(), "SignUp", "Registro de la app");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
