/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.services;

import ar.com.apirest.entities.Puntos;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface IPuntosService {
    
    List<Puntos> getAll();
    Puntos get(Integer id);
    void save(Puntos entity);
    String delete(Puntos entity);
    
}
