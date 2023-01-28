<%-- 
    Document   : GeneraQRAlbum
    Created on : 19/03/2022, 06:58:30 PM
    Author     : Raúl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Datatables -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fomantic-ui/2.8.8/semantic.min.css"
              type="text/css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.semanticui.min.css" type="text/css">
        <!-- Estilos -->
        <title>Codigo QR Album</title>
        <link rel="shortcut icon" href="img/IconoPagina.png" type="image/x-icon" />
        <link rel="stylesheet" href="css/estilos.css" type="text/css">
    </head>

    <body class="d-flex h-100 text-white">
        <div class="container mt-4">
            <a href="index.htm">
                <h3 class="float-md-start mb-0 text-white">Música</h3>
            </a>
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link text-white" href="listaAlbum.htm">Album</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="listaArtista.htm">Artista</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="listaCancion.htm">Canciones</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="listaDisquera.htm">Disquera</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="listaGrupo.htm">Grupo</a>
                </li>
            </ul>

            <div class="card">
                <div class="card-header bg-success">
                    <h3>Codigo QR Album</h3>
                </div>
                <div class="card-body bg-dark">
                    <form method="POST">
                        <img title="QR" src="img/QR.png" width="300" height="300" />
                        <h3></h3>
                        <label>Id</label>
                        <input type="text" name="idAlbum" class="form-control" value="${Lista[0].idAlbum}" disabled />

                        <label>Grupo</label>
                        <input type="text" name="idGrupo" class="form-control" value="${ListaAlbum[0].Grupo}" disabled />

                        <label>Nombre</label>
                        <input type="text" name="nombre" class="form-control" value="${Lista[0].nombre}" disabled />

                        <label>Número de Canciones</label>
                        <input type="text" name="NoCanciones" class="form-control" value="${Lista[0].NoCanciones}"
                               disabled />

                        <label>Duracion</label>
                        <input type="text" name="duracion" class="form-control" value="${Lista[0].duracion}" disabled />

                        <label>Fecha de Lanzamiento</label>
                        <input type="text" name="Lanzamiento" class="form-control" value="${Lista[0].Lanzamiento}"
                               disabled />

                        <label>Numero de Ventas</label>
                        <input type="text" name="NoVentas" class="form-control" value="${Lista[0].NoVentas}" disabled />

                        <label>Genero Musical</label>
                        <input type="text" name="genero" class="form-control" value="${Lista[0].genero}" disabled />

                        <label>Portada</label><br>
                        <img src="${Lista[0].Imagen}" style="width: 200px;" alt="Imagen">

                        <br><br><a href="listaAlbum.htm" class="btn btn-outline-success">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>