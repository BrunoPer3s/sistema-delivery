package com.ufes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetodoDescontoTaxaPorBairro implements IMetodoDescontoTaxaEntrega{
    private Map<String,Double> descontoPorTipoDeBairro;

    public MetodoDescontoTaxaPorBairro() {
        descontoPorTipoDeBairro = new HashMap<>();
        descontoPorTipoDeBairro.put("Centro",2.0);
        descontoPorTipoDeBairro.put("Bela Vista",3.0);
        descontoPorTipoDeBairro.put("Cidade Maravilhosa",1.50);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        double valorDesconto = descontoPorTipoDeBairro.get(pedido.getCliente().getBairro());
        pedido.addCupomDescontoTaxaEntrega(new CupomDescontoEntrega("MetodoDescontoTaxaPorBairro", valorDesconto));
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return this.descontoPorTipoDeBairro.containsKey(pedido.getCliente().getBairro());
    }
}
