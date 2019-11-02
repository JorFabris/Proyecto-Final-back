/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.dao;

import ar.com.apirest.entities.EmpleadosPuntos;
import java.time.LocalDate;
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
public interface IEmpleadosPuntosDao extends JpaRepository<EmpleadosPuntos, Long>{
    
    
       @Query(value = "select * from empleados_puntos as emppunt "
            + "inner join puntos as punt on emppunt.fk_punto = punt.id "
            + "where emppunt.fk_empleado = :idempleado "
            + "and emppunt.fecha between :desde and :hasta", nativeQuery = true)
    public List<EmpleadosPuntos> findPuntosEmpleadoEntreFechas(
            @Param("desde") LocalDate desde,
            @Param("hasta") LocalDate hasta,
            @Param("idempleado") Integer idempleado);
    

    

    
}
