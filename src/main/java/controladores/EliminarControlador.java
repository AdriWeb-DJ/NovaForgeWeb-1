package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.EliminarServicio;

import java.io.IOException;

/**
 * Controlador para eliminar un usuario.
 */
@WebServlet("/eliminarUsuario")
public class EliminarControlador extends HttpServlet {

    private EliminarServicio eliminarServicio = new EliminarServicio();

    /**
     * Elimina un usuario basado en el ID recibido.
     * 
     * @param request la solicitud HTTP.
     * @param response la respuesta HTTP.
     * @throws ServletException si ocurre un error al procesar la solicitud.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener el ID del usuario a eliminar
        Long id = Long.parseLong(request.getParameter("id"));

        // Eliminar usuario y redirigir o mostrar error
        boolean eliminado = eliminarServicio.eliminarUsuario(id);
        if (eliminado) {
            response.sendRedirect("menuAdministrador.jsp");
        } else {
            request.setAttribute("errorMessage", "Error al eliminar el usuario.");
            request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);
        }
    }
}
