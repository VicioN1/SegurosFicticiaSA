
package com.pruebatecnica.ficticia.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuarios {
    
    
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    private String id;
    
    private String Nombre;
    private long Identificacion;
    private String Edad;
    private String Genero;
    private String mail;
    private String Clave;
    private String otros;
    private String Maneja;
    private String Usa_lentes;
    private String Diabetico;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date Alta;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date Baja;

    public Usuarios() {
    }

    public Usuarios(String id, String Nombre, long Identificacion, String Edad, String Genero, String mail, String Clave, String otros, String Maneja, String Usa_lentes, String Diabetico, Date Alta, Date Baja) {
        this.id = id;
        this.Nombre = Nombre;
        this.Identificacion = Identificacion;
        this.Edad = Edad;
        this.Genero = Genero;
        this.mail = mail;
        this.Clave = Clave;
        this.otros = otros;
        this.Maneja = Maneja;
        this.Usa_lentes = Usa_lentes;
        this.Diabetico = Diabetico;
        this.Alta = Alta;
        this.Baja = Baja;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public long getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(long Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public String getManeja() {
        return Maneja;
    }

    public void setManeja(String Maneja) {
        this.Maneja = Maneja;
    }

    public String getUsa_lentes() {
        return Usa_lentes;
    }

    public void setUsa_lentes(String Usa_lentes) {
        this.Usa_lentes = Usa_lentes;
    }

    public String getDiabetico() {
        return Diabetico;
    }

    public void setDiabetico(String Diabetico) {
        this.Diabetico = Diabetico;
    }

    public Date getAlta() {
        return Alta;
    }

    public void setAlta(Date Alta) {
        this.Alta = Alta;
    }

    public Date getBaja() {
        return Baja;
    }

    public void setBaja(Date Baja) {
        this.Baja = Baja;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", Nombre=" + Nombre + ", Identificacion=" + Identificacion + ", Edad=" + Edad + ", Genero=" + Genero + ", mail=" + mail + ", Clave=" + Clave + ", otros=" + otros + ", Maneja=" + Maneja + ", Usa_lentes=" + Usa_lentes + ", Diabetico=" + Diabetico + ", Alta=" + Alta + ", Baja=" + Baja + '}';
    }

}