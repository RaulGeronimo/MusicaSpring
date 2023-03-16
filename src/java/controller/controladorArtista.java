/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.conexionBD;
import entidades.Artista;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import Qr.QRCodeUtil;
import com.google.zxing.WriterException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Raúl
 */
@Controller
public class controladorArtista {

    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET

    //Metodo para las vistas - METODO PARA OBTENER VISTAS
    @RequestMapping(value = "altaArtista.htm", method = RequestMethod.GET)
    public ModelAndView VistaAgregar() {
        mav.addObject(new Artista());
        mav.setViewName("altaArtista");
        return mav;
    }

    //METODO PARA AGREGAR
    @RequestMapping(value = "altaArtista.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Artista a) {
        String sql = "INSERT into Artista(Nombre, Apellidos, NombreArtistico, Genero, FechaNacimiento, Pais, Instrumento, Estatura, Imagen) values (?,?,?,?,?,?,?,?,?)";
        this.jdbc.update(sql, a.getNombre(), a.getApellidos(), a.getNombreArtistico(), a.getGenero(), a.getFechaNacimiento(), a.getPais(), a.getInstrumento(), a.getEstatura(), a.getImagen());
        return new ModelAndView("redirect:/altaArtista.htm");
    }

    //Metodo para las vistas - METODO PARA OBTENER VISTAS
    @RequestMapping(value = "altaArtistaMuerto.htm", method = RequestMethod.GET)
    public ModelAndView VistaAgregar2() {
        mav.addObject(new Artista());
        mav.setViewName("altaArtistaMuerto");
        return mav;
    }

    //METODO PARA AGREGAR
    @RequestMapping(value = "altaArtistaMuerto.htm", method = RequestMethod.POST)
    public ModelAndView Agregar2(Artista a) {
        String sql = "INSERT into Artista(Nombre, Apellidos, NombreArtistico, Genero, FechaNacimiento, FechaDefuncion, Pais, Instrumento, Estatura, Imagen) values (?,?,?,?,?,?,?,?,?,?)";
        this.jdbc.update(sql, a.getNombre(), a.getApellidos(), a.getNombreArtistico(), a.getGenero(), a.getFechaNacimiento(), a.getFechaDefuncion(), a.getPais(), a.getInstrumento(), a.getEstatura(), a.getImagen());
        return new ModelAndView("redirect:/altaArtista.htm");
    }

    //METODO PARA LISTA
    int idArtista;
    List datos;

    @RequestMapping("listaArtista.htm")
    public ModelAndView Listar() {
        String sql = "SELECT \n"
                + "idArtista, \n"
                + "Nombre, \n"
                + "Apellidos, \n"
                + "NombreArtistico,  \n"
                + "IF(Genero = 'H', 'Hombre', 'Mujer') AS Genero, \n"
                + "DATE_FORMAT(FechaNacimiento, \"%d / %b / %Y\") AS FechaNacimiento,\n"
                + "DATE_FORMAT(FechaDefuncion, \"%d / %b / %Y\") AS Fallecimiento,\n"
                + "TIMESTAMPDIFF(Year, FechaNacimiento, (IFNULL(FechaDefuncion,NOW()))) AS Edad,\n"
                + "Pais, \n"
                + "Instrumento, \n"
                + "TRUNCATE(Estatura, 2) AS Estatura, \n"
                + "Imagen,\n"
                + "IF(IFNULL(FechaDefuncion, 'VIVO') = 'Vivo', 'Vivo', 'Muerto') AS Estado \n"
                + "FROM Artista";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("listaArtista");
        return mav;
    }

    @RequestMapping("PDFArtista.htm")
    public ModelAndView PDF() {
        String sql = "SELECT \n"
                + "idArtista, \n"
                + "Nombre, \n"
                + "Apellidos, \n"
                + "NombreArtistico,  \n"
                + "IF(Genero = 'H', 'Hombre', 'Mujer') AS Genero, \n"
                + "DATE_FORMAT(FechaNacimiento, \"%d / %b / %Y\") AS FechaNacimiento,\n"
                + "DATE_FORMAT(FechaDefuncion, \"%d / %b / %Y\") AS Fallecimiento,\n"
                + "TIMESTAMPDIFF(Year, FechaNacimiento, (IFNULL(FechaDefuncion,NOW()))) AS Edad,\n"
                + "Pais, \n"
                + "Instrumento, \n"
                + "TRUNCATE(Estatura, 2) AS Estatura, \n"
                + "Imagen,\n"
                + "IF(IFNULL(FechaDefuncion, 'VIVO') = 'Vivo', 'Vivo', 'Muerto') AS Estado \n"
                + "FROM Artista";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("PDFArtista");
        return mav;
    }

    @RequestMapping(value = "editarArtista.htm", method = RequestMethod.GET)
    public ModelAndView vistaEditar(HttpServletRequest request) {
        idArtista = Integer.parseInt(request.getParameter("idArtista"));
        String sql = "SELECT * from Artista WHERE idArtista=" + idArtista;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("editarArtista");
        return mav;
    }

    //METODO PARA EDITAR
    @RequestMapping(value = "editarArtista.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Artista a) {
        String sql = "UPDATE Artista SET Nombre=?, Apellidos=?, NombreArtistico=?, Genero=?, FechaNacimiento=?, FechaDefuncion=null, Pais=?, Instrumento=?, Estatura=?, Imagen=? WHERE idArtista=?";
        this.jdbc.update(sql, a.getNombre(), a.getApellidos(), a.getNombreArtistico(), a.getGenero(), a.getFechaNacimiento(), a.getPais(), a.getInstrumento(), a.getEstatura(), a.getImagen(), idArtista);
        return new ModelAndView("redirect:/listaArtista.htm");
    }

