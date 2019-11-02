/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.servicesimp;

import ar.com.apirest.dao.IEmpleadosPuntosDao;
import ar.com.apirest.entities.EmpleadosPuntos;
import ar.com.apirest.services.IEmpleadosPuntosService;
import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class EmpleadosPuntosService implements IEmpleadosPuntosService {
    
    
    @Autowired
    private IEmpleadosPuntosDao entityDao;


    public List<EmpleadosPuntos> getAll() {
         return entityDao.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

   
    public EmpleadosPuntos get(Long id) {
         return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(EmpleadosPuntos entity) {
         entityDao.save(entity);
    }

     @Transactional
     public String delete(EmpleadosPuntos entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
     
    public List<EmpleadosPuntos> findPuntosEmpleadoEntreFechas(LocalDate desde, LocalDate hasta, Integer idempleado){
        return entityDao.findPuntosEmpleadoEntreFechas(desde, hasta, idempleado);
    }
    
}
