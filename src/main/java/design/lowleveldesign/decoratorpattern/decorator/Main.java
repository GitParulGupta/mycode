package design.lowleveldesign.decoratorpattern.decorator;

import design.lowleveldesign.decoratorpattern.BasePizza;
import design.lowleveldesign.decoratorpattern.FarmhousePizza;
import design.lowleveldesign.decoratorpattern.VeggieDelightPizza;

public class Main {

    public static void main(String[] args) {

        BasePizza pizza = new ExtraCheesePizza(new VeggieDelightPizza());//decorator usage
        System.out.println("Pizza is " + pizza.getClass().getSimpleName()+" Cost is " + pizza.cost());

        BasePizza pizza1 = new ExtraCheesePizza(new FarmhousePizza());//decorator usage
        System.out.println("Pizza is " + pizza1.getClass().getSimpleName()+" Cost is " + pizza1.cost());

        BasePizza pizza2 = new MushroomPizza(new FarmhousePizza());//decorator usage
        System.out.println("Pizza is " + pizza2.getClass().getSimpleName()+" Cost is " + pizza2.cost());

        BasePizza pizza3 = new ExtraCheesePizza(new MushroomPizza(new FarmhousePizza()));//decorator usage
        System.out.println("Pizza is " + pizza3.getClass().getSimpleName()+" Cost is " + pizza3.cost());

    }
}
