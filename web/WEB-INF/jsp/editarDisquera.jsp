<%-- 
    Document   : editarDisquera
    Created on : 14/03/2022, 07:24:22 PM
    Author     : Lemus
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
    <title>Actualiza Disquera</title>
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
                <h3>Actualiza Disquera</h3>
            </div>
            <div class="card-body bg-dark">
                <form method="POST">
                    <label>Nombre</label>
                    <input type="text" name="nombre" class="form-control" value="${Lista[0].Nombre}" required
                        placeholder="Nombre de la Disquera" autofocus />

                    <label>Correo</label>
                    <input type="email" name="correo" class="form-control" value="${Lista[0].Correo}" required
                        placeholder="Correo de la Disquera" />

                    <label>Direccion</label>
                    <input type="text" name="Direccion" class="form-control" value="${Lista[0].Direccion}" required
                        placeholder="Dirección en donde se encuentra" />

                    <label>Telefono</label>
                    <input type="tel" name="Telefono" class="form-control" required placeholder="Telefono de Contacto"
                        pattern="[0-9]{3}[0-9]{3}[0-9]{4}"
                        title="Un número de teléfono válido consiste en un área de código de 3 dígitos entre paréntesis, un espacio, los tres primeros dígitos del número, un espacio o hypen (-), y cuatro dígitos más."
                        value="${Lista[0].Telefono}" />

                    <label>Fundacion</label>
                    <input type="date" name="Fundacion" class="form-control" value="${Lista[0].Fundacion}" required/>

                    <label>Imagen</label>
                    <input type="url" name="imagen" class="form-control" placeholder="URL de una imagen" value="${Lista[0].Imagen}" required>

                    <br><button type="submit" class="btn btn-outline-primary">Actualizar</button>
                    <a href="listaDisquera.htm" class="btn btn-outline-success">Regresar</a>
                </form>
            </div>
        </div>
    </div>
</body>

</html>