package servicios;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Servicio para eliminar un usuario a través de la API.
 */
public class EliminarServicio {

    private static final String API_URL = "http://localhost:9080/api/usuarios/eliminar/";

    /**
     * Elimina un usuario de la API.
     * @param id el ID del usuario a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminarUsuario(Long id) {
        try {
            URL url = new URL(API_URL + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");

            int responseCode = conn.getResponseCode();
            return responseCode == 200; // La API devuelve 200 si la eliminación fue exitosa
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
