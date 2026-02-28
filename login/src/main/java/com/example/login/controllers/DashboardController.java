package com.example.login.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label lblBienvenida;

    public void setDatos(String usuario, String correo) {
        lblBienvenida.setText("Bienvenid@, " + usuario + " (" + correo + ")");
    }
}