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
public class controladorAuditoriaCanciones {

    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET

    //METODO PARA LISTA
    int idArtista;
    List datos;

    @RequestMapping("listaAuditoriaCancion.htm")
    public ModelAndView Listar() {
        String sql = "SELECT\n"
                + "Auditoria_Cancion.id,\n"
                + "Grupo.Nombre AS idGrupo,\n"
                + "Artista.NombreArtistico AS idInterprete,\n"
                + "Album.Nombre AS idAlbum,\n"
                + "Auditoria_Cancion.Nombre,\n"
                + "Auditoria_Cancion.Duracion,\n"
                + "DATE_FORMAT(Auditoria_Cancion.Lanzamiento, \"%d / %b / %Y\") AS Lanzamiento,\n"
                + "Auditoria_Cancion.Idioma,\n"
                + "Auditoria_Cancion.Genero,\n"
                + "Auditoria_Cancion.usuario,\n"
                + "DATE_FORMAT(Auditoria_Cancion.modificado, \"%d / %b / %Y - %r\") AS Modificado,\n"
                + "Auditoria_Cancion.proceso,\n"
                + "Auditoria_Cancion.idCancion\n"
                + "FROM auditoria_Cancion, Artista, Grupo, Album\n"
                + "WHERE Auditoria_Cancion.idInterprete = artista.idArtista\n"
                + "AND Auditoria_Cancion.idGrupo = Grupo.idGrupo\n"
                + "AND Auditoria_Cancion.idAlbum = album.idAlbum";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("listaAuditoriaCancion");
        return mav;
    }
}
