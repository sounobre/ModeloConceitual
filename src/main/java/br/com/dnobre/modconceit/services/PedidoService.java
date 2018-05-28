/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnobre.modconceit.services;

import br.com.dnobre.modconceit.domain.Pedido;
import br.com.dnobre.modconceit.repositories.PedidoRepository;
import br.com.dnobre.modconceit.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author souno
 */
@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repo;
    
    public Pedido buscar(Integer id){
        
        Optional<Pedido> obj = repo.findById(id);
        
        return obj.orElseThrow(() -> new ObjectNotFoundException( 
                "Objeto não encontrodo! Id: " + id +
                ", Tipo: " + Pedido.class.getName()));
    }
}
