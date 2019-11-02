/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.controllers;

import ar.com.apirest.entities.Roles;
import ar.com.apirest.services.IRolesService;
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
public class RolesController {
    
     @Autowired
    private IRolesService entityService;
     
     
    public RolesController(IRolesService entityService) {
        this.entityService = entityService;
    }
    
    
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public List<Roles> getAll() {
        return entityService.getAll();
    }
    
     @GetMapping("/roles/{id}")
    public Roles get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @PostMapping("/roles")
    public void create(@Valid @RequestBody Roles entity) {
        entityService.save(entity);
    }

    @DeleteMapping("/roles/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Roles entity = entityService.get(id);
        if (entity == null) {
            return null;
        }
        return entityService.delete(entity);
    }
    
}
