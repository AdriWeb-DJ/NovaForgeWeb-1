package servicios;

import dtos.UsuarioDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class UsuarioServicio {

    private static final String API_URL = "http://localhost:9080/api/usuarios";

    public List<UsuarioDto> obtenerTodosLosUsuarios() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Error: Código de respuesta HTTP " + conn.getResponseCode());
            }

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            Gson gson = new Gson();
            List<UsuarioDto> usuarios = gson.fromJson(reader, new TypeToken<List<UsuarioDto>>(){}.getType());

            conn.disconnect();
            return usuarios;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los usuarios", e);
        }
    }
}