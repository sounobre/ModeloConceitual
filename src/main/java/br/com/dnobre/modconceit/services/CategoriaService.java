/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnobre.modconceit.services;

import br.com.dnobre.modconceit.domain.Categoria;
import br.com.dnobre.modconceit.repositories.CategoriaRepository;
import br.com.dnobre.modconceit.services.exceptions.DataIntegrityException;
import br.com.dnobre.modconceit.services.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author souno
 */
@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repo;
    
    public Categoria find(Integer id){
        
        Optional<Categoria> obj = repo.findById(id);
        
        return obj.orElseThrow(() -> new ObjectNotFoundException( 
                "Objeto não encontrodo! Id: " + id +
                ", Tipo: " + Categoria.class.getName()));
    }
    
    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }
    
    public Categoria update(Categoria obj){
        find(obj.getId());
        return repo.save(obj);
    }
    
    public void delete(Integer id){
        find(id);
        try{
            repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }
    }
        
        public List<Categoria> findAll(){
            return repo.findAll();
        }
        
        public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
            PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
            return repo.findAll(pageRequest);
        }
}
