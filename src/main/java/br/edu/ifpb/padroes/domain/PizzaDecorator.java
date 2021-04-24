package br.edu.ifpb.padroes.domain;

public class PizzaDecorator implements Pizza {
    Pizza wrappedPizza;

    public PizzaDecorator(Pizza wrappedPizza) {
        this.wrappedPizza = wrappedPizza;
    }

    @Override
    public Float getPrice() {
        return wrappedPizza.getPrice();
    }

    @Override
    public String getName() {
        return wrappedPizza.getName();
    }
}
