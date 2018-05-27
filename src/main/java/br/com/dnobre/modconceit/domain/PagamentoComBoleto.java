/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dnobre.modconceit.domain;

import br.com.dnobre.modconceit.domain.enums.EstadoPagamento;
import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author souno
 */
@Entity
public class PagamentoComBoleto extends Pagamento {
     private static final long serialVersionUID = 1L;
    
    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, 
            Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        
        this.dataVencimento = dataVencimento;
        this.dataPagamento  = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    
}
