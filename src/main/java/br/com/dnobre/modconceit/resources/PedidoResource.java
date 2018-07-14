/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnobre.modconceit.resources;

import br.com.dnobre.modconceit.domain.Pedido;
import br.com.dnobre.modconceit.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author souno
 */
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
    
    @Autowired
    private PedidoService service;
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Pedido> find(@PathVariable Integer id){
        
        Pedido obj = service.find(id);
        
        return ResponseEntity.ok().body(obj);
    }
}
