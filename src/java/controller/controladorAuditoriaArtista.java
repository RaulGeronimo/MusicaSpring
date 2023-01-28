/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.conexionBD;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raúl
 */
@Controller
public class controladorAuditoriaArtista {

    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET

    //METODO PARA LISTA
    int idArtista;
    List datos;

    @RequestMapping("listaAuditoriaArtista.htm")
    public ModelAndView Listar() {
        String sql = "SELECT\n"
                + "id,\n"
                + "idArtista, \n"
                + "Nombre, \n"
                + "Apellidos, \n"
                + "NombreArtistico AS Artistico,  \n"
                + "Genero, \n"
                + "DATE_FORMAT(FechaNacimiento, \"%d / %b / %Y\") AS Nacimiento,\n"
                + "DATE_FORMAT(FechaDefuncion, \"%d / %b / %Y\") AS Defuncion,\n"
                + "Pais, \n"
                + "Instrumento, \n"
                + "TRUNCATE(Estatura, 2) AS Estatura, \n"
                + "Imagen,\n"
                + "Usuario,\n"
                + "DATE_FORMAT(Modificado, \"%d / %b / %Y - %r\") AS Modificado,\n"
                + "Proceso\n"
                + "FROM Auditoria_Artista";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);

        mav.setViewName("listaAuditoriaArtista");
        return mav;
    }
}
