package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.EliminarServicio;

import java.io.IOException;

@WebServlet("/eliminarUsuario")
public class EliminarControlador extends HttpServlet {

    private EliminarServicio eliminarServicio = new EliminarServicio();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        boolean eliminado = eliminarServicio.eliminarUsuario(id);

        if (eliminado) {
            response.sendRedirect("menuAdministrador.jsp"); // Redirigir a la página de administración si la eliminación fue exitosa
        } else {
            request.setAttribute("errorMessage", "Error al eliminar el usuario.");
            request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);
        }
    }
}