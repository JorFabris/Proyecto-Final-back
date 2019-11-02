/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.controllers;

import ar.com.apirest.entities.TiposDocumentos;
import ar.com.apirest.services.ITiposDocumentosService;
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
public class TiposDocumentosController {
    
    
    
       @Autowired
       private ITiposDocumentosService entityService;
     
     
    public TiposDocumentosController(ITiposDocumentosService entityService) {
        this.entityService = entityService;
    }
    
    
    @RequestMapping(value = "/tiposdocumentos", method = RequestMethod.GET)
    public List<TiposDocumentos> getAll() {
        return entityService.getAll();
    }
    
     @GetMapping("/tiposdocumentos/{id}")
    public TiposDocumentos get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @PostMapping("/tiposdocumentos")
    public void create(@Valid @RequestBody TiposDocumentos entity) {
        entityService.save(entity);
    }

    @DeleteMapping("/tiposdocumentos/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        TiposDocumentos entity = entityService.get(id);
        if (entity == null) {
            return null;
        }
        return entityService.delete(entity);
    }
    
    
}
