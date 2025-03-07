package servicios;

import dtos.UsuarioDto;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;

/**
 * Servicio para actualizar un usuario a través de la API.
 */
public class ActualizarServicio {

    private static final String API_URL = "http://localhost:9080/api/usuarios/modificar/";
    private final Gson gson = new Gson();

    /**
     * Actualiza un usuario en la API.
     * @param usuario el usuario a actualizar.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarUsuario(UsuarioDto usuario) {
        try {
            URL url = new URL(API_URL + usuario.getId());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = gson.toJson(usuario);
            System.out.println("JSON enviado: " + jsonInputString); // Depuración

            try (var os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("Código de respuesta: " + responseCode); // Depuración

            return responseCode == 200; // La API devuelve 200 si la actualización fue exitosa
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
