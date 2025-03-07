package controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import servicios.RegistroServicio;
import dtos.UsuarioDto;

/**
 * Controlador encargado del registro de nuevos usuarios.
 * Recibe la solicitud de registro y la procesa para crear un nuevo usuario.
 */
@WebServlet("/registro")
public class RegistroControlador extends HttpServlet {

    private RegistroServicio registroServicio = new RegistroServicio();

    /**
     * Método que maneja la solicitud POST para registrar un usuario.
     * Recibe los datos del formulario y los utiliza para crear un nuevo usuario.
     *
     * @param request  Objeto HttpServletRequest que contiene los datos del formulario.
     * @param response Objeto HttpServletResponse para redirigir a otra página.
     * @throws ServletException si ocurre un error en el procesamiento de la solicitud.
     * @throws IOException si ocurre un error en la comunicación con el cliente.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener datos del formulario
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

        // Intentar registrar usuario
        boolean registrado = registroServicio.registrarUsuario(nuevoUsuario);

        if (registrado) {
            response.sendRedirect("login.jsp"); // Redirigir a login si éxito
        } else {
            request.setAttribute("errorMessage", "Error en el registro. Inténtalo de nuevo.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}
