package servicios;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;
import dtos.UsuarioDto;

public class RegistroServicio {

    private static final String API_URL = "http://localhost:9080/api/usuarios/crear";
    private final HttpClient httpClient;
    private final Gson gson;

    public RegistroServicio() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public boolean registrarUsuario(UsuarioDto usuario) {
        try {
            // Convertir el objeto UsuarioDto a JSON
            String jsonBody = gson.toJson(usuario);

            // Construir la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar si la respuesta HTTP es 201 (para verificar que se ha creado)
            return response.statusCode() == 201;

        } catch (Exception e) {
            System.out.println("Error en el registro: " + e.getMessage());
            return false;
        }
    }
}
