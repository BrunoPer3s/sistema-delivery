package com.ufes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MetodoDescontoIntervaloDatas implements IMetodoDescontoTaxaEntrega {

    private List<LocalDate> datasInicio = new ArrayList<>();
    private List<LocalDate> datasFim = new ArrayList<>();
    private List<Double> descontos = new ArrayList<>();

    public MetodoDescontoIntervaloDatas() {
        adicionarIntervalo(LocalDate.of(2025, 5, 22), LocalDate.of(2025, 5, 27), 100.0);
        adicionarIntervalo(LocalDate.of(2025, 6, 16), LocalDate.of(2025, 6, 16), 60.0);
        adicionarIntervalo(LocalDate.of(2025, 5, 25), LocalDate.of(2025, 5, 25), 50.0);
    }

    private void adicionarIntervalo(LocalDate inicio, LocalDate fim, double desconto) {
        datasInicio.add(inicio);
        datasFim.add(fim);
        descontos.add(desconto);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        LocalDate dataEntrega = pedido.getDataEntrega();
        double maiorDesconto = 0.0;

        for (int i = 0; i < datasInicio.size(); i++) {
            if (!dataEntrega.isBefore(datasInicio.get(i)) && !dataEntrega.isAfter(datasFim.get(i))) {
                maiorDesconto = Math.max(maiorDesconto, descontos.get(i));
            }
        }

        if (maiorDesconto > 0.0) {
            double valorDesconto = (maiorDesconto / 100.0) * pedido.getTaxaEntrega();
            pedido.addCupomDescontoTaxaEntrega(
                new CupomDescontoEntrega("MetodoDescontoPorIntervaloData", valorDesconto)
            );
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        LocalDate dataEntrega = pedido.getDataEntrega();
        for (int i = 0; i < datasInicio.size(); i++) {
            if (!dataEntrega.isBefore(datasInicio.get(i)) && !dataEntrega.isAfter(datasFim.get(i))) {
                return true;
            }
        }
        return false;
    }
}
