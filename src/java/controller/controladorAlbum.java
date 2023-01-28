/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Qr.QRCodeUtil;
import com.google.zxing.WriterException;
import config.conexionBD;
import entidades.Album;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raúl
 */
@Controller
public class controladorAlbum {

    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET

    //Metodo para las vistas - METODO PARA OBTENER VISTAS
    @RequestMapping(value = "altaAlbum.htm", method = RequestMethod.GET)
    public ModelAndView VistaAgregar() {
        //PARA LISTAR DATOS EN EL SELECT
        String sql = "SELECT * from Grupo";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("ListaGrupo", datos);

        mav.addObject(new Album());
        mav.setViewName("altaAlbum");
        return mav;
    }

    //METODO PARA AGREGAR
    @RequestMapping(value = "altaAlbum.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Album a) {
        String sql = "INSERT into Album(idGrupo, Nombre, NoCanciones, Duracion, Lanzamiento, NoVentas, Genero, Imagen) values (?,?,?,?,?,?,?,?)";
        this.jdbc.update(sql, a.getIdGrupo(), a.getNombre(), a.getNoCanciones(), a.getDuracion(), a.getLanzamiento(), a.getNoVentas(), a.getGenero(), a.getImagen());
        return new ModelAndView("redirect:/altaAlbum.htm");
    }

    //METODO PARA LISTA
    int idAlbum;
    List datos;

    @RequestMapping("listaAlbum.htm")
    public ModelAndView Listar() {
        //String sql = "SELECT * from Album";
        String sql = "SELECT \n"
                + "album.idAlbum,\n"
                + "grupo.Nombre as Grupo,\n"
                + "album.Nombre as Nombre,\n"
                + "album.noCanciones as NoCanciones,\n"
                + "album.duracion as Duracion,\n"
                + "DATE_FORMAT(album.lanzamiento, \"%d / %b / %Y\") as Lanzamiento,\n"
                + "album.noVentas as NoVentas,\n"
                + "album.Genero,\n"
                + "album.Imagen \n"
                + "FROM album \n"
                + "INNER JOIN grupo \n"
                + "ON grupo.idGrupo=album.idGrupo";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);

