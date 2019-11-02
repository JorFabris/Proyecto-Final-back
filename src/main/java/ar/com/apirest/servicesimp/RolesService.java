/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.servicesimp;

import ar.com.apirest.dao.IRolesDao;
import ar.com.apirest.entities.Roles;
import ar.com.apirest.services.IRolesService;
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
public class RolesService implements IRolesService {
    
    @Autowired
    private IRolesDao entityDao;


    public List<Roles> getAll() {
         return entityDao.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

   
    public Roles get(Integer id) {
         return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Roles entity) {
         entityDao.save(entity);
    }

     @Transactional
     public String delete(Roles entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
    
}
