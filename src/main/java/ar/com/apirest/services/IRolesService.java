/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.services;

import ar.com.apirest.entities.Roles;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface IRolesService {
    
   
    List<Roles> getAll();
    Roles get(Integer id);
    void save(Roles entity);
    String delete(Roles entity);
}
