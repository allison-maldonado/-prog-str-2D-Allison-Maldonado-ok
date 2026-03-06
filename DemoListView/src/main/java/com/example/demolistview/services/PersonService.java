package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataforList() throws IOException {
        List<String> lines = repo.readAllLines();//Recupera las lineas del archivo
        List<String> result = new ArrayList<>();//El listado de resultado con el formato deseado
        for(String line : lines){
            if(line==null || line.isBlank()) continue; //Ignorar las lineas nulas

            String[] parts = line.split("," , -1);
            String name = parts[0].trim();//Obtiene el nombre del arreglo
            String correo = parts[1].trim();//Obtiene el correo del arreglo

            result.add(name+"-"+correo);//Se agrega a la lista de resultado con el formato deseado
        }
        return result;
    }
}
