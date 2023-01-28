<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="es" class="h-100">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Musica</title>
        <link rel="shortcut icon" href="img/IconoPagina.png" type="image/x-icon" />
        <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/4.0/examples/album/album.css" rel="stylesheet">
    </head>

    <body>
    <header>
        <div class="collapse bg-dark" id="navbarHeader">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-md-7 py-4">
                        <h4 class="text-white">Acerca de</h4>
                        <p class="text-muted">Este sitio web va a registrar datos en una base de Datos que contiene 5
                            tablas, los cuales son: Album, Artista, Canciones, Disquera y Grupo.</p>
                        <h4 class="text-white">Asignatura</h4>
                        <p class="text-muted">Diseño de Sistemas <br>Octavo Semestre</p>
                    </div>
                    <div class="col-sm-4 offset-md-1 py-4">
                        <h4 class="text-white">Apartados</h4>
                        <ul class="list-unstyled">
                            <li><a href="listaAlbum.htm" class="text-white">Album</a></li>
                            <li><a href="listaArtista.htm" class="text-white">Artista</a></li>
                            <li><a href="listaCancion.htm" class="text-white">Cancion</a></li>
                            <li><a href="listaDisquera.htm" class="text-white">Disquera</a></li>
                            <li><a href="listaGrupo.htm" class="text-white">Grupo</a></li>
                            <li><a href="login.htm" class="text-white">Cerrar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="navbar navbar-dark bg-dark box-shadow">
            <div class="container d-flex justify-content-between">
                <a href="index.htm" class="navbar-brand d-flex align-items-center">
                    <svg width="20" height="20" class="mr-2" xmlns="http://www.w3.org/2000/svg" fill="currentColor"
                         class="bi bi-music-note-beamed" viewBox="0 0 16 16" xmlns:xlink="http://www.w3.org/1999/xlink"
                         xml:space="preserve" width="100%" height="100%">
                        <path xmlns="http://www.w3.org/2000/svg"
                              d="M6 13c0 1.105-1.12 2-2.5 2S1 14.105 1 13c0-1.104 1.12-2 2.5-2s2.5.896 2.5 2zm9-2c0 1.105-1.12 2-2.5 2s-2.5-.895-2.5-2 1.12-2 2.5-2 2.5.895 2.5 2z">
                        </path>
                        <path xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" d="M14 11V2h1v9h-1zM6 3v10H5V3h1z">
                        </path>
                        <path xmlns="http://www.w3.org/2000/svg"
                              d="M5 2.905a1 1 0 0 1 .9-.995l8-.8a1 1 0 0 1 1.1.995V3L5 4V2.905z"></path>
                    </svg>
                    <strong>Musica</strong>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader"
                        aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </div>
    </header>

    <main role="main">

        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Musica</h1>
                <p class="lead text-muted">Este es un pequeño ejemplo de un Repertorio de Musica utilizando Java Spring.
                </p>
                <!-- <p class="lead text-muted">Alumnos: 
                    <br>Luis Manuel Bastida Lemus
                    <br>Raúl Gabriel Gerónimo Herrera
                    <br>Felipe Reyes Miguel
                    <br>Brian Alejandro Rodriguez Cruz
                    <br>Brian Ulises Orihuela Perez
                    <br>Luis Enrique Vaca Crispin
                </p> -->
            </div>
        </section>

        <div class="album py-5 bg-light bg-dark">
            <div class="container">

                <div class="row">
                    <!-- Album -->
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="img/Album.jpg" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text">En este apartado podras visualizar la lista de los Albums
                                    registrados en la base de datos, asi como poder insertar uno nuevo o modificar y
                                    eliminar los Albums ya registrados.</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a class="btn btn-sm btn-outline-secondary" href="listaAlbum.htm">Lista</a>
                                        <a class="btn btn-sm btn-outline-secondary" href="altaAlbum.htm">Insertar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Artistas -->
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="img/Artistas.jpg" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text">En este apartado podras visualizar la lista de los Artistas
                                    registrados en la base de datos, asi como poder insertar uno nuevo o modificar y
                                    eliminar los Artistas ya registrados.</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a class="btn btn-sm btn-outline-secondary" href="listaArtista.htm">Lista</a>
                                        <a class="btn btn-sm btn-outline-secondary" href="altaArtista.htm">Insertar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Cancion -->
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="img/Cancion.jpg" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text">En este apartado podras visualizar la lista de las Canciones
                                    registradas en la base de datos, asi como poder insertar una nueva o modificar y
                                    eliminar las Cancion ya registradas.</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a class="btn btn-sm btn-outline-secondary" href="listaCancion.htm">Lista</a>
                                        <a class="btn btn-sm btn-outline-secondary" href="altaCancion.htm">Insertar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Disquera -->
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="img/Disqueras.jpg" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text">En este apartado podras visualizar la lista de las Disquera
                                    registradas en la base de datos, asi como poder insertar una nueva o modificar y
                                    eliminar las Disqueras ya registradas.</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a class="btn btn-sm btn-outline-secondary" href="listaDisquera.htm">Lista</a>
                                        <a class="btn btn-sm btn-outline-secondary" href="altaDisquera.htm">Insertar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Grupo -->
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" src="img/Grupo.jpg" alt="Card image cap">
                            <div class="card-body">
                                <p class="card-text">En este apartado podras visualizar la lista de los Grupos
                                    registrados en la base de datos, asi como poder insertar uno nuevo o modificar y
                                    eliminar los Grupo ya registrados.</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a class="btn btn-sm btn-outline-secondary" href="listaGrupo.htm">Lista</a>
                                        <a class="btn btn-sm btn-outline-secondary" href="altaGrupo.htm">Insertar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </main>
    <!-- Footer -->
    <footer class="text-muted">
        <div class="container">
            <p class="float-right">
                <a href="index.htm">Inicio</a>
            </p>
            <p>Musica Spring &copy; UAEM O7, Proyecto Diseño de Sistemas, &reg; 2022
                <br> <strong>Realizado por:</strong> Luis Manuel Bastida Lemus, 
                Raúl Gabriel Gerónimo Herrera, 
                Brian Alejandro Rodriguez Cruz, 
            Martin Daniel Gaytan Serrano</p>
        </div>
    </footer>
    <!-- Script -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous">
    </script>
    <script src="https://getbootstrap.com/docs/4.0/assets/js/vendor/popper.min.js"></script>
    <script src="https://getbootstrap.com/docs/4.0/dist/js/bootstrap.min.js"></script>
    <script src="https://getbootstrap.com/docs/4.0/assets/js/vendor/holder.min.js"></script>
</body>

</html>