<%-- 
    Document   : PDFArtista
    Created on : 12/05/2022, 07:51:16 PM
    Author     : Raúl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Estilos -->
    <title>Lista Artista</title>
    <link rel="shortcut icon" href="img/IconoPagina.png" type="image/x-icon" />
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
    <div class="container mt-4">
        <div class="card">
            <div class="card-header">
                    <h4>Lista General Artista</h4>
                </div>
            <div class="card-body">
                <table id="tabla" class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Paterno</th>
                            <th>Materno</th>
                            <th>Artistico</th>
                            <th>Edad</th>
                            <th>Genero</th>
                            <th>Nacimiento</th>
                            <th>Pais</th>
                            <th>Instrumento</th>
                            <th>Estatura</th>
                            <th>Imagen</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dato" items="${Lista}">
                            <tr>
                                <!--Se coloca igual que la BD-->
                                <td>${dato.idArtista}</td>
                                <td>${dato.nombre}</td>
                                <td>${dato.ApellidoP}</td>
                                <td>${dato.ApellidoM}</td>
                                <td>${dato.NombreArtistico}</td>
                                <td>${dato.Edad}</td>
                                <td>${dato.Genero}</td>
                                <td>${dato.FechaNacimiento}</td>
                                <td>${dato.Pais}</td>
                                <td>${dato.Instrumento}</td>
                                <td>${dato.Estatura}</td>
                                <td>
                                    <div class="media">
                                        <img src="./img/Artista/${dato.Imagen}" style="width: 120px;" alt="Imagen">
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                            <button type="button" id="btnCrearPdf" class="btn btn-danger">Exportar PDF</button>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>

<script src="https://unpkg.com/xlsx@latest/dist/xlsx.full.min.js"></script>
    <script src="https://unpkg.com/file-saverjs@latest/FileSaver.min.js"></script>
    <script src="https://unpkg.com/tableexport@latest/dist/js/tableexport.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
    <script src="https://unpkg.com/jspdf@latest/dist/jspdf.umd.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.3/html2pdf.bundle.min.js"></script>

    <script src="js/pdfArtista.js"></script>

</html>
