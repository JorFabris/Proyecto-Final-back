/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.entities;

import java.time.LocalDate;
import java.util.Date;
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
@Entity(name = "empleados_puntos")
public class EmpleadosPuntos {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate Fecha;
    private Integer puntosingresados;
    
    @JoinColumn(name = "fk_users", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Users users;
    
    @JoinColumn(name = "fk_punto", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Puntos puntos;
    
   
    @JoinColumn(name = "fk_empleado", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Empleados empleado;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the Fecha
     */
    public LocalDate getFecha() {
        return Fecha;
    }

    /**
     * @return the users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * @return the puntos
     */
    public Puntos getPuntos() {
        return puntos;
    }

    /**
     * @return the empleado
     */
    public Empleados getEmpleado() {
        return empleado;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(Puntos puntos) {
        this.puntos = puntos;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the puntosingresados
     */
    public Integer getPuntosingresados() {
        return puntosingresados;
    }

    /**
     * @param puntosingresados the puntosingresados to set
     */
    public void setPuntosingresados(Integer puntosingresados) {
        this.puntosingresados = puntosingresados;
    }
    
}
