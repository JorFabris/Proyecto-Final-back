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

/**
 *
 * @author jorge
 */

@Entity(name = "puntos")
public class Puntos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean Activo;
    private String Descrip;
    private Integer puntos;
    private Integer Tope;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the Activo
     */
    public boolean isActivo() {
        return Activo;
    }

    /**
     * @return the Descrip
     */
    public String getDescrip() {
        return Descrip;
    }

    /**
     * @return the puntos
     */
    public Integer getPuntos() {
        return puntos;
    }

    /**
     * @return the Tope
     */
    public Integer getTope() {
        return Tope;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param Activo the Activo to set
     */
    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    /**
     * @param Descrip the Descrip to set
     */
    public void setDescrip(String Descrip) {
        this.Descrip = Descrip;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    /**
     * @param Tope the Tope to set
     */
    public void setTope(Integer Tope) {
        this.Tope = Tope;
    }
    
    
    
}
