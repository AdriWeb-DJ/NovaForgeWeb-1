package controladores;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Controlador para gestionar el inicio de sesión de los usuarios.
 */
@WebServlet("/login")
public class LoginControlador extends HttpServlet {

    /**
     * Procesa el inicio de sesión del usuario.
     * 
     * @param request la solicitud HTTP.
     * @param response la respuesta HTTP.
     * @throws ServletException si ocurre un error al procesar la solicitud.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String correo = request.getParameter("email");
        String password = request.getParameter("password");

        // Verificar si el usuario es válido y obtener su rol
        boolean isValidUser = verificarUsuarioEnAPI(correo, password);
        String rol = obtenerRolDesdeAPI(correo);

        if (isValidUser) {
            // Crear sesión y redirigir según el rol del usuario
            HttpSession session = request.getSession();
            session.setAttribute("email", correo);
            session.setAttribute("rol", rol);

            if ("Administrador".equals(rol)) {
                response.sendRedirect("menuAdministrador.jsp");
            } else if ("Gerente".equals(rol)) {
                response.sendRedirect("menuGerente.jsp");
            } else if ("Usuario".equals(rol)) {
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("errorMessage", "Rol desconocido.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Email o contraseña incorrectos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /**
     * Verifica la existencia del usuario en la API.
     * 
     * @param correo el correo electrónico del usuario.
     * @param password la contraseña del usuario.
     * @return true si el usuario existe y las credenciales son correctas, false en caso contrario.
     */
    private boolean verificarUsuarioEnAPI(String correo, String password) {
        try {
            URL url = new URL("http://localhost:9080/api/usuarios/buscar?correoElectronico=" + correo);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Obtener respuesta JSON y verificar el correo y contraseña
            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder jsonResponse = new StringBuilder();
            while (scanner.hasNext()) {
                jsonResponse.append(scanner.nextLine());
            }
            scanner.close();

            return jsonResponse.toString().contains(correo) && jsonResponse.toString().contains(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Obtiene el rol del usuario desde la API.
     * 
     * @param correo el correo electrónico del usuario.
     * @return el rol del usuario.
     */
    private String obtenerRolDesdeAPI(String correo) {
        try {
            URL url = new URL("http://localhost:9080/api/usuarios/buscar?correoElectronico=" + correo);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Obtener respuesta JSON y extraer el rol
            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder jsonResponse = new StringBuilder();
            while (scanner.hasNext()) {
                jsonResponse.append(scanner.nextLine());
            }
            scanner.close();

            JSONObject jsonObject = new JSONObject(jsonResponse.toString());
            return jsonObject.optString("tipoUsuario", "sin_rol");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "desconocido";
    }
}
