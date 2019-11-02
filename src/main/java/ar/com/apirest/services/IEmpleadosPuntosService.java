/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.services;

import ar.com.apirest.entities.EmpleadosPuntos;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface IEmpleadosPuntosService {
    
         
    List<EmpleadosPuntos> getAll();
    EmpleadosPuntos get(Long id);
    void save(EmpleadosPuntos entity);
    String delete(EmpleadosPuntos entity);
    
     List<EmpleadosPuntos> findPuntosEmpleadoEntreFechas(LocalDate desde, LocalDate hasta, Integer idempleado);
    
}
