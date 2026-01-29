package design.lowleveldesign.decoratorpattern.decorator;

import design.lowleveldesign.decoratorpattern.BasePizza;

public class ExtraCheesePizza extends ToppingDecorator {

    BasePizza pizza;

    public ExtraCheesePizza(BasePizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public int cost() {
        return this.pizza.cost()+ 70;
    }
}
