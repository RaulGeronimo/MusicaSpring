/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author SALA 2-14
 */
public class Canciones {
    
    Date date = new java.util.Date();
    SimpleDateFormat simpleDate = new java.text.SimpleDateFormat("yyyy-mm-dd");
    SimpleDateFormat simpleHora = new java.text.SimpleDateFormat("HH:mm:ss");
    
    private int idCancion;
    private int idGrupo;
    private int idInterprete;
    private int idAlbum;
    private String Nombre;
    private String duracion = simpleHora.format(date);
    private String Lanzamiento = simpleDate.format(date);
    private String idioma;
    private String genero;       

        public Canciones(){
        }

    public Canciones(int idCancion, int idGrupo, int idInterprete, int idAlbum, String Nombre, String idioma, String genero) {
        this.idCancion = idCancion;
        this.idGrupo = idGrupo;
        this.idInterprete = idInterprete;
        this.idAlbum = idAlbum;
        this.Nombre = Nombre;
        this.idioma = idioma;
        this.genero = genero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SimpleDateFormat getSimpleDate() {
        return simpleDate;
    }

    public void setSimpleDate(SimpleDateFormat simpleDate) {
        this.simpleDate = simpleDate;
    }

    public SimpleDateFormat getSimpleHora() {
        return simpleHora;
    }

    public void setSimpleHora(SimpleDateFormat simpleHora) {
        this.simpleHora = simpleHora;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdInterprete() {
        return idInterprete;
    }

    public void setIdInterprete(int idInterprete) {
        this.idInterprete = idInterprete;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getLanzamiento() {
        return Lanzamiento;
    }

    public void setLanzamiento(String Lanzamiento) {
        this.Lanzamiento = Lanzamiento;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
        
}
