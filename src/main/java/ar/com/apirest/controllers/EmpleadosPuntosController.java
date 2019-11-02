/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.controllers;

import ar.com.apirest.entities.EmpleadosPuntos;
import ar.com.apirest.services.IEmpleadosPuntosService;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jorge
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EmpleadosPuntosController {
    
      
    @Autowired
    private IEmpleadosPuntosService entityService;

    public EmpleadosPuntosController(IEmpleadosPuntosService entityService) {
        this.entityService = entityService;
    }

    @RequestMapping(value = "/empleadospuntos", method = RequestMethod.GET)
    public List<EmpleadosPuntos> getAll() {
        return entityService.getAll();
    }

    @GetMapping("/empleadospuntos/{id}")
    public EmpleadosPuntos get(@PathVariable Long id) {
        return entityService.get(id);
    }

    @PostMapping("/empleadospuntos")
    public void create(@Valid @RequestBody EmpleadosPuntos entity) {
        entityService.save(entity);
    }

    @DeleteMapping("/empleadospuntos/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        EmpleadosPuntos entity = entityService.get(id);
        if (entity == null) {
            return null;
        }
        return entityService.delete(entity);
    }
    
    
        @GetMapping({"/empleadospuntos/entrefechas/{idempleado}/{desde}/{hasta}"})
    public List<EmpleadosPuntos> findPuntosEmpleadoEntreFechas(@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable LocalDate desde, 
                                                               @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable LocalDate hasta,
                                                               @PathVariable Integer idempleado) {
        return entityService.findPuntosEmpleadoEntreFechas(desde, hasta, idempleado);
    }
    
}
