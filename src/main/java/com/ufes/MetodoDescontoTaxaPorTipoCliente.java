package com.ufes;

import java.util.HashMap;
import java.util.Map;

public class MetodoDescontoTaxaPorTipoCliente implements IMetodoDescontoTaxaEntrega{
    private Map<String,Double> descontoPorTipoCliente;

    public MetodoDescontoTaxaPorTipoCliente() {
        descontoPorTipoCliente = new HashMap<>();
        descontoPorTipoCliente.put("Ouro",3.0);
        descontoPorTipoCliente.put("Prata",2.0);
        descontoPorTipoCliente.put("Bronze",1.0);
        //descontoPorTipoCliente.put("Nenhum", 0.0);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        String tipoCliente = pedido.getCliente().getTipo();

        if(!this.descontoPorTipoCliente.containsKey(tipoCliente)) {
            pedido.addCupomDescontoTaxaEntrega(new CupomDescontoEntrega("MetodoDescontoTaxaPorTipoCLiente", 0.0));
        }

        double desconto = descontoPorTipoCliente.get(tipoCliente);

        if(desconto != 0.0) {
            pedido.addCupomDescontoTaxaEntrega(new CupomDescontoEntrega("MetodoDescontoTaxaPorTipoCLiente",desconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return this.descontoPorTipoCliente.containsKey(pedido.getCliente().getTipo());
    }
}
