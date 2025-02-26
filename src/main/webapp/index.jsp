<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>NovaForgeGames</title>
    <!-- Bootstrap CSS (CDN) -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="styles.css">
    
    <link rel="icon" href="img/icono.png" type="image/png">
    
</head>
<body>
    <!-- ========== NAVBAR ========== -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-blue-purple text-white p-3">
        <div class="container bg-blue-purple">
            <a class="navbar-brand" href="index.jsp">NovaForgeGames</a>
            <button class="navbar-toggler" type="button" 
                    data-bs-toggle="collapse" 
                    data-bs-target="#navbarSupportedContent" 
                    aria-controls="navbarSupportedContent" 
                    aria-expanded="false" 
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Juegos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Consolas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Accesorios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contacto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Iniciar Sesion</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    
    <!-- ========== SLIDER (CAROUSEL) ========== -->
    <div id="featuredCarousel" class="carousel slide mt-5" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#featuredCarousel" data-bs-slide-to="0" 
                    class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#featuredCarousel" data-bs-slide-to="1" 
                    aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#featuredCarousel" data-bs-slide-to="2" 
                    aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <!-- Slide 1 -->
            <div class="carousel-item active">
                <img width="1080" height="600" src="img/hk_portada.jpg" class="d-block w-100" alt="Juego 1">
                <div class="carousel-caption d-none d-md-block"> 
                </div>
            </div>
            <!-- Slide 2 -->
            <div class="carousel-item">
                <img width="1080" height="600"  src="img/er_base.jpg" class="d-block w-100" alt="Juego 2">
                <div class="carousel-caption d-none d-md-block">
                </div>
            </div>
            <!-- Slide 3 -->
            <div class="carousel-item">
                <img width="1080" height="600" src="img/tboi.jpg" class="d-block w-100" alt="Juego 3">
                <div class="carousel-caption d-none d-md-block">
                </div>
            </div>
        </div>
        <!-- Controles del Carousel -->
        <button class="carousel-control-prev" type="button" data-bs-target="#featuredCarousel" 
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#featuredCarousel" 
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
        </button>
    </div>
    
    <!-- ========== SECCIÓN DE PRODUCTOS DESTACADOS ========== -->
    <div class="container my-5">
        <h2 class="text-center mb-4">Lo Más Vendido</h2>
        <div class="row row-cols-1 row-cols-md-3 g-4">
            <!-- Producto 1 -->
            <div class="col">
                <div class="card text-white">
                    <img width="580" height="350" src="img/MiSide.jpg" class="card-img-top" alt="Producto 1">
                    <div class="card-body">
                        <h5 class="card-title">Producto 1</h5>
                        <p class="card-text">Breve descripción del producto 1.</p>
                        <a href="#" class="btn btn-cta">Comprar</a>
                    </div>
                </div>
            </div>
            <!-- Producto 2 -->
            <div class="col">
                <div class="card text-white">
                    <img width="580" height="350" src="img/helldivers.jpg" class="card-img-top" alt="Producto 2">
                    <div class="card-body">
                        <h5 class="card-title">Producto 2</h5>
                        <p class="card-text">Breve descripción del producto 2.</p>
                        <a href="#" class="btn btn-cta">Comprar</a>
                    </div>
                </div>
            </div>
            <!-- Producto 3 -->
            <div class="col">
                <div class="card text-white">
                    <img width="580" height="350" src="img/sot.jpg" class="card-img-top" alt="Producto 3">
                    <div class="card-body">
                        <h5 class="card-title">Producto 3</h5>
                        <p class="card-text">Breve descripción del producto 3.</p>
                        <a href="#" class="btn btn-cta">Comprar</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- ========== FOOTER ========== -->
    <footer>
        <div class="footer-links">
            <a href="#">Términos y Condiciones</a> | 
            <a href="#">Política de Privacidad</a> | 
            <a href="#">Soporte</a>
        </div>
        <p class="mt-3">© 2025 NovaForgeGames. Todos los derechos reservados.</p>
    </footer>
    
    <!-- Bootstrap JS (CDN) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
