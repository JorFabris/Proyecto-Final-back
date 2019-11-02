/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.controllers;

import ar.com.apirest.entities.Puntos;
import ar.com.apirest.services.IPuntosService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PuntosController {
    
     @Autowired
    private IPuntosService entityService;
    
      public PuntosController(IPuntosService entityService) {
        this.entityService = entityService;
    }
      
      
    @RequestMapping(value = "/puntos", method = RequestMethod.GET)
    public List<Puntos> getAll() {
        return entityService.getAll();
    }
    
     @GetMapping("/puntos/{id}")
    public Puntos get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @PostMapping("/puntos")
    public void create(@Valid @RequestBody Puntos entity) {
        entityService.save(entity);
    }

    @DeleteMapping("/puntos/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Puntos entity = entityService.get(id);
        if (entity == null) {
            return null;
        }
        return entityService.delete(entity);
    }
    
     
}
