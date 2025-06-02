package com.ufes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Item> itens;
    private Cliente cliente;
    private List<CupomDescontoEntrega> cuponsDescontoEntrega;
    private double taxaEntrega;
    private LocalDate dataEntrega;

    public Pedido(LocalDate data, Cliente cliente) {
        this.cliente = cliente;
        this.dataEntrega = data;
        this.itens = new ArrayList<>();
        this.taxaEntrega = 10.00;
        this.cuponsDescontoEntrega = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double getValorPedido() {
        double valorTotalPedido = 0.0;
        for (Item item : itens) {
            valorTotalPedido += item.getValorTotal();
        }
        return valorTotalPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public LocalDate getDataEntrega() {
        return this.dataEntrega;
    }

    public void addCupomDescontoTaxaEntrega(CupomDescontoEntrega desconto) {
        cuponsDescontoEntrega.add(desconto);
    }

    public double getDescontoConcedido() {
        double descontoAcumulado = 0.0;

        for(CupomDescontoEntrega cupom : cuponsDescontoEntrega){
            descontoAcumulado += cupom.getValorDesconto();

             if(descontoAcumulado > 10.00 ) {
                descontoAcumulado = 10.00;
                 break;
             }
        }

        return descontoAcumulado;
    }

    public List<CupomDescontoEntrega> getCuponsDescontoEntrega() {
         return cuponsDescontoEntrega;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "itens=" + itens +
                ", cliente=" + cliente +
                ", taxaEntrega=" + taxaEntrega +
                ", dataEntrega=" + dataEntrega +
                '}';
    }
}
