CREATE database Musica;

USE Musica;

/* Crear tablas */
/* Tabla Artista */
CREATE table Artista(idArtista INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(45),
    Apellidos VARCHAR(45),
    NombreArtistico VARCHAR(60),
    Genero CHAR,
    FechaNacimiento DATE,
    FechaDefuncion DATE,
    Pais VARCHAR(45),
    Instrumento VARCHAR(45),
    Estatura DOUBLE,
    Imagen VARCHAR(200));

DESC Artista;

/* Tabla Disquera */
CREATE table Disquera(idDisquera INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(45),
    Correo VARCHAR(45),
    Direccion VARCHAR(60),
    Telefono BIGINT,
    Fundacion DATE,
    Imagen VARCHAR(200));

DESC Disquera;

/* Tabla Grupo */
CREATE table Grupo(idGrupo INT PRIMARY KEY AUTO_INCREMENT,
    idDisquera INT,
    Nombre VARCHAR(60),
    Origen VARCHAR(70),
    Inicio DATE,
    NoIntegrantes INT,
    Genero VARCHAR(45),
    Idioma VARCHAR(45),
    Imagen VARCHAR(200),
    FOREIGN KEY(idDisquera) REFERENCES Disquera(idDisquera) ON UPDATE CASCADE ON DELETE CASCADE);

DESC Grupo;

/* Tabla Album */
CREATE table Album(idAlbum INT PRIMARY KEY AUTO_INCREMENT,
    idGrupo INT,
    Nombre VARCHAR(45),
    NoCanciones INT,
    Duracion TIME,
    Lanzamiento DATE,
    NoVentas DOUBLE,
    Genero VARCHAR(45),
    Imagen VARCHAR(200),
    FOREIGN KEY(idGrupo) REFERENCES Grupo(idGrupo) ON UPDATE CASCADE ON DELETE CASCADE);

DESC Album;

/* Tabla Canciones */
CREATE TABLE Canciones(IdCancion INT PRIMARY KEY AUTO_INCREMENT,
    IdGrupo INT,
    IdInterprete INT,
    IdAlbum INT,
    Nombre VARCHAR(45),
    Duracion TIME,
    Lanzamiento DATE,
    Idioma VARCHAR(45),
    Genero VARCHAR(45),
    FOREIGN KEY(IdGrupo) REFERENCES Grupo(IdGrupo) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(IdInterprete) REFERENCES Artista(IdArtista) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(IdAlbum) REFERENCES Album(IdAlbum) ON UPDATE CASCADE ON DELETE CASCADE);

DESC Canciones;

/* Tabla Usuarios */
CREATE TABLE Usuario(IdUsuario INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(45),
    Paterno VARCHAR(45),
    Materno VARCHAR(45),
    FechaNacimiento DATE,
    Celular BIGINT,
    Sexo CHAR,
    Correo VARCHAR(45),
    Username VARCHAR(45),
    Password VARCHAR(45));

DESC Usuario;

SHOW tables;

/* -------------------------------------------  Triggers -------------------------------------------  */
/* ------------------------------------------- ARTISTA ------------------------------------------- */
CREATE table Auditoria_Artista(id int primary key auto_increment,

    Nombre VARCHAR(45),
    Apellidos VARCHAR(45),
    NombreArtistico VARCHAR(60),
    Genero CHAR,
    FechaNacimiento DATE,
    FechaDefuncion DATE,
    Pais VARCHAR(45),
    Instrumento VARCHAR(45),
    Estatura DOUBLE,
    Imagen VARCHAR(200),

    usuario varchar(45),
    modificado datetime,
    proceso varchar(45),
    idArtista int);

/* Insertar */
CREATE trigger agregar_Auditoria_Artista after insert on Artista
for each row INSERT INTO Auditoria_Artista(Nombre, Apellidos, NombreArtistico, Genero, FechaNacimiento,
    FechaDefuncion, Pais, Instrumento, Estatura, Imagen,
    usuario, modificado, proceso, idArtista) values(NEW.Nombre, NEW.Apellidos, NEW.NombreArtistico, NEW.Genero, NEW.FechaNacimiento,
    NEW.FechaDefuncion, NEW.Pais, NEW.Instrumento, NEW.Estatura, NEW.Imagen,
    USER(), NOW(), 'Dato Insertado', NEW.idArtista);

