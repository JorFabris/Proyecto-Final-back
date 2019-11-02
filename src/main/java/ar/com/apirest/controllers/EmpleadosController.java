/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.controllers;

import ar.com.apirest.entities.Empleados;
import ar.com.apirest.entities.TiposDocumentos;
import ar.com.apirest.services.IEmpleadosService;
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
public class EmpleadosController {
    
    
    @Autowired
    private IEmpleadosService entityService;
    
    
         
    public EmpleadosController(IEmpleadosService entityService) {
        this.entityService = entityService;
    }
    
    
    @RequestMapping(value = "/empleados", method = RequestMethod.GET)
    public List<Empleados> getAll() {
        return entityService.getAll();
    }
    
     @GetMapping("/empleados/{id}")
    public Empleados get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @PostMapping("/empleados")
    public void create(@Valid @RequestBody Empleados entity) {
        entityService.save(entity);
    }

    @DeleteMapping("/empleados/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Empleados entity = entityService.get(id);
        if (entity == null) {
            return null;
        }
        return entityService.delete(entity);
    }
     
    @GetMapping({"/empleados/getbydoc/{nrodoc}"})
    public List<Empleados> findDocumento(@PathVariable String nrodoc) {
        return entityService.findDocumentos(nrodoc);
    }
}
