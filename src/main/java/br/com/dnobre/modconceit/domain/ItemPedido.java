/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnobre.modconceit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author souno
 */
@Entity
public class ItemPedido  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @JsonIgnore
    @EmbeddedId
    ItempedidoPK id = new ItempedidoPK();
    
    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        super();
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ItempedidoPK getId() {
        return id;
    }

    public void setId(ItempedidoPK id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }
    
    public Produto getProduto(){
        return id.getProduto();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemPedido other = (ItemPedido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
