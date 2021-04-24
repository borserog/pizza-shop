package br.edu.ifpb.padroes.domain;

public class PizzaWithExtraCheese extends PizzaDecorator {

    public PizzaWithExtraCheese(Pizza wrappedPizza) {
        super(wrappedPizza);
    }

    @Override
    public Float getPrice() {
        return super.getPrice() * 1.10f;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
