package br.edu.ifpb.padroes.domain;

public class PizzaWithDiscount extends PizzaDecorator {

    public PizzaWithDiscount(Pizza wrappedPizza) {
        super(wrappedPizza);
    }

    @Override
    public Float getPrice() {
        return super.getPrice() * 0.25f;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
