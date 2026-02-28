package com.example.login.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblMensaje;

    @FXML
    private void onLogin() throws IOException {

        String usuario = txtUsuario.getText().trim();
        String correo = txtCorreo.getText().trim();
        String password = txtPassword.getText().trim();

        List<String> errores = new ArrayList<>();

        if (usuario.isEmpty()) {
            errores.add("El usuario no puede estar vacio");
        }

        if (usuario.length() < 4) {
            errores.add("El usuario debe tener minimo 4 caracteres");
        }

        if (!correo.contains("@") || !correo.contains(".")) {
            errores.add("Correo invalido, el correo debe contener @ y .");
        }

        if (password.length() < 6) {
            errores.add("La contraseña debe tener minimo 6 caracteres");
        }

        if (!errores.isEmpty()) {

            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText(String.join("\n", errores));

        } else {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/login/views/dashboard-view.fxml")
            );

            Scene scene = new Scene(loader.load());

            DashboardController controller = loader.getController();
            controller.setDatos(usuario, correo);

            Stage stage = (Stage) txtUsuario.getScene().getWindow();
            stage.setScene(scene);
        }
    }
}