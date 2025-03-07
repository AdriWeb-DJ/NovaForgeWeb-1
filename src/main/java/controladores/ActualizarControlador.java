package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.ActualizarServicio;
import dtos.UsuarioDto;

import java.io.IOException;

/**
 * Controlador para actualizar la información de un usuario.
 */
@WebServlet("/actualizarUsuario")
public class ActualizarControlador extends HttpServlet {

    private ActualizarServicio actualizarServicio = new ActualizarServicio();

    /**
     * Actualiza un usuario basado en los datos del formulario.
     * 
     * @param request la solicitud HTTP.
     * @param response la respuesta HTTP.
     * @throws ServletException si ocurre un error al procesar la solicitud.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener parámetros del formulario
        Long id = Long.parseLong(request.getParameter("id"));
        String nombreCompleto = request.getParameter("nombreCompleto");
        String movil = request.getParameter("movil");
        String correoElectronico = request.getParameter("correoElectronico");
        String tipoUsuario = request.getParameter("tipoUsuario");
        String contrasena = request.getParameter("contrasena");

        // Crear objeto UsuarioDto
        UsuarioDto usuario = new UsuarioDto();
        usuario.setId(id);
        usuario.setNombreCompleto(nombreCompleto);
        usuario.setMovil(movil);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setTipoUsuario(tipoUsuario);
        usuario.setContrasena(contrasena);

        // Actualizar usuario y redirigir o mostrar error
        boolean actualizado = actualizarServicio.actualizarUsuario(usuario);
        if (actualizado) {
            response.sendRedirect("menuAdministrador.jsp");
        } else {
            request.setAttribute("errorMessage", "Error al actualizar el usuario.");
            request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);
        }
    }
}
