package com.ufes;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        CalculadoraDeDescontoService calculadoraDescontoTaxaEntregaService = new CalculadoraDeDescontoService();

        Cliente cliente = new Cliente("Fulano", "Ouro", 10.0, "Centro", "Guararema", "Alegre");
        Item item1 = new Item("Caderno", 1, 19.00, "Educação");
        Item item2 = new Item("Xburger", 1, 1.00, "Alimentação");

        LocalDate localDate = LocalDate.now();

        Pedido pedido = new Pedido(localDate, cliente);
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        //double valorPedido = pedido.getValorPedido();
        System.out.println(pedido.getDescontoConcedido());


        calculadoraDescontoTaxaEntregaService.calcularDesconto(pedido);
        System.out.println(pedido.getDescontoConcedido());


        /*for(CupomDescontoEntrega cupom: cuponsDescontoEntrega) {
            pedido.addCupomDescontoTaxaEntrega(cupom);
        }
        */
    }
}