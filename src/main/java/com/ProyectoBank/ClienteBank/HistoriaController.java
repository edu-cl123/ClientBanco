package com.ProyectoBank.ClienteBank;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelos.Transaccion;

public class HistoriaController {
	
	@FXML
	TableView<Transaccion> historial;
	
	@FXML
	TableColumn<Transaccion, String> tipo;
	
	@FXML
	TableColumn<Transaccion, String> importe;

	@FXML
	protected void initialize() {
		configurarTabla();

	}

	public void configurarTabla() {
		tipo.setCellValueFactory(intrasaccion->
			new SimpleStringProperty((intrasaccion.getValue().isTipo()?"Ingresar":"Retirar"))
		);

		importe.setCellValueFactory(intrasaccion->
		new SimpleStringProperty(intrasaccion.getValue().getImporte()+" €")
	);
		
		historial.setItems(FXCollections.observableArrayList(ModeloController.cuenta.getLista_Transacciones()));
	}
	

}
