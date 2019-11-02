/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.servicesimp;

import ar.com.apirest.dao.ITiposDocumentosDao;
import ar.com.apirest.entities.TiposDocumentos;
import ar.com.apirest.services.ITiposDocumentosService;
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
public class TiposDocumentosService implements ITiposDocumentosService {
    
    
      @Autowired
    private ITiposDocumentosDao entityDao;
    
    
    
    public List<TiposDocumentos > getAll() {
         return entityDao.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

   
    public TiposDocumentos get(Integer id) {
         return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(TiposDocumentos entity) {
         entityDao.save(entity);
    }

     @Transactional
     public String delete(TiposDocumentos entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
    
}
