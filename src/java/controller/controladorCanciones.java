/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Qr.QRCodeUtil;
import com.google.zxing.WriterException;
import config.conexionBD;
import entidades.Canciones;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SALA 2-14
 */
public class controladorCanciones {

    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET

    //Metodo para las vistas - METODO PARA OBTENER VISTAS
    @RequestMapping(value = "altaCancion.htm", method = RequestMethod.GET)
    public ModelAndView VistaAgregar() {
        //PARA LISTAR DATOS EN EL SELECT
        //Album
        String sql = "SELECT * from Album";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("ListaAlbum", datos);

        //GRUPO
        String sql2 = "SELECT * from Grupo";
        datos = this.jdbc.queryForList(sql2);
        mav.addObject("ListaGrupo", datos);

        //INTERPRETE
        String sql3 = "SELECT * from Artista";
        datos = this.jdbc.queryForList(sql3);
        mav.addObject("ListaArtista", datos);

        mav.addObject(new Canciones());
        mav.setViewName("altaCancion");
        return mav;
    }

    //METODO PARA AGREGAR
    @RequestMapping(value = "altaCancion.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Canciones c) {
        String sql = "INSERT into Canciones(idGrupo, idInterprete, idAlbum, Nombre, Duracion, Lanzamiento, Idioma, Genero) values (?,?,?,?,?,?,?,?)";
        this.jdbc.update(sql, c.getIdGrupo(), c.getIdInterprete(), c.getIdAlbum(), c.getNombre(), c.getDuracion(), c.getLanzamiento(), c.getIdioma(), c.getGenero());
        return new ModelAndView("redirect:/altaCancion.htm");
    }

    //METODO PARA LISTA
    int idCancion;
    List datos;

    @RequestMapping("listaCancion.htm")
    public ModelAndView Listar() {
        //String sql = "SELECT * from Canciones";
        String sql = "SELECT \n"
                + "canciones.idCancion,\n"
                + "canciones.Nombre as Cancion,\n"
                + "artista.NombreArtistico as Interprete,\n"
                + "grupo.Nombre as Grupo,\n"
                + "album.Nombre as Album,\n"
                + "canciones.Duracion,\n"
                + "YEAR(canciones.Lanzamiento) AS Lanzamiento,\n"
                + "canciones.Idioma,\n"
                + "canciones.Genero \n"
                + "FROM canciones \n"
                + "INNER JOIN artista \n"
                + "On canciones.idInterprete=artista.idArtista \n"
                + "INNER JOIN Grupo \n"
                + "ON canciones.idGrupo=Grupo.idGrupo \n"
                + "INNER JOIN Album \n"
                + "ON canciones.idAlbum=album.idAlbum";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("listaCancion");
        return mav;
    }

    @RequestMapping(value = "editarCancion.htm", method = RequestMethod.GET)
    public ModelAndView vistaEditar(HttpServletRequest request) {
        idCancion = Integer.parseInt(request.getParameter("idCancion"));
        String sql = "SELECT * from Canciones WHERE idCancion=" + idCancion;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);

        //Album
        String sql1 = "SELECT * from Album";
        datos = this.jdbc.queryForList(sql1);
        mav.addObject("ListaAlbum", datos);

        //GRUPO
        String sql2 = "SELECT * from Grupo";
        datos = this.jdbc.queryForList(sql2);
        mav.addObject("ListaGrupo", datos);

        //INTERPRETE
        String sql3 = "SELECT * from Artista";
        datos = this.jdbc.queryForList(sql3);
        mav.addObject("ListaArtista", datos);

        //CANCIONES
        String sql4 = "SELECT\n"
                + "canciones.idCancion as Id,\n"
                + "artista.NombreArtistico as Interprete,\n"
                + "grupo.Nombre as Grupo,\n"
                + "album.Nombre as Album\n"
                + "FROM Canciones, Artista, Grupo, Album\n"
                + "WHERE canciones.idInterprete = artista.idArtista\n"
                + "AND canciones.idGrupo = Grupo.idGrupo\n"
                + "AND canciones.idAlbum = album.idAlbum\n"
                + "AND idCancion=" + idCancion;
        datos = this.jdbc.queryForList(sql4);
        mav.addObject("ListaCancion", datos);

