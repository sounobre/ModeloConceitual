/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnobre.modconceit.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author souno
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @RequestMapping(method = RequestMethod.GET)
    public String listar(){
        return "rest está funcionando";
    }
}