/* Actualizar */
CREATE trigger actualiza_Auditoria_Artista after UPDATE on Artista
for each row INSERT INTO Auditoria_Artista(Nombre, Apellidos, NombreArtistico, Genero, FechaNacimiento,
    FechaDefuncion, Pais, Instrumento, Estatura, Imagen,
    usuario, modificado, proceso, idArtista) values(NEW.Nombre, NEW.Apellidos, NEW.NombreArtistico, NEW.Genero, NEW.FechaNacimiento,
    NEW.FechaDefuncion, NEW.Pais, NEW.Instrumento, NEW.Estatura, NEW.Imagen,
    USER(), NOW(), 'Dato Actualizado', NEW.idArtista);

/* Eliminar */
CREATE trigger eliminar_Auditoria_Artista after DELETE on Artista
for each row INSERT INTO Auditoria_Artista(Nombre, Apellidos, NombreArtistico, Genero, FechaNacimiento,
    FechaDefuncion, Pais, Instrumento, Estatura, Imagen,
    usuario, modificado, proceso, idArtista) values(OLD.Nombre, OLD.Apellidos, OLD.NombreArtistico, OLD.Genero, OLD.FechaNacimiento,
    OLD.FechaDefuncion, OLD.Pais, OLD.Instrumento, OLD.Estatura, OLD.Imagen,
    USER(), NOW(), 'Dato Eliminado', OLD.idArtista);

/* -------------------------------------------  DISQUERA -------------------------------------------  */
CREATE table Auditoria_Disquera(id int primary key auto_increment,

    Nombre VARCHAR(45),
    Correo VARCHAR(45),
    Direccion VARCHAR(60),
    Telefono BIGINT,
    Fundacion DATE,
    Imagen VARCHAR(200),

    usuario varchar(45),
    modificado datetime,
    proceso varchar(45),
    idDisquera int);

/* Insertar */
CREATE trigger agregar_Auditoria_Disquera after INSERT on Disquera
for each row INSERT INTO Auditoria_Disquera(Nombre, Correo, Direccion, Telefono, Fundacion, Imagen,
    usuario, modificado, proceso, idDisquera) values(NEW.Nombre, NEW.Correo, NEW.Direccion, NEW.Telefono, NEW.Fundacion, NEW.Imagen,
    USER(), NOW(), 'Dato Insertado', NEW.idDisquera);

/* Actualizar */
CREATE trigger actualiza_Auditoria_Disquera after UPDATE on Disquera
for each row INSERT INTO Auditoria_Disquera(Nombre, Correo, Direccion, Telefono, Fundacion, Imagen,
    usuario, modificado, proceso, idDisquera) values(NEW.Nombre, NEW.Correo, NEW.Direccion, NEW.Telefono, NEW.Fundacion, NEW.Imagen,
    USER(), NOW(), 'Dato Actualizado', NEW.idDisquera);

/* Eliminar */
CREATE trigger eliminar_Auditoria_Disquera after DELETE on Disquera
for each row INSERT INTO Auditoria_Disquera(Nombre, Correo, Direccion, Telefono, Fundacion, Imagen,
    usuario, modificado, proceso, idDisquera) values(OLD.Nombre, OLD.Correo, OLD.Direccion, OLD.Telefono, OLD.Fundacion, OLD.Imagen,
    USER(), NOW(), 'Dato Eliminado', OLD.idDisquera);

/* -------------------------------------------  GRUPO -------------------------------------------  */
CREATE table Auditoria_Grupo(id int primary key auto_increment,

    idDisquera INT,
    Nombre VARCHAR(60),
    Origen VARCHAR(70),
    Inicio DATE,
    NoIntegrantes INT,
    Genero VARCHAR(45),
    Idioma VARCHAR(45),
    Imagen VARCHAR(200),

    usuario varchar(45),
    modificado datetime,
    proceso varchar(45),
    idGrupo int);

