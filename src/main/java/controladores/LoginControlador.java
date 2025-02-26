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

@WebServlet("/login")
public class LoginControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isValidUser = verificarUsuarioEnAPI(correo, password);
        String rol = obtenerRolDesdeAPI(correo);

        if (isValidUser) {
            HttpSession session = request.getSession();
            session.setAttribute("email", correo);
            session.setAttribute("rol", rol); 

            if ("Administrador".equals(rol)) {
                response.sendRedirect("menuAdministrador.jsp");
            } else if ("Gerente".equals(rol)) {
                response.sendRedirect("menuGerente.jsp");
            } else {
                request.setAttribute("errorMessage", "Rol desconocido.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Email o contraseña incorrectos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private boolean verificarUsuarioEnAPI(String correo, String password) {
        try {
            URL url = new URL("http://localhost:9080/api/usuarios/buscar?correoElectronico=" + correo);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

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

    private String obtenerRolDesdeAPI(String correo) {
        try {
            URL url = new URL("http://localhost:9080/api/usuarios/buscar?correoElectronico=" + correo);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

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