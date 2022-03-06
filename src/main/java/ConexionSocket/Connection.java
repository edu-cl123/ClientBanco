package ConexionSocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import com.ProyectoBank.ClienteBank.App;
import com.ProyectoBank.ClienteBank.ModeloController;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;
import modeloPaqueteEnvio.PaqueteEnv;
import modelos.Admin;
import modelos.Cuenta;
import modelos.Usuario;

public class Connection {

	private static Socket server;

	public static void connectToServer() {
		try {
			server = new Socket("localhost", 1995);
			readServerInputs(server);
		} catch (IOException e) {
			System.out.println("Error, Conexión rechazada, Revise que el servidor está online");
		}
	}

	public static void readServerInputs(Socket server2) {
		new Thread(() -> {
			System.out.println("Cliente");
			try {
				while (true) {
					listenToServerActions(server2);
				}

			} catch (IOException e) {
				e.printStackTrace();
				closeServer(server2, true);
			}

		}).start();

	}
   

	private static void listenToServerActions(Socket server2) throws SocketException {
		try {
			ObjectInputStream dataInputStream = new ObjectInputStream(server2.getInputStream());
			Object o = dataInputStream.readObject();
			PaqueteEnv objeto = (PaqueteEnv) o;
			System.out.println(objeto);
			System.out.println("pasa");

			Usuario nuevoUsuario;
			Cuenta nuevaCuenta;
			Admin administrador;
			switch (objeto.getOpcion()) {

			case 1:
				if (objeto.isComprobante()) {
					administrador = (Admin) objeto.getObjeto3();
					ModeloController.admin = administrador;

					Platform.runLater(() -> {
						try {
							
							App.loadScene(new Stage(), "MenuPrincipalAdmin", "Login de la app");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
				}

				break;
			case 3:
				if (objeto.isComprobante()) {
					nuevoUsuario = (Usuario) objeto.getObjeto1();
					ModeloController.usuario = nuevoUsuario;
					nuevaCuenta = (Cuenta) objeto.getObjeto2();
					System.out.println(nuevaCuenta);
					ModeloController.cuenta = nuevaCuenta;

					Platform.runLater(() -> {
						try { 
							App.loadScene(new Stage(), "VentanaPrincipal", "Login de la app");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
				}
				break;

			case 4:
				if (objeto.isComprobante()) {
					nuevoUsuario = (Usuario) objeto.getObjeto1();
					nuevaCuenta = (Cuenta) objeto.getObjeto2();

					ModeloController.usuario = nuevoUsuario;
					ModeloController.cuenta = nuevaCuenta;
					
					Platform.runLater(() -> {
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setHeaderText(null);
						alert.setTitle("Acessos");
						alert.setContentText("Tu ID-Card de acceso es: "
								+ModeloController.usuario.getId_card()) ;
						alert.showAndWait();

					});


				}

			case 6:
				if (objeto.isComprobante()) {
					nuevaCuenta = (Cuenta) objeto.getObjeto1();
					ModeloController.cuenta = nuevaCuenta;

					Platform.runLater(() -> {
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setHeaderText(null);
						alert.setTitle("Transaccion");
						alert.setContentText("Transacion correctamente, Tu saldo actual es de : "
								+ ModeloController.cuenta.getSaldo());
						alert.showAndWait();

					});

				}
				break;

			case 7:
				if (objeto.isComprobante()) {
					nuevaCuenta = (Cuenta) objeto.getObjeto1();
					ModeloController.cuenta = nuevaCuenta;

					Platform.runLater(() -> {
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setHeaderText(null);
						alert.setTitle("Transaccion");
						alert.setContentText("Transacion correctamente, Tu saldo actual es de : "
								+ ModeloController.cuenta.getSaldo());
						alert.showAndWait();

					});

				}
				break;

			case 8:
				if (objeto.isComprobante()) {
					nuevaCuenta = (Cuenta) objeto.getObjeto2();
					ModeloController.cuenta = nuevaCuenta;

					Platform.runLater(() -> {
						try {
							App.loadScene(new Stage(), "Historial", "Historial de la app");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					});

				}
				break;
			case 9 :
				
				if (objeto.isComprobante()) {
					ModeloController.todos=objeto.getTodoUsuarios();

					System.out.println(ModeloController.todos);
					
					Platform.runLater(() -> {
						try {
							App.loadScene(new Stage(), "VistaUsuariosAdmin", "Historial de la app");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					});

				}
				break;
				
			case 10 :
				
				if (objeto.isComprobante()) {
					ModeloController.todas=objeto.getTodoCuentas();

					System.out.println("Han llegado las cuentas");
					System.out.println(ModeloController.todas);
					
					Platform.runLater(() -> {
						try {
							App.loadScene(new Stage(), "VistaCuentasAdmin", "Historial de la app");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					});

				}
				
				break;	
			}
		} catch (IOException | ClassNotFoundException e) {
			if (e instanceof EOFException) {
				throw new SocketException(e.getMessage());
			} else if (e instanceof ClassNotFoundException) {
				throw new SocketException("Clase no encontrada");
			} else {
				e.printStackTrace();
			}
		}
	}

	public static Socket getConnectionToServer() {
		return server;
	}

	public static void sendDataToServer(Object o) throws IOException {
		if (server != null && !server.isClosed()) {
			ObjectOutputStream objectOutputStream = null;
			try {
				objectOutputStream = new ObjectOutputStream(server.getOutputStream());
				objectOutputStream.writeObject(o);
			} catch (EOFException e) {
				e.printStackTrace();
				if (objectOutputStream != null)
					objectOutputStream.close();
				throw new SocketException("El servidor me ha desconectado");
			}
		}
	}

	private static void closeServer(Socket server, boolean isFromException) {
		try {
			server.getOutputStream().close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