/* Insertar */
CREATE trigger agregar_Auditoria_Grupo AFTER INSERT ON Grupo
for each ROW INSERT INTO Auditoria_Grupo(idDisquera, Nombre, Origen, Inicio, NoIntegrantes, Genero, idioma, Imagen,
    usuario, modificado, proceso, idGrupo) VALUES(NEW.idDisquera, NEW.Nombre, NEW.Origen, NEW.Inicio, NEW.NoIntegrantes, NEW.Genero, NEW.Idioma, NEW.Imagen,
    USER(), NOW(), 'Dato Insertado', NEW.idGrupo);

/* Actualizar */
CREATE trigger actualiza_Auditoria_Grupo AFTER UPDATE ON Grupo
for each ROW INSERT INTO Auditoria_Grupo(idDisquera, Nombre, Origen, Inicio, NoIntegrantes, Genero, idioma, Imagen,
    usuario, modificado, proceso, idGrupo) VALUES(NEW.idDisquera, NEW.Nombre, NEW.Origen, NEW.Inicio, NEW.NoIntegrantes, NEW.Genero, NEW.Idioma, NEW.Imagen,
    USER(), NOW(), 'Dato Actualizado', NEW.idGrupo);

/* Eliminar */
CREATE trigger eliminar_Auditoria_Grupo AFTER DELETE ON Grupo
for each ROW INSERT INTO Auditoria_Grupo(idDisquera, Nombre, Origen, Inicio, NoIntegrantes, Genero, idioma, Imagen,
    usuario, modificado, proceso, idGrupo) VALUES(OLD.idDisquera, OLD.Nombre, OLD.Origen, OLD.Inicio, OLD.NoIntegrantes, OLD.Genero, OLD.Idioma, OLD.Imagen,
    USER(), NOW(), 'Dato Eliminado', OLD.idGrupo);

/* -------------------------------------------  ALBUM -------------------------------------------  */
CREATE table Auditoria_Album(id int primary key auto_increment,

    idGrupo INT,
    Nombre VARCHAR(45),
    NoCanciones INT,
    Duracion TIME,
    Lanzamiento DATE,
    NoVentas DOUBLE,
    Genero VARCHAR(45),
    Imagen VARCHAR(200),

    usuario varchar(45),
    modificado datetime,
    proceso varchar(45),
    idAlbum int);

/* Insertar */
CREATE trigger agregar_Auditoria_Album AFTER INSERT ON Album
for each ROW INSERT INTO Auditoria_Album(idGrupo, Nombre, NoCanciones, Duracion, Lanzamiento, NoVentas, Genero, Imagen,
    usuario, modificado, proceso, idAlbum) VALUES(NEW.idGrupo, NEW.Nombre, NEW.NoCanciones, NEW.Duracion, NEW.Lanzamiento, NEW.NoVentas, NEW.Genero, NEW.Imagen,
    USER(), NOW(), 'Dato Insertado', NEW.idAlbum);

/* Actualizar */
CREATE trigger actualiza_Auditoria_Album AFTER UPDATE ON Album
for each ROW INSERT INTO Auditoria_Album(idGrupo, Nombre, NoCanciones, Duracion, Lanzamiento, NoVentas, Genero, Imagen,
    usuario, modificado, proceso, idAlbum) VALUES(NEW.idGrupo, NEW.Nombre, NEW.NoCanciones, NEW.Duracion, NEW.Lanzamiento, NEW.NoVentas, NEW.Genero, NEW.Imagen,
    USER(), NOW(), 'Dato Actualizado', NEW.idAlbum);

/* Eliminar */
CREATE trigger eliminar_Auditoria_Album AFTER DELETE ON Album
for each ROW INSERT INTO Auditoria_Album(idGrupo, Nombre, NoCanciones, Duracion, Lanzamiento, NoVentas, Genero, Imagen,
    usuario, modificado, proceso, idAlbum) VALUES(OLD.idGrupo, OLD.Nombre, OLD.NoCanciones, OLD.Duracion, OLD.Lanzamiento, OLD.NoVentas, OLD.Genero, OLD.Imagen,
    USER(), NOW(), 'Dato Eliminado', OLD.idAlbum);

