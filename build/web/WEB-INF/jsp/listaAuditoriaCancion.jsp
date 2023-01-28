<%-- 
    Document   : listaAuditoriaCancion
    Created on : 31/03/2022, 06:56:19 PM
    Author     : Raúl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Lista Cambios Canciones</title>
    <link rel="shortcut icon" href="img/IconoPagina.png" type="image/x-icon" />
    <link rel="stylesheet" href="css/estilos.css" type="text/css">
</head>

<body class="d-flex h-100 text-center text-white">
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
                <h4>Lista General de Cambios Canciones</h4>
                <div style="float: right">
                    <a class="btn btn-outline-light" href="listaCancion.htm">Ver Registros</a>
                </div>
                <div style="float: left">
                    <a class="btn btn-outline-light" href="altaCancion.htm">Agregar Registro</a>
                </div>
            </div>
            <div class="card-body bg-dark scrollmenu">
                <!-- <input class="form-control" type="text" id="Buscar" onkeyup="Buscar();"
                    placeholder="Realiza la Busqueda" title="Type in a name"> -->
                <table id="tabla" class="table table-dark">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Grupo</th>
                            <th>Interprete</th>
                            <th>Album</th>
                            <th>Duracion</th>
                            <th>Lanzamiento</th>
                            <th>Idioma</th>
                            <th>Genero</th>
                            <th>Usuario</th>
                            <th>Modificado</th>
                            <th>Proceso</th>
                            <th>idCancion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dato" items="${Lista}">
                            <tr>
                                <!--Se coloca igual que la BD-->
                                <td>${dato.id}</td>
                                <td>${dato.Nombre}</td>
                                <td>${dato.idGrupo}</td>
                                <td>${dato.idInterprete}</td>
                                <td>${dato.idAlbum}</td>
                                <td>${dato.Duracion}</td>
                                <td>${dato.Lanzamiento}</td>
                                <td>${dato.Idioma}</td>
                                <td>${dato.Genero}</td>
                                <td>${dato.Usuario}</td>
                                <td>${dato.Modificado}</td>
                                <td>${dato.Proceso}</td>
                                <td>${dato.idCancion}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="index.htm" class="btn btn-outline-success btn-lg">Regresar</a>
            </div>
        </div>
    </div>
</body>

<!-- Datatables -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.semanticui.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fomantic-ui/2.8.8/semantic.min.js"></script>
<script src="js/buscar.js"></script>

</html>