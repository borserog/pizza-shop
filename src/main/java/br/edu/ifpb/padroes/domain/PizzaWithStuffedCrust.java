package br.edu.ifpb.padroes.domain;

public class PizzaWithStuffedCrust extends PizzaDecorator {

    public PizzaWithStuffedCrust(Pizza wrappedPizza) {
        super(wrappedPizza);
    }

    @Override
    public Float getPrice() {
        return super.getPrice() * 1.20f;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
