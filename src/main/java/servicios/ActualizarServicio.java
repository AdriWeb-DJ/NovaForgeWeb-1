package servicios;

import dtos.UsuarioDto;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;

public class ActualizarServicio {

    private static final String API_URL = "http://localhost:9080/api/usuarios/modificar/";
    private final Gson gson = new Gson();

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

            return responseCode == 200; // Asumiendo que la API devuelve 200 si la actualización fue exitosa
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}