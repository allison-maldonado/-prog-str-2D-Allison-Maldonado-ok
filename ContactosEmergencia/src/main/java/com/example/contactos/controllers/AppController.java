package com.example.contactos.controllers;

import com.example.contactos.models.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.List;

public class AppController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cbParentesco;
    @FXML private ListView<Contacto> listView;
    @FXML private Label lblMsg;

    private ObservableList<Contacto> listaContactos = FXCollections.observableArrayList();

    private String[] parentescos = {
            "Padre", "Madre", "Hermano", "Hermana",
            "Abuelo", "Abuela", "Tío", "Tía"
    };

    @FXML
    public void initialize() {
        cbParentesco.getItems().addAll(parentescos);
        listView.setItems(listaContactos);
    }

    @FXML
    public void onAgregar() {

        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String parentesco = cbParentesco.getValue();

        if (nombre == null || nombre.isBlank()) {
            lblMsg.setText("El nombre es obligatorio");
            return;
        }

        if (telefono == null || telefono.isBlank()) {
            lblMsg.setText("El teléfono es obligatorio");
            return;
        }

        if (!telefono.matches("\\d{10}")) {
            lblMsg.setText("El teléfono debe tener 10 dígitos");
            return;
        }

        if (parentesco == null) {
            lblMsg.setText("Selecciona un parentesco");
            return;
        }

        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                lblMsg.setText("Ya existe un contacto con ese nombre");
                return;
            }
        }

        Contacto nuevo = new Contacto(nombre, telefono, parentesco);

        listaContactos.add(nuevo);

        lblMsg.setText("Contacto agregado");

        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
    }

    @FXML
    public void onBuscar() {

        String nombre = txtNombre.getText();

        if (nombre == null || nombre.isBlank()) {
            lblMsg.setText("Escribe un nombre para buscar");
            return;
        }

        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {

                txtNombre.setText(c.getNombre());
                txtTelefono.setText(c.getTelefono());
                cbParentesco.setValue(c.getParentesco());

                lblMsg.setText("Contacto encontrado");
                return;
            }
        }

        lblMsg.setText("No se encontró el contacto");
    }

    @FXML
    public void onActualizar() {

        String nombre = txtNombre.getText();

        if (nombre == null || nombre.isBlank()) {
            lblMsg.setText("Escribe el nombre del contacto");
            return;
        }

        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {

                String telefono = txtTelefono.getText();
                String parentesco = cbParentesco.getValue();

                if (telefono == null || !telefono.matches("\\d{10}")) {
                    lblMsg.setText("Teléfono inválido");
                    return;
                }

                if (parentesco == null) {
                    lblMsg.setText("Selecciona un parentesco");
                    return;
                }

                c.setTelefono(telefono);
                c.setParentesco(parentesco);

                listView.refresh();

                lblMsg.setText("Contacto actualizado");
                return;
            }
        }

        lblMsg.setText("No se encontró el contacto");
    }

    @FXML
    public void onEliminar() {

        String nombre = txtNombre.getText();

        if (nombre == null || nombre.isBlank()) {
            lblMsg.setText("Escribe el nombre del contacto");
            return;
        }

        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {

                listaContactos.remove(c);
                lblMsg.setText("Contacto eliminado");

                txtNombre.clear();
                txtTelefono.clear();
                cbParentesco.setValue(null);

                return;
            }
        }

        lblMsg.setText("No se encontró el contacto");
    }

    @FXML
    public void onLimpiar() {

        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
        lblMsg.setText("");
    }

    private void refrescar() {
        listaContactos.setAll(listaContactos);
    }

    private void limpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
    }

    private boolean validar(String nombre, String telefono, String parentesco) {

        if (nombre == null || nombre.isBlank()) {
            lblMsg.setText("Nombre vacío");
            return false;
        }

        if (telefono == null || telefono.isBlank()) {
            lblMsg.setText("Teléfono vacío");
            return false;
        }

        if (telefono.length() != 10) {
            lblMsg.setText("Debe tener 10 dígitos");
            return false;
        }

        if (parentesco == null) {
            lblMsg.setText("Selecciona parentesco");
            return false;
        }

        return true;
    }
}