    //Artista Tieso
    @RequestMapping(value = "editarArtistaTieso.htm", method = RequestMethod.GET)
    public ModelAndView vistaEditar2(HttpServletRequest request) {
        idArtista = Integer.parseInt(request.getParameter("idArtista"));
        String sql = "SELECT * from Artista WHERE idArtista=" + idArtista;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("editarArtistaTieso");
        return mav;
    }

    //METODO PARA EDITAR
    @RequestMapping(value = "editarArtistaTieso.htm", method = RequestMethod.POST)
    public ModelAndView Editar2(Artista a) {
        String sql = "UPDATE Artista SET Nombre=?, Apellidos=?, NombreArtistico=?, Genero=?, FechaNacimiento=?, FechaDefuncion=?, Pais=?, Instrumento=?, Estatura=?, Imagen=? WHERE idArtista=?";
        this.jdbc.update(sql, a.getNombre(), a.getApellidos(), a.getNombreArtistico(), a.getGenero(), a.getFechaNacimiento(), a.getFechaDefuncion(), a.getPais(), a.getInstrumento(), a.getEstatura(), a.getImagen(), idArtista);
        return new ModelAndView("redirect:/listaArtista.htm");
    }

    //METODO PARA ELIMINAR
    @RequestMapping(value = "eliminarArtista.htm")
    public ModelAndView Eliminar(HttpServletRequest request) {
        idArtista = Integer.parseInt(request.getParameter("idArtista"));
        String sql = "DELETE from Artista WHERE idArtista=" + idArtista;
        this.jdbc.update(sql);
        return new ModelAndView("redirect:/listaArtista.htm");
    }

    //QR
    @RequestMapping(value = "GeneraQRArtista.htm", method = RequestMethod.GET)
    public ModelAndView qr(HttpServletRequest request) throws WriterException, FileNotFoundException, IOException, InterruptedException {
        //Se Extrae la imagen desde la ubicacion desde el disco local "C:"
        File fichero = new File("C:\\Users\\raul0\\Documents\\NetBeansProjects\\Spring\\Musica Servidor\\MusicaSpring\\web\\img\\QR.png");

        //PARA EXTRAER LOS DATOS DEL ARTISTA
        idArtista = Integer.parseInt(request.getParameter("idArtista"));
        String sql = "SELECT \n"
                + "idArtista, \n"
                + "Nombre, \n"
                + "Apellidos, \n"
                + "NombreArtistico,  \n"
                + "IF(Genero = 'H', 'Hombre', 'Mujer') AS Genero, \n"
                + "DATE_FORMAT(FechaNacimiento, \"%d / %M / %Y\") AS FechaNacimiento,\n"
                + "DATE_FORMAT(FechaDefuncion, \"%d / %M / %Y\") AS Fallecimiento,\n"
                + "TIMESTAMPDIFF(Year, FechaNacimiento, (IFNULL(FechaDefuncion,NOW()))) AS Edad,\n"
                + "Pais, \n"
                + "Instrumento, \n"
                + "TRUNCATE(Estatura, 2) AS Estatura, \n"
                + "Imagen,\n"
                + "IF(IFNULL(FechaDefuncion, 'VIVO') = 'Vivo', 'Vivo', 'Muerto') AS Estado \n"
                + "FROM Artista WHERE idArtista=" + idArtista;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);

        if (fichero.delete()) {
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero no pudó ser borrado");
        }

        String formato = "png";
        QRCodeUtil generaQR = new QRCodeUtil();
        BufferedImage imagen = generaQR.crearQR("http://192.168.0.9:8080/Musica/QrVistaArtista.htm?idArtista=" + idArtista, 300, 300);

        try {
            ImageIO.write(imagen, formato, fichero);
            System.out.println("Prueba " + fichero.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error de escritura");
        }
        System.out.println("Quedo " + fichero.getAbsolutePath());
        Thread.sleep(2000);
        mav.setViewName("GeneraQRArtista");
        return mav;
    }

    @RequestMapping(value = "QrVistaArtista.htm", method = RequestMethod.GET)
    public ModelAndView vistaqQR(HttpServletRequest request) {
        idArtista = Integer.parseInt(request.getParameter("idArtista"));
        String sql = "SELECT \n"
                + "idArtista, \n"
                + "Nombre, \n"
                + "Apellidos, \n"
                + "NombreArtistico,  \n"
                + "IF(Genero = 'H', 'Hombre', 'Mujer') AS Genero, \n"
                + "DATE_FORMAT(FechaNacimiento, \"%d / %M / %Y\") AS FechaNacimiento,\n"
                + "DATE_FORMAT(FechaDefuncion, \"%d / %M / %Y\") AS Fallecimiento,\n"
                + "TIMESTAMPDIFF(Year, FechaNacimiento, (IFNULL(FechaDefuncion,NOW()))) AS Edad,\n"
                + "Pais, \n"
                + "Instrumento, \n"
                + "TRUNCATE(Estatura, 2) AS Estatura, \n"
                + "Imagen,\n"
                + "IF(IFNULL(FechaDefuncion, 'VIVO') = 'Vivo', 'Vivo', 'Muerto') AS Estado \n"
                + "FROM Artista WHERE idArtista=" + idArtista;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("QrVistaArtista");
        return mav;
    }

}
