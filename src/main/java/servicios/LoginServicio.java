package servicios;

import dtos.UsuarioDto;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * Servicio para validar las credenciales del usuario.
 */
public class LoginServicio {

    private static final String API_URL = "http://localhost:9080/api/usuarios";

    /**
     * Valida las credenciales de un usuario a través de la API.
     * @param correoElectronico el correo electrónico del usuario.
     * @param contrasena la contraseña del usuario.
     * @return true si las credenciales son válidas, false en caso contrario.
     */
    public boolean validarCredenciales(String correoElectronico, String contrasena) {
        System.out.println("Validando credenciales para: " + correoElectronico);

        // Crear una instancia de RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Configurar las cabeceras de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Realizar la solicitud GET a la API
        try {
            ResponseEntity<UsuarioDto[]> response = restTemplate.getForEntity(
                API_URL + "?correoElectronico=" + correoElectronico, UsuarioDto[].class);

            // Verificar si la respuesta es exitosa y contiene datos
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null && response.getBody().length > 0) {
                UsuarioDto usuario = response.getBody()[0];
                System.out.println("Usuario encontrado: " + usuario.getCorreoElectronico());
                System.out.println("Contraseña almacenada: " + usuario.getContrasena());

                // Validar la contraseña
                return usuario.getContrasena().equals(contrasena);
            } else {
                System.out.println("Usuario no encontrado o error en la API");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return false;
        }
    }
}
