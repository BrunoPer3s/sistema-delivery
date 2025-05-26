package com.ufes;

import java.util.Map;

public class MetodoDescontoValorPedido implements IMetodoDescontoTaxaEntrega {
    private double limiteValorPedido;
    private double VALOR_DESCONTO = 5.0;

    public MetodoDescontoValorPedido(double limiteValorPedido) {
        this.limiteValorPedido = limiteValorPedido;
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        pedido.addCupomDescontoTaxaEntrega(new CupomDescontoEntrega("MetodoDescontoValorPedido", this.VALOR_DESCONTO));
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return pedido.getValorPedido() > limiteValorPedido && pedido.getDescontoConcedido() <= 10.0;
    }
}
