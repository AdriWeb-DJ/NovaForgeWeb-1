<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" href="img/icono.png" type="image/png">
</head>
<body class="d-flex justify-content-center align-items-center vh-100 bg-dark text-white">

    <div class="card p-4 shadow-lg" style="width: 22rem; background: rgba(255, 255, 255, 0.1);">
        <h1 class="text-center mb-3 text-white">Registro de Usuario</h1>

        <%-- Mensaje de error si el registro falla --%>
        <% if (request.getAttribute("errorMessage") != null) { %>
            <div class="alert alert-danger text-center mt-3">
                <%= request.getAttribute("errorMessage") %>
            </div>
        <% } %>

        <form action="registro" method="post">
            <div class="mb-3">
                <label for="nombreCompleto" class="form-label text-white">Nombre Completo</label>
                <input type="text" id="nombreCompleto" name="nombreCompleto" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="movil" class="form-label text-white">Teléfono Móvil</label>
                <input type="text" id="movil" name="movil" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="correoElectronico" class="form-label text-white">Correo Electrónico</label>
                <input type="email" id="correoElectronico" name="correoElectronico" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="contrasena" class="form-label text-white">Contraseña</label>
                <input type="password" id="contrasena" name="contrasena" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-info w-100">Registrarse</button>
        </form>

        <div class="mt-3 text-center">
            <p class="text-white">¿Ya tienes una cuenta? <a href="login.jsp" class="text-info">Inicia sesión aquí</a></p>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
