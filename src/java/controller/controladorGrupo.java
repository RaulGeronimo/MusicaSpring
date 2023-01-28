/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Qr.QRCodeUtil;
import com.google.zxing.WriterException;
import config.conexionBD;
import entidades.Grupo;
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
 * @author Lemus
 */
public class controladorGrupo {

    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET

    //Metodo para las vistas - METODO PARA OBTENER VISTAS
    @RequestMapping(value = "altaGrupo.htm", method = RequestMethod.GET)
    public ModelAndView VistaAgregar() {
        //PARA LISTAR DATOS EN EL SELECT
        String sql = "SELECT * from Disquera";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("ListaDisquera", datos);

        mav.addObject(new Grupo());
        mav.setViewName("altaGrupo");
        return mav;
    }

    //METODO PARA AGREGAR
    @RequestMapping(value = "altaGrupo.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Grupo g) {
        String sql = "INSERT into Grupo(idDisquera, Nombre, Origen, Inicio, NoIntegrantes, Genero, idioma, Imagen) values (?,?,?,?,?,?,?,?)";
        this.jdbc.update(sql, g.getIdDisquera(), g.getNombre(), g.getOrigen(), g.getInicio(), g.getNoIntegrantes(), g.getGenero(), g.getIdioma(), g.getImagen());
        return new ModelAndView("redirect:/altaGrupo.htm");
    }

    //METODO PARA LISTA
    int idGrupo;
    List datos;

    @RequestMapping("listaGrupo.htm")
    public ModelAndView Listar() {
        //String sql = "SELECT * from Grupo";
        String sql = "SELECT \n"
                + "grupo.idGrupo as idGrupo, \n"
                + "Disquera.Nombre as Disquera, \n"
                + "grupo.Nombre as Nombre, \n"
                + "Origen,\n"
                + "YEAR(grupo.inicio) AS Inicio, \n"
                + "grupo.noIntegrantes as NoIntegrantes, \n"
                + "grupo.Genero, \n"
                + "grupo.Idioma,\n"
                + "grupo.Imagen\n"
                + "FROM grupo\n"
                + "INNER JOIN disquera\n"
                + "ON grupo.idDisquera = disquera.idDisquera";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("listaGrupo");
        return mav;
    }

    @RequestMapping("PDFGrupo.htm")
    public ModelAndView PDF() {
        //String sql = "SELECT * from Grupo";
        String sql = "SELECT \n"
                + "grupo.idGrupo as idGrupo, \n"
                + "Disquera.Nombre as Disquera, \n"
                + "grupo.Nombre as Nombre, \n"
                + "Origen,\n"
                + "YEAR(grupo.inicio) AS Inicio, \n"
                + "grupo.noIntegrantes as NoIntegrantes, \n"
                + "grupo.Genero, \n"
                + "grupo.Idioma,\n"
                + "grupo.Imagen\n"
                + "FROM grupo\n"
                + "INNER JOIN disquera\n"
                + "ON grupo.idDisquera = disquera.idDisquera";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("PDFGrupo");
        return mav;
    }

    @RequestMapping(value = "editarGrupo.htm", method = RequestMethod.GET)
    public ModelAndView vistaEditar(HttpServletRequest request) {
        idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
        String sql = "SELECT * from Grupo WHERE idGrupo=" + idGrupo;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("editarGrupo");

        //PARA LISTAR DATOS EN EL SELECT
        String sql1 = "SELECT * from Disquera";
        datos = this.jdbc.queryForList(sql1);
        mav.addObject("ListaDisquera", datos);

        //GRUPO
        String sql2 = "SELECT grupo.idGrupo as Id,\n"
                + "Disquera.Nombre as Disquera\n"
                + "FROM Grupo, Disquera\n"
                + "WHERE grupo.idDisquera = disquera.idDisquera\n"
                + "AND idGrupo=" + idGrupo;
        datos = this.jdbc.queryForList(sql2);
        mav.addObject("ListaGrupo", datos);
        return mav;
    }

    //METODO PARA EDITAR
    @RequestMapping(value = "editarGrupo.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Grupo g) {
        String sql = "UPDATE Grupo SET idDisquera=?, Nombre=?, Origen=?, Inicio=?, NoIntegrantes=?, Genero=?, idioma=?, Imagen=? WHERE idGrupo=?";
        this.jdbc.update(sql, g.getIdDisquera(), g.getNombre(), g.getOrigen(), g.getInicio(), g.getNoIntegrantes(), g.getGenero(), g.getIdioma(), g.getImagen(), idGrupo);
        return new ModelAndView("redirect:/listaGrupo.htm");
    }

