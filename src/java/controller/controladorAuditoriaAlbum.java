/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.conexionBD;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raúl
 */
public class controladorAuditoriaAlbum {

    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET

    //METODO PARA LISTA
    List datos;

    @RequestMapping("listaAuditoriaAlbum.htm")
    public ModelAndView Listar() {
        String sql = "SELECT \n"
                + "Auditoria_Album.id,\n"
                + "Auditoria_Album.idGrupo,\n"
                + "Grupo.Nombre as Grupo,\n"
                + "Auditoria_Album.Nombre,\n"
                + "Auditoria_Album.NoCanciones,\n"
                + "Auditoria_Album.Duracion,\n"
                + "DATE_FORMAT(Auditoria_Album.lanzamiento, \"%d / %b / %Y\") as Lanzamiento,\n"
                + "Auditoria_Album.NoVentas,\n"
                + "Auditoria_Album.Genero,\n"
                + "Auditoria_Album.Imagen,\n"
                + "Auditoria_Album.usuario,\n"
                + "DATE_FORMAT(Auditoria_Album.Modificado, \"%d / %b / %Y - %r\") AS Modificado,\n"
                + "Auditoria_Album.proceso,\n"
                + "Auditoria_Album.idAlbum FROM Auditoria_Album,\n"
                + "grupo WHERE Auditoria_Album.idGrupo=grupo.idGrupo";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("listaAuditoriaAlbum");
        return mav;
    }
}
