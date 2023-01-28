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
 * @author Raúl
 */
public class Album {
    Date date = new java.util.Date();
    SimpleDateFormat simpleDate = new java.text.SimpleDateFormat("yyyy-mm-dd");
    SimpleDateFormat simpleHora = new java.text.SimpleDateFormat("HH:mm:ss");
    
    private int idAlbum;
    private int idGrupo;
    private String Nombre;
    private int NoCanciones;
    private String Duracion = simpleHora.format(date);
    private String Lanzamiento = simpleDate.format(date);
    private double NoVentas;
    private String Genero;
    private String imagen;
    
    public Album(){
        
    }

    public Album(int idAlbum, int idGrupo, String Nombre, int NoCanciones, double NoVentas, String Genero, String imagen) {
        this.idAlbum = idAlbum;
        this.idGrupo = idGrupo;
        this.Nombre = Nombre;
        this.NoCanciones = NoCanciones;
        this.NoVentas = NoVentas;
        this.Genero = Genero;
        this.imagen = imagen;
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

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNoCanciones() {
        return NoCanciones;
    }

    public void setNoCanciones(int NoCanciones) {
        this.NoCanciones = NoCanciones;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String Duracion) {
        this.Duracion = Duracion;
    }

    public String getLanzamiento() {
        return Lanzamiento;
    }

    public void setLanzamiento(String Lanzamiento) {
        this.Lanzamiento = Lanzamiento;
    }

    public double getNoVentas() {
        return NoVentas;
    }

    public void setNoVentas(double NoVentas) {
        this.NoVentas = NoVentas;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    
    
}
