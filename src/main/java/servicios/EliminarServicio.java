package servicios;

import java.net.HttpURLConnection;
import java.net.URL;

public class EliminarServicio {

    private static final String API_URL = "http://localhost:9080/api/usuarios/eliminar/";

    public boolean eliminarUsuario(Long id) {
        try {
            URL url = new URL(API_URL + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");

            int responseCode = conn.getResponseCode();
            return responseCode == 200; // Asumiendo que la API devuelve 200 si la eliminación fue exitosa
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}