        mav.setViewName("editarCancion");
        return mav;
    }

    //METODO PARA EDITAR
    @RequestMapping(value = "editarCancion.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Canciones c) {
        String sql = "UPDATE Canciones SET idGrupo=?, idInterprete=?, idAlbum=?, Nombre=?, Duracion=?, Lanzamiento=?, Idioma=?, Genero=? WHERE idCancion=?";
        this.jdbc.update(sql, c.getIdGrupo(), c.getIdInterprete(), c.getIdAlbum(), c.getNombre(), c.getDuracion(), c.getLanzamiento(), c.getIdioma(), c.getGenero(), idCancion);
        return new ModelAndView("redirect:/listaCancion.htm");
    }

    //METODO PARA ELIMINAR
    @RequestMapping(value = "eliminarCancion.htm")
    public ModelAndView Eliminar(HttpServletRequest request) {
        idCancion = Integer.parseInt(request.getParameter("idCancion"));
        String sql = "DELETE from Canciones WHERE idCancion=" + idCancion;
        this.jdbc.update(sql);
        return new ModelAndView("redirect:/listaCancion.htm");
    }

    //QR
    @RequestMapping(value = "GeneraQRCancion.htm", method = RequestMethod.GET)
    public ModelAndView qr(HttpServletRequest request) throws WriterException, FileNotFoundException, IOException, InterruptedException {
        //Se Extrae la imagen desde la ubicacion desde el disco local "C:"
        File fichero = new File("C:\\Users\\raul0\\Documents\\NetBeansProjects\\Spring\\Musica Servidor\\MusicaSpring\\web\\img\\QR.png");

        //PARA EXTRAER LOS DATOS DE LA CANCION
        idCancion = Integer.parseInt(request.getParameter("idCancion"));
        String sql = "SELECT *, DATE_FORMAT(Lanzamiento, \"%d / %M / %Y\") AS Lanzamiento FROM Canciones WHERE idCancion=" + idCancion;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);

        //CANCIONES
        String sql1 = "SELECT \n"
                + "canciones.idCancion as Id,\n"
                + "canciones.Nombre as Cancion,\n"
                + "artista.NombreArtistico as Interprete,\n"
                + "grupo.Nombre as Grupo,\n"
                + "album.Nombre as Album,\n"
                + "canciones.Duracion,\n"
                + "YEAR(canciones.Lanzamiento) AS Lanzamiento,\n"
                + "canciones.Idioma,\n"
                + "canciones.Genero \n"
                + "FROM canciones \n"
                + "INNER JOIN artista \n"
                + "On canciones.idInterprete=artista.idArtista \n"
                + "INNER JOIN Grupo \n"
                + "ON canciones.idGrupo=Grupo.idGrupo \n"
                + "INNER JOIN Album \n"
                + "ON canciones.idAlbum=album.idAlbum\n"
                + "AND idCancion=" + idCancion;
        datos = this.jdbc.queryForList(sql1);
        mav.addObject("ListaCancion", datos);

        if (fichero.delete()) {
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero no pudó ser borrado");
        }

        String formato = "png";
        QRCodeUtil generaQR = new QRCodeUtil();
        BufferedImage imagen = generaQR.crearQR("http://192.168.0.9:8080/Musica/QrVistaCancion.htm?idCancion=" + idCancion, 300, 300);

        try {
            ImageIO.write(imagen, formato, fichero);
            System.out.println("Prueba " + fichero.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error de escritura");
        }
        System.out.println("Quedo " + fichero.getAbsolutePath());
        Thread.sleep(2000);
        mav.setViewName("GeneraQRCancion");
        return mav;
    }

    @RequestMapping(value = "QrVistaCancion.htm", method = RequestMethod.GET)
    public ModelAndView vistaqQR(HttpServletRequest request) {
        //CANCION
        idCancion = Integer.parseInt(request.getParameter("idCancion"));
        String sql = "SELECT *, DATE_FORMAT(Lanzamiento, \"%d / %M / %Y\") AS Lanzamiento from Canciones WHERE idCancion=" + idCancion;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("QrVistaCancion");

        //CANCIONES
        String sql1 = "SELECT \n"
                + "canciones.idCancion as Id,\n"
                + "canciones.Nombre as Cancion,\n"
                + "artista.NombreArtistico as Interprete,\n"
                + "grupo.Nombre as Grupo,\n"
                + "album.Nombre as Album,\n"
                + "canciones.Duracion,\n"
                + "YEAR(canciones.Lanzamiento) AS Lanzamiento,\n"
                + "canciones.Idioma,\n"
                + "canciones.Genero \n"
                + "FROM canciones \n"
                + "INNER JOIN artista \n"
                + "On canciones.idInterprete=artista.idArtista \n"
                + "INNER JOIN Grupo \n"
                + "ON canciones.idGrupo=Grupo.idGrupo \n"
                + "INNER JOIN Album \n"
                + "ON canciones.idAlbum=album.idAlbum\n"
                + "AND idCancion=" + idCancion;
        datos = this.jdbc.queryForList(sql1);
        mav.addObject("ListaCancion", datos);

        return mav;
    }
}
