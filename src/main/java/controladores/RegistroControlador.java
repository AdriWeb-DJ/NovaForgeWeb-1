package controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import servicios.RegistroServicio;
import dtos.UsuarioDto;

@WebServlet("/registro")
public class RegistroControlador extends HttpServlet {

    private RegistroServicio registroServicio = new RegistroServicio();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener los datos del formulario
        String nombreCompleto = request.getParameter("nombreCompleto");
        String movil = request.getParameter("movil");
        String correoElectronico = request.getParameter("correoElectronico");
        String contrasena = request.getParameter("contrasena");

        // Crear objeto UsuarioDto
        UsuarioDto nuevoUsuario = new UsuarioDto();
        nuevoUsuario.setNombreCompleto(nombreCompleto);
        nuevoUsuario.setMovil(movil);
        nuevoUsuario.setCorreoElectronico(correoElectronico);
        nuevoUsuario.setContrasena(contrasena);

        nuevoUsuario.setTipoUsuario("Usuario");

        // Intentar registrar al usuario
        boolean registrado = registroServicio.registrarUsuario(nuevoUsuario);

        if (registrado) {
            response.sendRedirect("login.jsp"); // Redirigir a login si el registro es exitoso
        } else {
            request.setAttribute("errorMessage", "Error en el registro. Inténtalo de nuevo.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}
