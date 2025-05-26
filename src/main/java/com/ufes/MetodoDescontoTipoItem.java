package com.ufes;

import java.util.HashMap;
import java.util.Map;

public class MetodoDescontoTipoItem implements IMetodoDescontoTaxaEntrega {
    private Map<String,Double> descontosPorTipoItem;

    public MetodoDescontoTipoItem() {
        descontosPorTipoItem = new HashMap<String,Double>();
        descontosPorTipoItem.put("Alimentação", 5.0);
        descontosPorTipoItem.put("Educação", 2.0);
        descontosPorTipoItem.put("Lazer", 1.50);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        for(Item item : pedido.getItens()) {
            if (descontosPorTipoItem.containsKey(item.getTipo())) {
                pedido.addCupomDescontoTaxaEntrega(
                        new CupomDescontoEntrega("MetodoDescontoTipoItem",
                        descontosPorTipoItem.get(item.getTipo())));

            }
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        for(Item item: pedido.getItens()) {
            if(this.descontosPorTipoItem.containsKey(item.getTipo())) {
                return true;
            }
        }
        return false;
    }
}
