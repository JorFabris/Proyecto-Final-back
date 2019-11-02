/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.servicesimp;

import ar.com.apirest.dao.IEmpleadosDao;
import ar.com.apirest.entities.Empleados;
import ar.com.apirest.entities.TiposDocumentos;
import ar.com.apirest.services.IEmpleadosService;
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
public class EmpleadosService implements IEmpleadosService {

    @Autowired
    private IEmpleadosDao entityDao;

    public List<Empleados> getAll() {
        return entityDao.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

    public Empleados get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Empleados entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Empleados entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

    public List<Empleados> findDocumentos(String nrodoc){
        return entityDao.findDocumentos(nrodoc);
    }

 


}
