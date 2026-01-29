package design.lowleveldesign.decoratorpattern.decorator;

import design.lowleveldesign.decoratorpattern.BasePizza;

public class MushroomPizza extends ToppingDecorator {

    BasePizza pizza;

    public MushroomPizza(BasePizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public int cost() {
        return this.pizza.cost()+ 50;
    }
}
