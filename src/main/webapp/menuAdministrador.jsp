<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<%@ page import="dtos.UsuarioDto" %>
<%@ page import="servicios.UsuarioServicio" %>

<%
    // Obtener la sesión y verificar el rol
    HttpSession sesion = request.getSession(false);
    String rol = (sesion != null) ? (String) sesion.getAttribute("rol") : null;

    if (rol == null || !"Administrador".equals(rol)) {
        out.print("<h2>Error: No tienes permiso para acceder a este sitio.</h2>");
        return;
    }

    // Obtener la lista de usuarios
    UsuarioServicio usuarioServicio = new UsuarioServicio();
    List<UsuarioDto> usuarios = usuarioServicio.obtenerTodosLosUsuarios();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menú Administrador</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" href="img/icono.png" type="image/png">
    <style>
        .modal-content {
            background-color: #343a40;
            color: white;
        }
    </style>
</head>
<body class="bg-dark text-white">
    
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="#">NovaForgeGames - Administrador</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="infousuarios.jsp">Usuarios</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Configuración</a></li>
                    <li class="nav-item"><a class="nav-link btn btn-danger text-white" href="index.jsp">Cerrar sesión</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container text-center mt-5">
        <h1>Bienvenido, Administrador</h1>
        <p>Esta es el panel para gestionar a los usuarios</p>
        
        <table class="table table-dark table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre Completo</th>
                    <th>Móvil</th>
                    <th>Correo Electrónico</th>
                    <th>Tipo de Usuario</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% for (UsuarioDto usuario : usuarios) { %>
                    <tr>
                        <td><%= usuario.getId() %></td>
                        <td><%= usuario.getNombreCompleto() %></td>
                        <td><%= usuario.getMovil() %></td>
                        <td><%= usuario.getCorreoElectronico() %></td>
                        <td><%= usuario.getTipoUsuario() %></td>
                        <td>
                            <!-- Botón para abrir el modal de modificación -->
                            <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#editModal<%= usuario.getId() %>">Modificar</button>
                            <!-- Formulario para eliminar -->
                            <form action="eliminarUsuario" method="post" style="display:inline;">
                                <input type="hidden" name="id" value="<%= usuario.getId() %>">
                                <button type="submit" class="btn btn-danger">Eliminar</button>
                            </form>
                        </td>
                    </tr>

                    <!-- Modal para modificar usuario -->
                    <div class="modal fade" id="editModal<%= usuario.getId() %>" tabindex="-1" aria-labelledby="editModalLabel<%= usuario.getId() %>" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="editModalLabel<%= usuario.getId() %>">Modificar Usuario</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form action="actualizarUsuario" method="post">
                                        <input type="hidden" name="id" value="<%= usuario.getId() %>">
                                        <div class="mb-3">
                                            <label for="nombreCompleto<%= usuario.getId() %>" class="form-label">Nombre Completo</label>
                                            <input type="text" class="form-control" id="nombreCompleto<%= usuario.getId() %>" name="nombreCompleto" value="<%= usuario.getNombreCompleto() %>" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="movil<%= usuario.getId() %>" class="form-label">Móvil</label>
                                            <input type="text" class="form-control" id="movil<%= usuario.getId() %>" name="movil" value="<%= usuario.getMovil() %>" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="correoElectronico<%= usuario.getId() %>" class="form-label">Correo Electrónico</label>
                                            <input type="email" class="form-control" id="correoElectronico<%= usuario.getId() %>" name="correoElectronico" value="<%= usuario.getCorreoElectronico() %>" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="tipoUsuario<%= usuario.getId() %>" class="form-label">Tipo de Usuario</label>
                                            <select class="form-select" id="tipoUsuario<%= usuario.getId() %>" name="tipoUsuario" required>
                                                <option value="Administrador" <%= "Administrador".equals(usuario.getTipoUsuario()) ? "selected" : "" %>>Administrador</option>
                                                <option value="Gerente" <%= "Gerente".equals(usuario.getTipoUsuario()) ? "selected" : "" %>>Gerente</option>
                                                <option value="Usuario" <%= "Usuario".equals(usuario.getTipoUsuario()) ? "selected" : "" %>>Usuario</option>
                                            </select>
                                        </div>
                                        <div class="mb-3">
                                            <label for="contrasena<%= usuario.getId() %>" class="form-label">Contraseña</label>
                                            <input type="password" class="form-control" id="contrasena<%= usuario.getId() %>" name="contrasena" required>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                <% } %>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>