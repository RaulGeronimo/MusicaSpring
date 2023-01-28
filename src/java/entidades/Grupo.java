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
 * @author Lemus
 */
public class Grupo {
    Date date = new java.util.Date();
    SimpleDateFormat simpleDate = new java.text.SimpleDateFormat("yyyy-mm-dd");
    
    private int idGrupo;
    private int idDisquera;
    private String Nombre;
    private String Origen;
    private String Inicio = simpleDate.format(date);
    private int NoIntegrantes;
    private String Genero;
    private String idioma;
    private String imagen;
    
    public Grupo(){
        
    }

    public Grupo(int idGrupo, int idDisquera, String Nombre, String Origen, int NoIntegrantes, String Genero, String idioma, String imagen) {
        this.idGrupo = idGrupo;
        this.idDisquera = idDisquera;
        this.Nombre = Nombre;
        this.Origen = Origen;
        this.NoIntegrantes = NoIntegrantes;
        this.Genero = Genero;
        this.idioma = idioma;
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

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdDisquera() {
        return idDisquera;
    }

    public void setIdDisquera(int idDisquera) {
        this.idDisquera = idDisquera;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public String getInicio() {
        return Inicio;
    }

    public void setInicio(String Inicio) {
        this.Inicio = Inicio;
    }

    public int getNoIntegrantes() {
        return NoIntegrantes;
    }

    public void setNoIntegrantes(int NoIntegrantes) {
        this.NoIntegrantes = NoIntegrantes;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
