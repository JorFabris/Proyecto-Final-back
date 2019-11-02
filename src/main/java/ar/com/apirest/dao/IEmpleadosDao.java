/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.dao;

import ar.com.apirest.entities.Empleados;
import ar.com.apirest.entities.TiposDocumentos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jorge
 */
@Repository
public interface IEmpleadosDao extends JpaRepository<Empleados, Integer> {

    //Permite recuperar un objeto por un atributo que no sea el ID
    @Query("select c from empleados c where c.Dni = :nrodoc")
     public List<Empleados> findDocumentos(@Param("nrodoc") String nrodoc);


}
