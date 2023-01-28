<%-- 
    Document   : altaGrupo
    Created on : 14/03/2022, 08:02:13 PM
    Author     : Lemus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Agregar Grupo</title>
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
                <h3>Nuevo Grupo</h3>
            </div>
            <div class="card-body bg-dark">
                <form method="POST">
                    <label>Nombre</label>
                    <input type="text" name="Nombre" class="form-control" required placeholder="Nombre del Grupo"
                        autofocus />

                    <label>Disquera</label>
                    <select id="Disquera" name="idDisquera" class="form-select" aria-label="Default select example"
                        required>
                        <option selected disabled value="">Selecciona una Disquera</option>
                        <c:forEach var="dato" items="${ListaDisquera}">
                            <option value="${dato.idDisquera}">${dato.nombre}</option>
                        </c:forEach>
                    </select>

                    <label>Origen</label>
                    <input type="text" name="Origen" class="form-control" required placeholder="Lugar de Origen" />

                    <label>Inicio</label>
                    <input type="date" name="Inicio" class="form-control" required />

                    <label>No Integrantes</label>
                    <input type="number" name="NoIntegrantes" class="form-control" required
                        placeholder="Número de Integrantes" />

                    <label>Genero</label>
                    <select name="genero" class="form-select" aria-label="Default select example" required>
                        <option selected disabled value="">Selecciona un Genero</option>
                        <option value="Alternativo">Alternativo</option>
                        <option value="Blues">Blues</option>
                        <option value="Country">Country</option>
                        <option value="Electronica">Electrónica</option>
                        <option value="Garage">Garage</option>
                        <option value="Grunge">Grunge</option>
                        <option value="Hard Rock">Hard Rock</option>
                        <option value="Hadcore Punk">Hadcore Punk</option>
                        <option value="Heavy Metal">Heavy Metal</option>
                        <option value="Hip Hop">Hip Hop</option>
                        <option value="Instrumental">Instrumental</option>
                        <option value="K-Pop">K-Pop</option>
                        <option value="Metal">Metal</option>
                        <option value="Nu Metal">Nu Metal</option>
                        <option value="Pop">Pop</option>
                        <option value="Punk">Punk</option>
                        <option value="Rap">Rap</option>
                        <option value="Reggae">Reggae</option>
                        <option value="Rhythm and Blues">Rhythm and Blues</option>
                        <option value="Rock">Rock</option>
                        <option value="Rock Alternativo">Rock Alternativo</option>
                        <option value="Salsa">Salsa</option>
                        <option value="Soul">Soul</option>
                    </select>

                    <label>Idioma</label>
                    <select name="idioma" class="form-select" aria-label="Default select example" required>
                        <option selected disabled value="">Selecciona el Idioma</option>
                        <option value="Aleman">Alemán</option>
                        <option value="Coreano">Coreano</option>
                        <option value="Español">Español</option>
                        <option value="Frances">Francés</option>
                        <option value="Ingles">Inglés</option>
                        <option value="Italiano">Italiano</option>
                        <option value="Latin">Latín</option>
                    </select>

                    <label>Imagen</label>
                    <input type="url" name="imagen" class="form-control" placeholder="URL de una imagen" required>

                    <br><button type="submit" class="btn btn-outline-primary">Agregar</button>
                    <a href="listaGrupo.htm" class="btn btn-outline-success">Regresar</a>
                </form>
            </div>
        </div>
    </div>
</body>
<!-- Script -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
    var foption = $('#Disquera option:first');
    var soptions = $('#Disquera option:not(:first)').sort(function (a, b) {
        return a.text == b.text ? 0 : a.text < b.text ? -1 : 1
    });
    $('#Disquera').html(soptions).prepend(foption);
</script>

</html>