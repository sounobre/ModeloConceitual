/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnobre.modconceit.services;

import br.com.dnobre.modconceit.domain.Categoria;
import br.com.dnobre.modconceit.repositories.CategoriaRepository;
import br.com.dnobre.modconceit.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author souno
 */
@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repo;
    
    public Categoria buscar(Integer id){
        
        Optional<Categoria> obj = repo.findById(id);
        
        return obj.orElseThrow(() -> new ObjectNotFoundException( 
                "Objeto não encontrodo! Id: " + id +
                ", Tipo: " + Categoria.class.getName()));
    }
    
    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }
}
