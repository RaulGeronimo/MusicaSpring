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
public class controladorAuditoriaGrupo {

    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET

    //METODO PARA LISTA
    int idArtista;
    List datos;

    @RequestMapping("listaAuditoriaGrupo.htm")
    public ModelAndView Listar() {
        String sql = "SELECT auditoria_grupo.id,\n"
                + "Disquera.Nombre AS idDisquera,\n"
                + "auditoria_grupo.Nombre,\n"
                + "auditoria_grupo.Origen,\n"
                + "DATE_FORMAT(auditoria_grupo.Inicio, \"%d / %b / %Y\") AS Inicio,\n"
                + "auditoria_grupo.NoIntegrantes,\n"
                + "auditoria_grupo.Genero,\n"
                + "auditoria_grupo.Idioma,\n"
                + "auditoria_grupo.Imagen,\n"
                + "auditoria_grupo.usuario,\n"
                + "DATE_FORMAT(auditoria_grupo.Modificado, \"%d / %b / %Y - %r\") AS Modificado,\n"
                + "auditoria_grupo.proceso,\n"
                + "auditoria_grupo.idGrupo\n"
                + "FROM auditoria_grupo, Disquera\n"
                + "WHERE auditoria_grupo.idDisquera = Disquera.idDisquera";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("listaAuditoriaGrupo");
        return mav;
    }
}
