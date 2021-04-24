package br.edu.ifpb.padroes;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.domain.*;
import br.edu.ifpb.padroes.service.PizzaShopService;

public class Main {

    public static void main(String[] args) {

        PizzaShopService pizzaShopService = new PizzaShopService();

        System.out.println("Pizzas - menu");

        // TODO - implementar adapter para juntar as pizzas da PizzaHot e Damenos em um único conjunto
        for (PizzaHotPizza pizza : pizzaShopService.getPizzasPizzaHot()) {
            System.out.println(String.format("%s - %.2f", pizza.getTopping(), pizza.getPrice()));
        }
        for (DamenosPizza pizza : pizzaShopService.getPizzasDamenos()) {
            System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getCost()));
        }

        Pizza pizza = new PizzaShopPizza("pepperoni", 55.0f);
        Pizza pizzaWithDiscountCoupon = new PizzaWithDiscount(pizza);
        Pizza pizzaWithExtraCheese = new PizzaWithExtraCheese(pizzaWithDiscountCoupon);
        Pizza pizzaWithStuffedCrust = new PizzaWithStuffedCrust(pizzaWithExtraCheese);

        pizzaShopService.orderPizza(pizzaWithStuffedCrust);
    }
}
