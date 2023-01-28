<%-- 
    Document   : QrVistaDisquera
    Created on : 23/03/2022, 12:30:20 AM
    Author     : alex-
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
    <title>Datos de la Disquera</title>
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
                <h3>Datos de la Disquera</h3>
            </div>
            <div class="card-body bg-dark">
                <form method="POST">
                    <label>Disquera</label>
                    <input type="text" name="idDisquera" class="form-control" value="${Lista[0].idDisquera}" disabled />

                    <label>Nombre</label>
                    <input type="text" name="nombre" class="form-control" value="${Lista[0].Nombre}" disabled />

                    <label>Correo</label>
                    <input type="text" name="correo" class="form-control" value="${Lista[0].Correo}" disabled />

                    <label>Direccion</label>
                    <input type="text" name="direccion" class="form-control" value="${Lista[0].Direccion}" disabled />

                    <label>Telefono</label>
                    <input type="text" name="Telefono" class="form-control" value="${Lista[0].Telefono}" disabled />

                    <label>Fundacion</label>
                    <input type="text" name="fundacion" class="form-control" value="${Lista[0].Fundacion}" disabled />
                    
                    <label>Foto</label><br>
                    <img src="${Lista[0].Imagen}" style="width: 400px;" alt="Imagen">
                </form>
            </div>
        </div>
    </div>
</body>

</html>