/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.controllers;

import ar.com.apirest.entities.Users;
import ar.com.apirest.services.IUsersService;

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
public class UsersController {
    
    
    
       @Autowired
       private IUsersService entityService;
     
     
    public UsersController(IUsersService entityService) {
        this.entityService = entityService;
    }
    
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Users> getAll() {
        return entityService.getAll();
    }
    
     @GetMapping("/users/{id}")
    public Users get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @PostMapping("/users")
    public void create(@Valid @RequestBody Users entity) {
        entityService.save(entity);
    }

    @DeleteMapping("/users/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Users entity = entityService.get(id);
        if (entity == null) {
            return null;
        }
        return entityService.delete(entity);
    }
    
    @GetMapping({"/users/login/{user}/{pass}"})
    public List<Users> findUserPass(@PathVariable String user, 
                                       @PathVariable String pass) {
        
        
        return entityService.findUserPass(user, pass);
    }
    
}
