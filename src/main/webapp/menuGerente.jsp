<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menú Gerentes</title>
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
            <a class="navbar-brand" href="#">NovaForgeGames - Gerente</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="index.jsp">Inicio</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Usuarios</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Configuración</a></li>
                    <li class="nav-item"><a class="nav-link btn btn-danger text-white" href="index.jsp">Cerrar sesión</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container text-center mt-5">
        <h1>Bienvenido, Gerente</h1>
        <p>Esta es la sección de gestión para los gerentes.</p>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