    //METODO PARA ELIMINAR
    @RequestMapping(value = "eliminarGrupo.htm")
    public ModelAndView Eliminar(HttpServletRequest request) {
        idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
        String sql = "DELETE from Grupo WHERE idGrupo=" + idGrupo;
        this.jdbc.update(sql);
        return new ModelAndView("redirect:/listaGrupo.htm");
    }

    //QR
    @RequestMapping(value = "GeneraQRGrupo.htm", method = RequestMethod.GET)
    public ModelAndView qr(HttpServletRequest request) throws WriterException, FileNotFoundException, IOException, InterruptedException {
        //Se Extrae la imagen desde la ubicacion desde el disco local "C:"
        File fichero = new File("C:\\Users\\hp\\Desktop\\Musica Servidor\\MusicaSpring\\web\\img\\QR.png");

        //GRUPO
        idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
        String sql = "SELECT \n"
                + "grupo.idGrupo as idGrupo, \n"
                + "Disquera.Nombre as Disquera, \n"
                + "grupo.Nombre as Nombre, \n"
                + "Origen,\n"
                + "DATE_FORMAT(grupo.Inicio, \"%d / %M / %Y\") AS Inicio, \n"
                + "grupo.noIntegrantes as NoIntegrantes, \n"
                + "grupo.Genero, \n"
                + "grupo.Idioma,\n"
                + "grupo.Imagen\n"
                + "FROM grupo\n"
                + "INNER JOIN disquera\n"
                + "ON grupo.idDisquera = disquera.idDisquera WHERE idGrupo=" + idGrupo;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);

        //GRUPO
        String sql2 = "SELECT grupo.idGrupo as Id,\n"
                + "Disquera.Nombre as Disquera\n"
                + "FROM Grupo, Disquera\n"
                + "WHERE grupo.idDisquera = disquera.idDisquera\n"
                + "AND idGrupo=" + idGrupo;
        datos = this.jdbc.queryForList(sql2);
        mav.addObject("ListaGrupo", datos);

        if (fichero.delete()) {
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero no pudó ser borrado");
        }

        String formato = "png";
        QRCodeUtil generaQR = new QRCodeUtil();
        BufferedImage imagen = generaQR.crearQR("http://192.168.0.9:8080/Musica/QrVistaGrupo.htm?idGrupo=" + idGrupo, 300, 300);

        try {
            ImageIO.write(imagen, formato, fichero);
            System.out.println("Prueba " + fichero.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error de escritura");
        }
        System.out.println("Quedo " + fichero.getAbsolutePath());
        Thread.sleep(2000);
        mav.setViewName("GeneraQRGrupo");
        return mav;
    }

    @RequestMapping(value = "QrVistaGrupo.htm", method = RequestMethod.GET)
    public ModelAndView vistaqQR(HttpServletRequest request) {
        //GRUPO
        idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
        String sql = "SELECT \n"
                + "grupo.idGrupo as idGrupo, \n"
                + "Disquera.Nombre as Disquera, \n"
                + "grupo.Nombre as Nombre, \n"
                + "Origen,\n"
                + "DATE_FORMAT(grupo.Inicio, \"%d / %M / %Y\") AS Inicio, \n"
                + "grupo.noIntegrantes as NoIntegrantes, \n"
                + "grupo.Genero, \n"
                + "grupo.Idioma,\n"
                + "grupo.Imagen\n"
                + "FROM grupo\n"
                + "INNER JOIN disquera\n"
                + "ON grupo.idDisquera = disquera.idDisquera WHERE idGrupo=" + idGrupo;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);

        //GRUPO
        String sql2 = "SELECT grupo.idGrupo as Id,\n"
                + "Disquera.Nombre as Disquera\n"
                + "FROM Grupo, Disquera\n"
                + "WHERE grupo.idDisquera = disquera.idDisquera\n"
                + "AND idGrupo=" + idGrupo;
        datos = this.jdbc.queryForList(sql2);
        mav.addObject("ListaGrupo", datos);

        mav.setViewName("QrVistaGrupo");
        return mav;
    }
}
