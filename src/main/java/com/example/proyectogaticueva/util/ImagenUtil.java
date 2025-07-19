package com.example.proyectogaticueva.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class ImagenUtil {

    public static String cargarImagenEnImageView(Stage stage, String numeroDocumento, String carpetaRuta) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.jpg", "*.jpeg", "*.png")
        );

        File archivoSeleccionado = fileChooser.showOpenDialog(stage);
        if (archivoSeleccionado != null) {
            try {
                // Crear carpeta si no existe
                File carpeta = new File(carpetaRuta);
                if (!carpeta.exists()) carpeta.mkdirs();

                // Crear archivo destino con número de documento
                String extension = archivoSeleccionado.getName().substring(archivoSeleccionado.getName().lastIndexOf("."));
                File archivoDestino = new File(carpeta, numeroDocumento + extension);

                // Copiar archivo con java.io
                try (
                        FileInputStream fis = new FileInputStream(archivoSeleccionado);
                        FileOutputStream fos = new FileOutputStream(archivoDestino)
                ) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                    }
                }

                return archivoDestino.getAbsolutePath(); // Devolver ruta para usarla luego
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void cargarImagenGuardada(String rutaImagen, ImageView imageView) {
        try {
            FileInputStream fis = new FileInputStream(new File(rutaImagen));
            Image imagen = new Image(fis);
            imageView.setImage(imagen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
