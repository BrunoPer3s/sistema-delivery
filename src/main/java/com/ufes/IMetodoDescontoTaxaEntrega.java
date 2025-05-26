package com.ufes;

public interface IMetodoDescontoTaxaEntrega {
     void calcularDesconto(Pedido pedido);
     boolean seAplica(Pedido pedido);
}
