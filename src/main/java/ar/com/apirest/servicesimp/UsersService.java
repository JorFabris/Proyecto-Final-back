/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.servicesimp;

import ar.com.apirest.dao.IUsersDao;
import ar.com.apirest.entities.Users;
import ar.com.apirest.services.IUsersService;
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
public class UsersService implements IUsersService {
    
    
    @Autowired
    private IUsersDao entityDao;
    
    
    
    public List<Users> getAll() {
         return entityDao.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

   
    public Users get(Integer id) {
         return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Users entity) {
         entityDao.save(entity);
    }

     @Transactional
     public String delete(Users entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
     
      public List<Users> findUserPass(String user, String pass) {
       return entityDao.findUserPass(user, pass);
    }
    
}