/* -------------------------------------------  CANCIONES -------------------------------------------  */
CREATE table Auditoria_Cancion(id int primary key auto_increment,

    IdGrupo INT,
    IdInterprete INT,
    IdAlbum INT,
    Nombre VARCHAR(45),
    Duracion TIME,
    Lanzamiento DATE,
    Idioma VARCHAR(45),
    Genero VARCHAR(45),

    usuario varchar(45),
    modificado datetime,
    proceso varchar(45),
    idCancion int);

/* Insertar */
CREATE trigger agregar_Auditoria_Cancion AFTER INSERT ON Canciones
for each ROW INSERT INTO Auditoria_Cancion(idGrupo, idInterprete, idAlbum, Nombre,
    Duracion, Lanzamiento, Idioma, Genero,
    usuario, modificado, proceso, idCancion) VALUES(NEW.idGrupo, NEW.idInterprete, NEW.idAlbum, NEW.Nombre,
    NEW.Duracion, NEW.Lanzamiento, NEW.Idioma, NEW.Genero,
    USER(), NOW(), 'Dato Insertado', NEW.idCancion);

/* Actualizar */
CREATE trigger actualiza_Auditoria_Cancion AFTER UPDATE ON Canciones
for each ROW INSERT INTO Auditoria_Cancion(idGrupo, idInterprete, idAlbum, Nombre,
    Duracion, Lanzamiento, Idioma, Genero,
    usuario, modificado, proceso, idCancion) VALUES(NEW.idGrupo, NEW.idInterprete, NEW.idAlbum, NEW.Nombre,
    NEW.Duracion, NEW.Lanzamiento, NEW.Idioma, NEW.Genero,
    USER(), NOW(), 'Dato Actualizado', NEW.idCancion);

/* Eliminar */
CREATE trigger eliminar_Auditoria_Cancion AFTER DELETE ON Canciones
for each ROW INSERT INTO Auditoria_Cancion(idGrupo, idInterprete, idAlbum, Nombre,
    Duracion, Lanzamiento, Idioma, Genero,
    usuario, modificado, proceso, idCancion) VALUES(OLD.idGrupo, OLD.idInterprete, OLD.idAlbum, OLD.Nombre,
    OLD.Duracion, OLD.Lanzamiento, OLD.Idioma, OLD.Genero,
    USER(), NOW(), 'Dato Eliminado', OLD.idCancion);

/* -------------------------------------------  USUARIO -------------------------------------------  */
CREATE table Auditoria_Usuario(
    id int primary key auto_increment,

    nombreAnt varchar(45),
    paternoAnt varchar(45),
    maternoAnt varchar(45),
    fechaNacimientoAnt date,
    celularAnt bigint,
    sexoAnt char,
    correoAnt varchar(45),
    usernameAnt varchar(45),
    passwordAnt varchar(45),

    nombreNew varchar(45),
    paternoNew varchar(45),
    maternoNew varchar(45),
    fechaNacimientoNew date,
    celularNew bigint,
    sexoNew char,
    correoNew varchar(45),
    usernameNew varchar(45),
    passwordNew varchar(45),

    usuario varchar(45),
    modificado datetime,
    proceso varchar(45),
    idUsuario int);

/* Insertar */
CREATE trigger Agregar_Auditoria_Usuario AFTER INSERT ON Usuario
for each ROW INSERT INTO Auditoria_Usuario(nombreNew, paternoNew, maternoNew, fechaNacimientoNew,
    celularNew, sexoNew, correoNew, usernameNew, passwordNew,
    usuario, modificado, proceso, idUsuario) VALUES(NEW.nombre, NEW.paterno, NEW.materno, NEW.fechaNacimiento,
    NEW.celular, NEW.sexo, NEW.correo, NEW.username, NEW.password,
    USER(), NOW(), 'Dato Insertado', NEW.idUsuario);

