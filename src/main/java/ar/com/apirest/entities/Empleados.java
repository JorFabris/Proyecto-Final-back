/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author jorge
 */


@Entity(name = "empleados")
public class Empleados {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Apellido;
    private String Direccion;
    private String Email;
    private String Nombre;
    private String Dni;
    private String Telefono;
    
    @JoinColumn(name = "fk_tiposdocumentos", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private TiposDocumentos tiposdocs;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the tiposdocs
     */
    public TiposDocumentos getTiposdocs() {
        return tiposdocs;
    }

    /**
     * @param tiposdocs the tiposdocs to set
     */
    public void setTiposdocs(TiposDocumentos tiposdocs) {
        this.tiposdocs = tiposdocs;
    }

    /**
     * @return the Dni
     */
    public String getDni() {
        return Dni;
    }

    /**
     * @param Dni the Dni to set
     */
    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
   
}
