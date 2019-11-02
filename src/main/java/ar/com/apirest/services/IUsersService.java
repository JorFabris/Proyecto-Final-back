/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.services;

import ar.com.apirest.entities.Users;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface IUsersService {
 
    
    List<Users> getAll();
    Users get(Integer id);
    void save(Users entity);
    String delete(Users entity);
    
     List<Users> findUserPass(String user, String pass);
    
}
