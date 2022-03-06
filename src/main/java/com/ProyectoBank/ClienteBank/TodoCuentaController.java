package com.ProyectoBank.ClienteBank;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelos.Cuenta;
import modelos.Usuario;

public class TodoCuentaController {	
		
		@FXML
		TableView<Cuenta> TvCuentas;
		
		@FXML
		TableColumn<Cuenta, String> tcId;
		
		@FXML
		TableColumn<Cuenta, String> TcSaldo;
		@FXML
		TableColumn<Cuenta, String> TcIdCardCuenta;

		@FXML
		protected void initialize() {
			System.out.println("Estos son las Cuentas ");
			System.out.println(ModeloController.todos );
			configurarTabla();

		}

		public void configurarTabla() {
			tcId.setCellValueFactory(cuenta->
				new SimpleStringProperty((cuenta.getValue().getId()+""))
			);

			TcSaldo.setCellValueFactory(usuario->
			new SimpleStringProperty(usuario.getValue().getSaldo()+"")
		);
			
			TcIdCardCuenta.setCellValueFactory(usuario->
			new SimpleStringProperty(usuario.getValue().getId_usuario().getId_card())
		);
			
			TvCuentas.setItems(FXCollections.observableArrayList(ModeloController.todas));
		}
		

}
