/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnobre.modconceit.repositories;

import br.com.dnobre.modconceit.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souno
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
