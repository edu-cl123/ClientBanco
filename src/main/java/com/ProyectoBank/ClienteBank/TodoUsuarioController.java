package com.ProyectoBank.ClienteBank;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelos.Transaccion;
import modelos.Usuario;

public class TodoUsuarioController {
	
	@FXML
	TableView<Usuario> TvUsuarios;
	
	@FXML
	TableColumn<Usuario, String> tcId;
	
	@FXML
	TableColumn<Usuario, String> TcNombre;
	@FXML
	TableColumn<Usuario, String> TcDni;

	@FXML
	protected void initialize() {
		System.out.println("Estos son los usuariossss ");
		System.out.println(ModeloController.todos );
		configurarTabla();

	}

	public void configurarTabla() {
		tcId.setCellValueFactory(usuario->
			new SimpleStringProperty((usuario.getValue().getId_card()))
		);

		TcNombre.setCellValueFactory(usuario->
		new SimpleStringProperty(usuario.getValue().getNombre())
	);
		
		TcDni.setCellValueFactory(usuario->
		new SimpleStringProperty(usuario.getValue().getDNI())
	);
		
		TvUsuarios.setItems(FXCollections.observableArrayList(ModeloController.todos));
	}
	

}
