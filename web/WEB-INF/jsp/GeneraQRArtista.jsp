<%-- 
    Document   : generaqr
    Created on : 18/03/2022, 03:39:20 PM
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
    <title>Codigo QR Artista</title>
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
                <h3>Codigo QR Artista</h3>
            </div>
            <div class="card-body bg-dark">
                <form method="POST">
                    <img title="QR" src="img/QR.png" width="300" height="300" />
                    <h3></h3>
                    <label>Id</label>
                    <input type="text" name="idArtista" class="form-control" value="${Lista[0].idArtista}" disabled />

                    <label>Nombre</label>
                    <input type="text" name="nombre" class="form-control" value="${Lista[0].Nombre}" disabled />

                    <label>Apellidos</label>
                    <input type="text" name="Apellidos" class="form-control" placeholder="Apellidos" required
                        value="${Lista[0].Apellidos}" disabled />

                    <label>Nombre Artistico</label>
                    <input type="text" name="nombreArtistico" class="form-control" value="${Lista[0].NombreArtistico}"
                        disabled />

                    <label>Sexo</label>
                    <input type="text" name="genero" class="form-control" value="${Lista[0].Genero}" disabled />

                    <label>Edad</label>
                    <input type="number" name="edad" class="form-control" value="${Lista[0].edad}" disabled />

                    <label>Fecha Nacimiento</label>
                    <input type="text" name="fechaNacimiento" class="form-control" value="${Lista[0].fechaNacimiento}"
                        disabled />

                    <label>Fecha Defuncion</label>
                    <input type="text" name="FechaDefuncion" class="form-control" value="${Lista[0].Fallecimiento}"
                        disabled />

                    <label>Pais</label>
                    <input type="text" name="pais" class="form-control" value="${Lista[0].Pais}" disabled />

                    <label>Instrumento</label>
                    <input type="text" name="instrumento" class="form-control" value="${Lista[0].Instrumento}"
                        disabled />

                    <label>Estatura</label>
                    <input type="text" name="estatura" class="form-control" value="${Lista[0].estatura}" disabled />

                    <label>Foto</label><br>
                    <img src="${Lista[0].Imagen}" style="width: 400px;" alt="Imagen"><br><br>

                    <a href="listaArtista.htm" class="btn btn-outline-success">Regresar</a>
                </form>
            </div>
        </div>
    </div>
</body>

</html>