/* Actualizar */
CREATE trigger Actualiza_Auditoria_Usuario AFTER UPDATE ON Usuario
for each ROW INSERT INTO Auditoria_Usuario(nombreAnt, paternoAnt, maternoAnt, fechaNacimientoAnt,
    celularAnt, sexoAnt, correoAnt, usernameAnt, passwordAnt,

    nombreNew, paternoNew, maternoNew, fechaNacimientoNew,
    celularNew, sexoNew, correoNew, usernameNew, passwordNew,
    usuario, modificado, proceso, idUsuario) VALUES(OLD.nombre, OLD.paterno, OLD.materno, OLD.fechaNacimiento,
    OLD.celular, OLD.sexo, OLD.correo, OLD.username, OLD.password,

    NEW.nombre, NEW.paterno, NEW.materno, NEW.fechaNacimiento,
    NEW.celular, NEW.sexo, NEW.correo, NEW.username, NEW.password,
    USER(), NOW(), 'Dato Actualizado', NEW.idUsuario);

/* Eliminar */
CREATE trigger Elimina_Auditoria_Usuario AFTER DELETE ON Usuario
for each ROW INSERT INTO Auditoria_Usuario(nombreAnt, paternoAnt, maternoAnt, fechaNacimientoAnt,
    celularAnt, sexoAnt, correoAnt, usernameAnt, passwordAnt,
    usuario, modificado, proceso, idUsuario) VALUES(OLD.nombre, OLD.paterno, OLD.materno, OLD.fechaNacimiento,
    OLD.celular, OLD.sexo, OLD.correo, OLD.username, OLD.password,
    USER(), NOW(), 'Dato Eliminado', OLD.idUsuario);

SHOW tables;

/* ------------------------------------------- INNER JOIN ------------------------------------------- */
/* Artista */
SELECT idArtista,
Nombre,
Apellidos,
NombreArtistico,
IF(Genero = 'H', 'Hombre', 'Mujer') AS Genero,
    DATE_FORMAT(FechaNacimiento, "%d / %b / %Y") AS FechaNacimiento,
    DATE_FORMAT(FechaDefuncion, "%d / %b / %Y") AS Fallecimiento,
    TIMESTAMPDIFF(Year, FechaNacimiento, (IFNULL(FechaDefuncion, NOW()))) AS Edad,
    Pais,
    Instrumento,
    TRUNCATE(Estatura, 2) AS Estatura,
    Imagen,
    IF(IFNULL(FechaDefuncion, 'VIVO') = 'Vivo', 'Vivo', 'Muerto') AS Estado FROM Artista;

/* Disquera */
SELECT idDisquera,
Nombre,
Correo,
Direccion,
CONCAT("(", LEFT(Telefono, 3), ")", MID(Telefono, 4, 3), "-", MID(Telefono, 7, 4)) AS Telefono,
    DATE_FORMAT(Fundacion, "%d - %M - %Y") AS Fundacion,
    Imagen FROM Disquera;

/* ------------- Album ------------- */
SELECT
album.idAlbum,
    grupo.Nombre as Grupo,
    album.Nombre as Nombre,
    album.noCanciones as NoCanciones,
    album.duracion as Duracion,
    DATE_FORMAT(album.lanzamiento, "%d / %b / %Y") as Lanzamiento,
    album.noVentas as NoVentas,
    album.Genero,
    album.Imagen
FROM album
INNER JOIN grupo
ON grupo.idGrupo = album.idGrupo;

/* ------------- Canciones ------------- */
SELECT
canciones.idCancion,
    canciones.Nombre as Cancion,
    artista.NombreArtistico as Interprete,
    grupo.Nombre as Grupo,
    album.Nombre as Album,
    canciones.Duracion,
    YEAR(canciones.Lanzamiento) AS Lanzamiento,
    canciones.Idioma,
    canciones.Genero
FROM canciones
INNER JOIN artista
On canciones.idInterprete = artista.idArtista
INNER JOIN Grupo
ON canciones.idGrupo = Grupo.idGrupo
INNER JOIN Album
ON canciones.idAlbum = album.idAlbum;

