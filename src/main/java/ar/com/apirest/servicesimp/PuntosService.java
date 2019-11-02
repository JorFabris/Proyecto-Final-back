/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.servicesimp;

import ar.com.apirest.dao.IPuntosDao;
import ar.com.apirest.entities.Puntos;
import ar.com.apirest.services.IPuntosService;
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
public class PuntosService  implements IPuntosService {

    @Autowired
    private IPuntosDao entityDao;
 
    public List<Puntos> getAll() {
         return entityDao.findAll(new Sort(Sort.Direction.ASC, "id"));
    }


    public Puntos get(Integer id) {
         return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Puntos entity) {
         entityDao.save(entity);
    }

    @Transactional
    public String delete(Puntos entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
    
}
