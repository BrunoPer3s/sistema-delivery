package com.ufes;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDeDescontoService {
    private List<IMetodoDescontoTaxaEntrega> metodosDeDesconto;

    public CalculadoraDeDescontoService() {
        MetodoDescontoTipoItem metodoDescontoTipoItem = new MetodoDescontoTipoItem();
        MetodoDescontoValorPedido metodoDescontoValorPedido = new MetodoDescontoValorPedido(200);
        MetodoDescontoTaxaPorBairro metodoDescontoTaxaPorBairro = new MetodoDescontoTaxaPorBairro();
        MetodoDescontoTaxaPorTipoCliente metodoDescontoTaxaPorTipoCliente = new MetodoDescontoTaxaPorTipoCliente();
        MetodoDescontoPorDiaSemana metodoDescontoPorDiaSemana = new MetodoDescontoPorDiaSemana();
        MetodoDescontoIntervaloDatas metodoDescontoIntervaloDatas = new MetodoDescontoIntervaloDatas();

        metodosDeDesconto = new ArrayList<>();
        metodosDeDesconto.add(metodoDescontoTipoItem);
        metodosDeDesconto.add(metodoDescontoValorPedido);
        metodosDeDesconto.add(metodoDescontoTaxaPorBairro);
        metodosDeDesconto.add(metodoDescontoTaxaPorTipoCliente);
        metodosDeDesconto.add(metodoDescontoPorDiaSemana);
        metodosDeDesconto.add(metodoDescontoIntervaloDatas);
    }

    public void calcularDesconto(Pedido pedido) {
        for(IMetodoDescontoTaxaEntrega metodos: metodosDeDesconto) {
            if(metodos.seAplica(pedido)) {
                metodos.calcularDesconto(pedido);
            }
        }
    }
}
