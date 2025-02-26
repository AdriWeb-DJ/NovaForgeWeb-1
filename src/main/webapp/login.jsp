<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center vh-100 bg-dark text-white">

    <div class="card p-4 shadow-lg" style="width: 22rem; background: rgba(255, 255, 255, 0.1);">
        <h1 class="text-center mb-3 text-white">Login</h1>

        <form action="login" method="post">
            <div class="mb-3">
                <label for="email" class="form-label text-white">Email</label>
                <input type="email" id="email" name="email" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label text-white">Password</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-info w-100">Login</button>
        </form>

        <% if (request.getAttribute("errorMessage") != null) { %>
            <div class="alert alert-danger text-center mt-3">
                <%= request.getAttribute("errorMessage") %>
            </div>
        <% } %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
