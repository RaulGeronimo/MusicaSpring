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
public class controladorAuditoriaDisquera {
    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET

    //METODO PARA LISTA
    int idArtista;
    List datos;

    @RequestMapping("listaAuditoriaDisquera.htm")
    public ModelAndView Listar() {
        String sql = "SELECT *, "
                + "DATE_FORMAT(Fundacion, \"%d / %b / %Y\") AS Fundacion, "
                + "DATE_FORMAT(Modificado, \"%d / %b / %Y - %r\") AS Modificado, "
                + "CONCAT(\"(\", LEFT(Telefono, 3),\") \", MID(Telefono, 4, 3),\"-\", MID(Telefono, 7, 4)) AS Telefono "
                + "FROM Auditoria_Disquera";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("listaAuditoriaDisquera");
        return mav;
    }
}
