package com.ufes;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MetodoDescontoPorDiaSemana  implements IMetodoDescontoTaxaEntrega{
    private Map<String, Double> descontosDiaSemana;

    public MetodoDescontoPorDiaSemana() {
        descontosDiaSemana = new HashMap<>();
        descontosDiaSemana.put("segunda-feira", 0.0);
        descontosDiaSemana.put("terça-feira", 100.0);
        descontosDiaSemana.put("quarta-feira", 0.0);
        descontosDiaSemana.put("quinta-feira", 0.0);
        descontosDiaSemana.put("sexta-feira", 60.0);
        descontosDiaSemana.put("sábado", 0.0);
        descontosDiaSemana.put("domingo", 0.0);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        DayOfWeek diaDaSemana = pedido.getDataEntrega().getDayOfWeek();
        String diaDaSemanaNome = diaDaSemana.getDisplayName(TextStyle.FULL, Locale.of("pt", "BR"));

        
        pedido.addCupomDescontoTaxaEntrega(new CupomDescontoEntrega("MetodoDescontoPorDiaSemana", this.descontosDiaSemana.get(diaDaSemanaNome) * (pedido.getTaxaEntrega())/100));
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        DayOfWeek diaDaSemana = pedido.getDataEntrega().getDayOfWeek();
        String diaDaSemanaNome = diaDaSemana.getDisplayName(TextStyle.FULL, Locale.of("pt", "BR"));
        System.out.println(diaDaSemanaNome);
        return this.descontosDiaSemana.containsKey(this.descontosDiaSemana.get(diaDaSemanaNome));
    }
}
