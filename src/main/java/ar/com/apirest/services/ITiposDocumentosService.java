/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.apirest.services;

import ar.com.apirest.entities.TiposDocumentos;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface ITiposDocumentosService {
    
    
    
    List<TiposDocumentos> getAll();
    TiposDocumentos get(Integer id);
    void save(TiposDocumentos entity);
    String delete(TiposDocumentos entity);
    
}
