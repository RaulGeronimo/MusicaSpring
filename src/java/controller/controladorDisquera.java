/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Qr.QRCodeUtil;
import com.google.zxing.WriterException;
import config.conexionBD;
import entidades.Disquera;
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
 * @author Lemus
 */
@Controller
public class controladorDisquera {

    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET

    //Metodo para las vistas - METODO PARA OBTENER VISTAS
    @RequestMapping(value = "altaDisquera.htm", method = RequestMethod.GET)
    public ModelAndView VistaAgregar() {
        mav.addObject(new Disquera());
        mav.setViewName("altaDisquera");
        return mav;
    }

    //METODO PARA AGREGAR
    @RequestMapping(value = "altaDisquera.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Disquera d) {
        String sql = "INSERT into Disquera(Nombre, Correo, Direccion, Telefono, Fundacion, Imagen) values (?,?,?,?,?,?)";
        this.jdbc.update(sql, d.getNombre(), d.getCorreo(), d.getDireccion(), d.getTelefono(), d.getFundacion(), d.getImagen());
        return new ModelAndView("redirect:/altaDisquera.htm");
    }

    //METODO PARA LISTA
    int idDisquera;
    List datos;

    @RequestMapping("listaDisquera.htm")
    public ModelAndView Listar() {
        String sql = "SELECT \n"
                + "idDisquera, \n"
                + "Nombre, \n"
                + "Correo, \n"
                + "Direccion, \n"
                + "CONCAT(\"(\", LEFT(Telefono, 3), \")\", MID(Telefono, 4, 3), \"-\", MID(Telefono, 7, 4)) AS Telefono, \n"
                + "DATE_FORMAT(Fundacion, \"%d - %b - %Y\") AS Fundacion, \n"
                + "Imagen \n"
                + "FROM Disquera";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("listaDisquera");
        return mav;
    }

    @RequestMapping("PDFDisquera.htm")
    public ModelAndView PDF() {
        String sql = "SELECT \n"
                + "idDisquera, \n"
                + "Nombre, \n"
                + "Correo, \n"
                + "Direccion, \n"
                + "CONCAT(\"(\", LEFT(Telefono, 3), \")\", MID(Telefono, 4, 3), \"-\", MID(Telefono, 7, 4)) AS Telefono, \n"
                + "DATE_FORMAT(Fundacion, \"%d - %b - %Y\") AS Fundacion, \n"
                + "Imagen \n"
                + "FROM Disquera";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("PDFDisquera");
        return mav;
    }

    @RequestMapping(value = "editarDisquera.htm", method = RequestMethod.GET)
    public ModelAndView vistaEditar(HttpServletRequest request) {
        idDisquera = Integer.parseInt(request.getParameter("idDisquera"));
        String sql = "SELECT * from Disquera WHERE idDisquera=" + idDisquera;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("editarDisquera");
        return mav;
    }

//METODO PARA EDITAR
    @RequestMapping(value = "editarDisquera.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Disquera d) {
        String sql = "UPDATE Disquera SET Nombre=?, Correo=?, Direccion=?, Telefono=?, Fundacion=?, Imagen=? WHERE idDisquera=?";
        this.jdbc.update(sql, d.getNombre(), d.getCorreo(), d.getDireccion(), d.getTelefono(), d.getFundacion(), d.getImagen(), idDisquera);
        return new ModelAndView("redirect:/listaDisquera.htm");
    }

    //METODO PARA ELIMINAR
    @RequestMapping(value = "eliminarDisquera.htm")
    public ModelAndView Eliminar(HttpServletRequest request) {
        idDisquera = Integer.parseInt(request.getParameter("idDisquera"));
        String sql = "DELETE from Disquera WHERE idDisquera=" + idDisquera;
        this.jdbc.update(sql);
        return new ModelAndView("redirect:/listaDisquera.htm");
    }

    //QR
    @RequestMapping(value = "GeneraQRDisquera.htm", method = RequestMethod.GET)
    public ModelAndView qr(HttpServletRequest request) throws WriterException, FileNotFoundException, IOException, InterruptedException {
        //Se Extrae la imagen desde la ubicacion desde el disco local "C:"
        File fichero = new File("C:\\Users\\raul0\\Documents\\NetBeansProjects\\Spring\\Musica Servidor\\MusicaSpring\\web\\img\\QR.png");

        //DISQUERA
        idDisquera = Integer.parseInt(request.getParameter("idDisquera"));
        String sql = "SELECT \n"
                + "idDisquera, \n"
                + "Nombre, \n"
                + "Correo, \n"
                + "Direccion, \n"
                + "CONCAT(\"(\", LEFT(Telefono, 3), \")\", MID(Telefono, 4, 3), \"-\", MID(Telefono, 7, 4)) AS Telefono, \n"
                + "DATE_FORMAT(Fundacion, \"%d / %M / %Y\") AS Fundacion, \n"
                + "Imagen \n"
                + "FROM Disquera WHERE idDisquera=" + idDisquera;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);

        if (fichero.delete()) {
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero no pudó ser borrado");
        }

        String formato = "png";
        QRCodeUtil generaQR = new QRCodeUtil();
        BufferedImage imagen = generaQR.crearQR("http://192.168.0.9:8080/Musica/QrVistaDisquera.htm?idDisquera=" + idDisquera, 300, 300);

        try {
            ImageIO.write(imagen, formato, fichero);
            System.out.println("Prueba " + fichero.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error de escritura");
        }
        System.out.println("Quedo " + fichero.getAbsolutePath());
        Thread.sleep(2000);
        mav.setViewName("GeneraQRDisquera");
        return mav;
    }

    @RequestMapping(value = "QrVistaDisquera.htm", method = RequestMethod.GET)
    public ModelAndView vistaqQR(HttpServletRequest request) {
        idDisquera = Integer.parseInt(request.getParameter("idDisquera"));
        String sql = "SELECT \n"
                + "idDisquera, \n"
                + "Nombre, \n"
                + "Correo, \n"
                + "Direccion, \n"
                + "CONCAT(\"(\", LEFT(Telefono, 3), \")\", MID(Telefono, 4, 3), \"-\", MID(Telefono, 7, 4)) AS Telefono, \n"
                + "DATE_FORMAT(Fundacion, \"%d / %M / %Y\") AS Fundacion, \n"
                + "Imagen \n"
                + "FROM Disquera WHERE idDisquera=" + idDisquera;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("QrVistaDisquera");
        return mav;
    }
}
