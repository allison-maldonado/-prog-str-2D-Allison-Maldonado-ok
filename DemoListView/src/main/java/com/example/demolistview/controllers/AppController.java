package com.example.demolistview.controllers;
import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class AppController {
    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtBusqueda;
    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();
    private PersonService service= new PersonService();

    private void  filtrarLista(String textoBuscar){
        List<String> filtrada= new ArrayList<>();
        for (String lista : data){
            String[] partesDelString = lista.split("-");
            System.out.println(partesDelString[1]);
            if (partesDelString[1].contains(textoBuscar)){
                filtrada.add(lista);
            }
        }
        data.setAll(filtrada);
    }
    @FXML
    public void initialize(){ //se va a ejecutar el inicio, en cuanto se cargue el controller
        //Inicializar ListView
        loadFromFile();

        txtBusqueda.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()){
                filtrarLista(newValue);
            }else {
                loadFromFile();
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            loadDataToForm(newValue);//String con valor del row 0 test-email@gmail.com
        });
        listView.setItems(data);
    }

    @FXML
    public void onAddPerson() {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String ageText = txtAge.getText();
            int age = Integer.parseInt(ageText);

            service.addPerson(name, email, age);
            lblMsg.setText("Persona agregada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
            loadFromFile();
        } catch (NumberFormatException e) {
            lblMsg.setText("La edad debe ser un numero");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red ");
        } catch (IllegalArgumentException ex) {
            lblMsg.setText(ex.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }

    @FXML
    public void onUpdate() {
        int index = listView.getSelectionModel().getSelectedIndex();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String edad = txtAge.getText();
        try {
            service.updatePerson(index, name, email, edad);
            loadFromFile();
            lblMsg.setText("Persona actualizada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red ");
        } catch (IllegalArgumentException ex) {
            lblMsg.setText("Hubo un error con los datos");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public void onDelete(){
        int index = listView.getSelectionModel().getSelectedIndex();
        try {
            service.deletePerson(index);
            loadFromFile();
            lblMsg.setText("Persona eliminada correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
        }catch (IOException e){
            lblMsg.setText("Hubo un error con el archivo en eliminar");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile() {
        try {
            List<String> items = service.loadDataforList();
            data.setAll(items);
            lblMsg.setText("Datos cargados exitosamente ");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }

    private void loadDataToForm(String item) {
        if (item == null || item.isBlank()) {
            return;
        }

        String[] parts = item.split(",");

        txtName.setText(parts[0]);
        txtEmail.setText(parts[1]);

        if (parts.length > 2) {
            txtAge.setText(parts[2]);
        }
    }
}
