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
public class Disquera {
    Date date = new java.util.Date();
    SimpleDateFormat simpleDate = new java.text.SimpleDateFormat("yyyy-mm-dd");
    
    private int idDisquera;
    private String Nombre;
    private String Correo;
    private String Direccion;
    private long Telefono;
    private String imagen;
    private String Fundacion = simpleDate.format(date);

    
    public Disquera(){
    
   }

    public Disquera(int idDisquera, String Nombre, String Correo, String Direccion, long Telefono, String imagen) {
        this.idDisquera = idDisquera;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
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

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public long getTelefono() {
        return Telefono;
    }

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFundacion() {
        return Fundacion;
    }

    public void setFundacion(String Fundacion) {
        this.Fundacion = Fundacion;
    }
    
}
