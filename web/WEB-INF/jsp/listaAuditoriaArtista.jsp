<%-- 
    Document   : listaAuditoriaArtista
    Created on : 30/03/2022, 10:36:12 PM
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
    <title>Lista Cambios Artista</title>
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
                <h4>Lista General de Cambios Artista</h4>
                <div style="float: right">
                    <a class="btn btn-outline-light" href="listaArtista.htm">Ver Registros</a>
                </div>
                <div style="float: left">
                    <a class="btn btn-outline-light" href="altaArtista.jsp">Agregar Registro</a>
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
                            <th>Apellidos</th>
                            <th>Artistico</th>
                            <th>Genero</th>
                            <th>Nacimiento</th>
                            <th>Defuncion</th>
                            <th>Pais</th>
                            <th>Instrumento</th>
                            <th>Estatura</th>
                            <th>Imagen</th>
                            <th>Usuario</th>
                            <th>Modificado</th>
                            <th>Proceso</th>
                            <th>idArtista</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dato" items="${Lista}">
                            <tr>
                                <!--Se coloca igual que la BD-->
                                <td>${dato.id}</td>
                                <td>${dato.Nombre}</td>
                                <td>${dato.Apellidos}</td>
                                <td>${dato.Artistico}</td>
                                <td>${dato.Genero}</td>
                                <td>${dato.Nacimiento}</td>
                                <td>${dato.Defuncion}</td>
                                <td>${dato.Pais}</td>
                                <td>${dato.Instrumento}</td>
                                <td>${dato.Estatura}</td>
                                <td>
                                    <div class="media">
                                        <img src="${dato.Imagen}" style="width: 120px;" alt="Imagen">
                                    </div>
                                </td>
                                <td>${dato.Usuario}</td>
                                <td>${dato.Modificado}</td>
                                <td>${dato.Proceso}</td>
                                <td>${dato.idArtista}</td>
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