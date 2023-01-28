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
public class Artista {
    Date date = new java.util.Date();
    SimpleDateFormat simpleDate = new java.text.SimpleDateFormat("yyyy-mm-dd");
    
    private int idArtista;
    private String Nombre;
    private String Apellidos;
    private String NombreArtistico;
    private String Genero;
    private String FechaNacimiento = simpleDate.format(date);
    private String FechaDefuncion = simpleDate.format(date);
    private String Pais;
    private String Instrumento;
    private double Estatura;
    private String imagen;
    
    public Artista(){
        
    }

    public Artista(int idArtista, String Nombre, String Apellidos, String NombreArtistico, String Genero, String Pais, String Instrumento, double Estatura, String imagen) {
        this.idArtista = idArtista;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.NombreArtistico = NombreArtistico;
        this.Genero = Genero;
        this.Pais = Pais;
        this.Instrumento = Instrumento;
        this.Estatura = Estatura;
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

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombreArtistico() {
        return NombreArtistico;
    }

    public void setNombreArtistico(String NombreArtistico) {
        this.NombreArtistico = NombreArtistico;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getFechaDefuncion() {
        return FechaDefuncion;
    }

    public void setFechaDefuncion(String FechaDefuncion) {
        this.FechaDefuncion = FechaDefuncion;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getInstrumento() {
        return Instrumento;
    }

    public void setInstrumento(String Instrumento) {
        this.Instrumento = Instrumento;
    }

    public double getEstatura() {
        return Estatura;
    }

    public void setEstatura(double Estatura) {
        this.Estatura = Estatura;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
