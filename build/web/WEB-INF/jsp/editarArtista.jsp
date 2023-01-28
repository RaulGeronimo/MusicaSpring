<%-- 
    Document   : editarArtista
    Created on : 12/03/2022, 06:27:40 PM
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
        <title>Actualiza Artista</title>
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
                    <h3>Actualiza Artista</h3>
                    <div style="float: right">
                        <a class="btn btn-outline-light" href="editarArtistaTieso.htm?idArtista=${Lista[0].idArtista}">Artista Petateado</a>
                    </div>
                </div>
                <div class="card-body bg-dark">
                    <form method="POST">
                        <label>Nombre</label>
                        <input type="text" name="nombre" class="form-control" placeholder="Nombre del Artista" required onfocus value="${Lista[0].Nombre}"/>

                        <label>Apellidos</label>
                        <input type="text" name="Apellidos" class="form-control" placeholder="Apellidos" required value="${Lista[0].Apellidos}"/>

                        <label>Nombre Artistico</label>
                        <input type="text" name="nombreArtistico" class="form-control" placeholder="Nombre Artistico"
                               required value="${Lista[0].nombreArtistico}"/>

                        <label for="genero">Sexo</label>
                        <select id="genero" name="genero" class="form-select" aria-label="Default select example" required>
                            <option selected value="${Lista[0].genero}">${Lista[0].genero}</option>
                            <option disabled value="">Selecciona un Genero</option>
                            <option value="H">Hombre</option>
                            <option value="M">Mujer</option>
                        </select>

                        <label>Fecha Nacimiento</label>
                        <input type="date" name="fechaNacimiento" class="form-control" required value="${Lista[0].fechaNacimiento}"/>

                        <label>Pais</label>
                        <select name="pais" class="form-select" aria-label="Default select example" required>
                            <option selected value="${Lista[0].Pais}">${Lista[0].Pais}</option>
                            <option disabled value="">Selecciona el Pais de Origen</option>
                            <option value="Alemania">Alemania</option>
                            <option value="Argentina">Argentina</option>
                            <option value="Australia">Australia</option>
                            <option value="Austria">Austria</option>
                            <option value="Belgica">Bélgica</option>
                            <option value="Bielorrusia">Bielorrusia</option>
                            <option value="Bolivia">Bolivia</option>
                            <option value="Bosnia y Herzegovina">Bosnia y Herzegovina</option>
                            <option value="Brasil">Brasil</option>
                            <option value="Canada">Canadá</option>
                            <option value="Chile">Chile</option>
                            <option value="China">China</option>
                            <option value="Colombia">Colombia</option>
                            <option value="Corea del Norte">Corea del Norte</option>
                            <option value="Corea del Sur">Corea del Sur</option>
                            <option value="Dinamarca">Dinamarca</option>
                            <option value="España">España</option>
                            <option value="Estados Unidos">Estados Unidos</option>
                            <option value="Francia">Francia</option>
                            <option value="Inglaterra">Inglaterra</option>
                            <option value="Irlanda">Irlanda</option>
                            <option value="Italia">Italia</option>
                            <option value="Jamaica">Jamaica</option>
                            <option value="Libano">Líbano</option>
                            <option value="Mexico">México</option>
                            <option value="Paises Bajos">Países Bajos</option>
                            <option value="Panama">Panamá</option>
                            <option value="Paraguay">Paraguay</option>
                            <option value="Peru">Perú</option>
                            <option value="Polonia">Polonia</option>
                            <option value="Portugal">Portugal</option>
                            <option value="Reino Unido">Reino Unido</option>
                            <option value="Rusia">Rusia</option>
                            <option value="Suecia">Suecia</option>
                            <option value="Suiza">Suiza</option>
                            <option value="Uruguay">Uruguay</option>
                            <option value="Venezuela">Venezuela</option>
                        </select>

                        <label>Instrumento</label>
                        <select name="instrumento" class="form-select" aria-label="Default select example" required>
                            <option selected value="${Lista[0].instrumento}">${Lista[0].instrumento}</option>
                            <option disabled value="">Instrumento que toca</option>
                            <option value="Ninguno">Ninguno</option>
                            <option value="Acordeon">Acordeón</option>
                            <option value="Arpa">Arpa</option>
                            <option value="Bajo Electrico">Bajo Eléctrico</option>
                            <option value="Bateria">Batería</option>
                            <option value="Clarinete">Clarinete</option>
                            <option value="Flauta">Flauta</option>
                            <option value="Guitarra Acustica">Guitarra Acústica</option>
                            <option value="Guitarra Electrica">Guitarra Eléctrica</option>
                            <option value="Piano">Piano</option>
                            <option value="Saxofon">Saxofón</option>
                            <option value="Sintetizador">Sintetizador</option>
                            <option value="Teclado">Teclado</option>
                            <option value="Trompeta">Trompeta</option>
                            <option value="Violin">Violín</option>
                        </select>

                        <label>Estatura</label>
                        <input type="text" name="estatura" class="form-control" placeholder="Estatura en Metros" required value="${Lista[0].Estatura}"/>

                        <label>Imagen</label>
                        <input type="url" name="imagen" class="form-control" required value="${Lista[0].Imagen}">

                        <br><button type="submit" class="btn btn-outline-primary">Actualizar</button>
                        <a href="listaArtista.htm" class="btn btn-outline-success">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>