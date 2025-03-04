package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.ActualizarServicio;
import dtos.UsuarioDto;

import java.io.IOException;

@WebServlet("/actualizarUsuario")
public class ActualizarControlador extends HttpServlet {

    private ActualizarServicio actualizarServicio = new ActualizarServicio();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        Long id = Long.parseLong(request.getParameter("id"));
        String nombreCompleto = request.getParameter("nombreCompleto");
        String movil = request.getParameter("movil");
        String correoElectronico = request.getParameter("correoElectronico");
        String tipoUsuario = request.getParameter("tipoUsuario");
        String contrasena = request.getParameter("contrasena");

        System.out.println("Datos recibidos:"); // Depuración
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Móvil: " + movil);
        System.out.println("Correo: " + correoElectronico);
        System.out.println("Tipo de Usuario: " + tipoUsuario);
        System.out.println("Contraseña: " + contrasena);

        // Crear un objeto UsuarioDto con los datos actualizados
        UsuarioDto usuario = new UsuarioDto();
        usuario.setId(id);
        usuario.setNombreCompleto(nombreCompleto);
        usuario.setMovil(movil);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setTipoUsuario(tipoUsuario);
        usuario.setContrasena(contrasena);

        // Llamar al servicio para actualizar el usuario
        boolean actualizado = actualizarServicio.actualizarUsuario(usuario);

        // Redirigir o mostrar un mensaje de error
        if (actualizado) {
            System.out.println("Usuario actualizado correctamente"); // Depuración
            response.sendRedirect("menuAdministrador.jsp"); // Redirigir si la actualización fue exitosa
        } else {
            System.out.println("Error al actualizar el usuario"); // Depuración
            request.setAttribute("errorMessage", "Error al actualizar el usuario.");
            request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);
        }
    }
}