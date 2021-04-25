package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.DamenosServiceImpl;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosService;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotServiceImpl;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotService;
import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.adapter.DamenosAdapter;
import br.edu.ifpb.padroes.domain.adapter.PizzahotAdapter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PizzaShopService {

    private DamenosService damenosService;
    private PizzaHotService pizzaHotService;

    public PizzaShopService() {
        // TODO - alterar criação de instância para chamar para o Proxy de Cache
        damenosService = new DamenosServiceImpl();
        pizzaHotService = new PizzaHotServiceImpl();
    }

    public void orderPizza(Pizza pizza) {
        Float totalPrice = pizza.getPrice();
        String name = pizza.getName();

        System.out.println(String.format("New order for = %s", name));
        System.out.println(String.format("Total price = %f", totalPrice));

    }

    // TODO - implementar adapter para unificar pizzas vindas das APIs Damenos e PizzaHot num único método getPizzas()
    // TODO - public List<Pizza> getPizzas() {}
    public List<Pizza> getPizzas() {
        Stream<PizzahotAdapter> pizzasFromPizzaHot = getPizzasPizzaHot().stream().map(PizzahotAdapter::new);
        Stream<DamenosAdapter> pizzasFromDamenosPizza = getPizzasDamenos().stream().map(DamenosAdapter::new);

        return Stream.concat(pizzasFromPizzaHot, pizzasFromDamenosPizza).collect(Collectors.toList());
    }


    private List<DamenosPizza> getPizzasDamenos() {
        return damenosService.getPizzas();
    }

    private List<PizzaHotPizza> getPizzasPizzaHot() {
        return pizzaHotService.getPizzas();
    }

}