        mav.setViewName("listaAlbum");
        return mav;
    }

    @RequestMapping("PDFAlbum.htm")
    public ModelAndView PDF() {
        //String sql = "SELECT * from Album";
        String sql = "SELECT \n"
                + "album.idAlbum,\n"
                + "grupo.Nombre as Grupo,\n"
                + "album.Nombre as Nombre,\n"
                + "album.noCanciones as NoCanciones,\n"
                + "album.duracion as Duracion,\n"
                + "DATE_FORMAT(album.lanzamiento, \"%d / %b / %Y\") as Lanzamiento,\n"
                + "album.noVentas as NoVentas,\n"
                + "album.Genero,\n"
                + "album.Imagen \n"
                + "FROM album \n"
                + "INNER JOIN grupo \n"
                + "ON grupo.idGrupo=album.idGrupo";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);

        mav.setViewName("PDFAlbum");
        return mav;
    }

    @RequestMapping(value = "editarAlbum.htm", method = RequestMethod.GET)
    public ModelAndView vistaEditar(HttpServletRequest request) {
        idAlbum = Integer.parseInt(request.getParameter("idAlbum"));
        String sql = "SELECT * from Album WHERE idAlbum=" + idAlbum;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);

        //GRUPO
        String sql1 = "SELECT * from Grupo";
        datos = this.jdbc.queryForList(sql1);
        mav.addObject("ListaGrupo", datos);

        //ALBUM
        String sql2 = "SELECT \n"
                + "grupo.Nombre as Grupo\n"
                + "FROM Album, Grupo\n"
                + "WHERE grupo.idGrupo = album.idGrupo\n"
                + "AND idAlbum=" + idAlbum;
        datos = this.jdbc.queryForList(sql2);
        mav.addObject("ListaAlbum", datos);

        mav.setViewName("editarAlbum");
        return mav;
    }

    //METODO PARA EDITAR
    @RequestMapping(value = "editarAlbum.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Album a) {
        String sql = "UPDATE Album SET idGrupo=?, Nombre=?, NoCanciones=?, Duracion=?, Lanzamiento=?, NoVentas=?, Genero=?, Imagen=? WHERE idAlbum=?";
        this.jdbc.update(sql, a.getIdGrupo(), a.getNombre(), a.getNoCanciones(), a.getDuracion(), a.getLanzamiento(), a.getNoVentas(), a.getGenero(), a.getImagen(), idAlbum);
        return new ModelAndView("redirect:/listaAlbum.htm");
    }

    //METODO PARA ELIMINAR
    @RequestMapping(value = "eliminarAlbum.htm")
    public ModelAndView Eliminar(HttpServletRequest request) {
        idAlbum = Integer.parseInt(request.getParameter("idAlbum"));
        String sql = "DELETE from Album WHERE idAlbum=" + idAlbum;
        this.jdbc.update(sql);
        return new ModelAndView("redirect:/listaAlbum.htm");
    }

    //QR
    @RequestMapping(value = "GeneraQRAlbum.htm", method = RequestMethod.GET)
    public ModelAndView qr(HttpServletRequest request) throws WriterException, FileNotFoundException, IOException, InterruptedException {
        //Se Extrae la imagen desde la ubicacion desde el disco local "C:"
        File qr = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\Diseño de Sistemas\\Musica\\MusicaSpring\\web\\img\\QR.png");

        //Se realiza una impresion de datos del registro
        idAlbum = Integer.parseInt(request.getParameter("idAlbum"));
        String sql = "SELECT *, DATE_FORMAT(album.lanzamiento, \"%d / %M / %Y\") as Lanzamiento from Album WHERE idAlbum=" + idAlbum;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);

        //ALBUM
        String sql2 = "SELECT \n"
                + "album.idAlbum,\n"
                + "grupo.Nombre as Grupo,\n"
                + "album.Nombre as Nombre,\n"
                + "album.noCanciones as NoCanciones,\n"
                + "album.duracion as Duracion,\n"
                + "DATE_FORMAT(album.lanzamiento, \"%d / %b / %Y\") as Lanzamiento,\n"
                + "album.noVentas as NoVentas,\n"
                + "album.Genero,\n"
                + "album.Imagen \n"
                + "FROM album \n"
                + "INNER JOIN grupo \n"
                + "ON grupo.idGrupo=album.idGrupo\n"
                + "AND idAlbum=" + idAlbum;
        datos = this.jdbc.queryForList(sql2);
        mav.addObject("ListaAlbum", datos);

        String formato = "png";
        QRCodeUtil generaQR = new QRCodeUtil();
        BufferedImage imagen = generaQR.crearQR("http://192.168.0.15:8080/MusicaSpring/QrVistaAlbum.htm?idAlbum=" + idAlbum, 300, 300);

        try {
            ImageIO.write(imagen, formato, qr);
            System.out.println("Prueba " + qr.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
        System.out.println("Quedo " + qr.getAbsolutePath());
        Thread.sleep(2000);
        mav.setViewName("GeneraQRAlbum");
        return mav;
    }

    @RequestMapping(value = "QrVistaAlbum.htm", method = RequestMethod.GET)
    public ModelAndView vistaqQR(HttpServletRequest request) {
        idAlbum = Integer.parseInt(request.getParameter("idAlbum"));
        String sql = "SELECT *, DATE_FORMAT(album.lanzamiento, \"%d / %M / %Y\") as Lanzamiento from Album WHERE idAlbum=" + idAlbum;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);

        //ALBUM
        String sql2 = "SELECT \n"
                + "album.idAlbum,\n"
                + "grupo.Nombre as Grupo,\n"
                + "album.Nombre as Nombre,\n"
                + "album.noCanciones as NoCanciones,\n"
                + "album.duracion as Duracion,\n"
                + "DATE_FORMAT(album.lanzamiento, \"%d / %M / %Y\") as Lanzamiento,\n"
                + "album.noVentas as NoVentas,\n"
                + "album.Genero,\n"
                + "album.Imagen \n"
                + "FROM album \n"
                + "INNER JOIN grupo \n"
                + "ON grupo.idGrupo=album.idGrupo\n"
                + "AND idAlbum=" + idAlbum;
        datos = this.jdbc.queryForList(sql2);
        mav.addObject("ListaAlbum", datos);

        mav.setViewName("QrVistaAlbum");
        return mav;
    }
}
