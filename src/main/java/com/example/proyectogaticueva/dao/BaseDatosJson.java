package com.example.proyectogaticueva.dao;

import com.example.proyectogaticueva.domain.DatosGenerales;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseDatosJson {

    private static final String FILE_PATH = "data.json";
    private static final ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    public static DatosGenerales cargarDatos() {
        try (InputStream inputStream = Files.newInputStream(Paths.get(FILE_PATH))) {
            return mapper.readValue(inputStream, DatosGenerales.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new DatosGenerales(); // si no hay archivo o está mal, retorna objeto vacío
        }
    }

    public static boolean guardarDatos(DatosGenerales datos) {
        try (OutputStream outputStream = Files.newOutputStream(Paths.get(FILE_PATH))) {
            mapper.writerWithDefaultPrettyPrinter().writeValue(outputStream, datos);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