/* ------------- Grupo ------------- */
SELECT grupo.idGrupo as idGrupo,
    Disquera.Nombre as Disquera,
    grupo.Nombre as Nombre,
    Origen,
    YEAR(grupo.inicio) AS Inicio,
    grupo.noIntegrantes as NoIntegrantes,
    grupo.Genero,
    grupo.Idioma,
    grupo.Imagen FROM grupo INNER JOIN disquera ON grupo.idDisquera = disquera.idDisquera;

/* ------------------------------------------- AUDITORIAS ------------------------------------------- */
/* ARTISTA */
SELECT
id,
idArtista,
Nombre,
Apellidos,
NombreArtistico AS Artistico,
Genero,
DATE_FORMAT(FechaNacimiento, "%d / %M / %Y") AS Nacimiento,
    DATE_FORMAT(FechaDefuncion, "%d / %M / %Y") AS Defuncion,
    Pais,
    Instrumento,
    TRUNCATE(Estatura, 2) AS Estatura,
    Imagen,
    Usuario,
    DATE_FORMAT(Modificado, "%d / %b / %Y - %r") AS Modificado,
    Proceso FROM Auditoria_Artista;

/* DISQUERA */
SELECT id,
Nombre,
Correo,
Direccion,
CONCAT("(", LEFT(Telefono, 3), ") ", MID(Telefono, 4, 3), "-", MID(Telefono, 7, 4)) AS Telefono,
    DATE_FORMAT(Fundacion, "%d / %b / %Y") AS Fundacion,
    Imagen,
    Usuario,
    DATE_FORMAT(Modificado, "%d / %b / %Y - %r") AS Modificado,
    Proceso,
    idDisquera FROM Auditoria_Disquera;

/* Auditoria Album */
SELECT Auditoria_Album.id,
    Auditoria_Album.idGrupo,
    Grupo.Nombre as Grupo,
    Auditoria_Album.Nombre,
    Auditoria_Album.NoCanciones,
    Auditoria_Album.Duracion,
    DATE_FORMAT(Auditoria_Album.lanzamiento, "%d / %b / %Y") as Lanzamiento,
    Auditoria_Album.NoVentas,
    Auditoria_Album.Genero,
    Auditoria_Album.Imagen,
    Auditoria_Album.usuario,
    DATE_FORMAT(Auditoria_Album.Modificado, "%d / %b / %Y - %r") AS Modificado,
    Auditoria_Album.proceso,
    Auditoria_Album.idAlbum FROM Auditoria_Album,
    grupo WHERE Auditoria_Album.idGrupo = grupo.idGrupo;

/* AUDITORIA GRUPO */
SELECT auditoria_grupo.id,
    Disquera.Nombre AS idDisquera,
    auditoria_grupo.Nombre,
    auditoria_grupo.Origen,
    DATE_FORMAT(auditoria_grupo.Inicio, "%d / %b / %Y") AS Inicio,
    auditoria_grupo.NoIntegrantes,
    auditoria_grupo.Genero,
    auditoria_grupo.Idioma,
    auditoria_grupo.Imagen,
    auditoria_grupo.usuario,
    DATE_FORMAT(auditoria_grupo.Modificado, "%d / %b / %Y - %r") AS Modificado,
    auditoria_grupo.proceso,
    auditoria_grupo.idGrupo FROM auditoria_grupo,
    Disquera WHERE auditoria_grupo.idDisquera = Disquera.idDisquera;

/* AUDITORIA CANCIONES */
SELECT Auditoria_Cancion.id,
    Grupo.Nombre AS idGrupo,
    Artista.NombreArtistico AS idInterprete,
    Album.Nombre AS idAlbum,
    Auditoria_Cancion.Nombre,
    Auditoria_Cancion.Duracion,
    Auditoria_Cancion.Lanzamiento,
    Auditoria_Cancion.Idioma,
    Auditoria_Cancion.Genero,
    Auditoria_Cancion.usuario,
    Auditoria_Cancion.modificado,
    Auditoria_Cancion.proceso,
    Auditoria_Cancion.idCancion FROM auditoria_Cancion,
    Artista,
    Grupo,
    Album WHERE Auditoria_Cancion.idInterprete = artista.idArtista AND Auditoria_Cancion.idGrupo = Grupo.idGrupo AND Auditoria_Cancion.idAlbum = album.idAlbum;
