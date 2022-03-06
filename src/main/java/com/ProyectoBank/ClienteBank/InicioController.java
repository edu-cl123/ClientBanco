package com.ProyectoBank.ClienteBank;

import java.io.IOException;

import ConexionSocket.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioController {
	@FXML
	Button Bclient;
	
	@FXML
	protected void initialize() {
		Connection.connectToServer();
	}
	
	@FXML
    private void Login() {   	
    	try {
    		//App.closeScene((Stage) Bclient.getScene().getWindow());
			App.loadScene(new Stage(), "Login", "Login de la app");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@FXML
    private void LoginAdmin() {   	
    	try {
    		//App.closeScene((Stage) Bclient.getScene().getWindow());
			App.loadScene(new Stage(), "LoginAdmin", "Login de la app");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
