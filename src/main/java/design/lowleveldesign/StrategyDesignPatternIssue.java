package design.lowleveldesign;

/**
 * Sportsvehicle and OffRoadVehicle --> both override drive method of base class but have same code.
 * This leads to code duplicacy.
 * This can be fixed by strategy Design Pattern
 */
public class StrategyDesignPatternIssue {

}

class Vehicle{
    void drive(){
        //normal
    }
}

class SportsVehicle extends Vehicle{
    @Override
    void drive(){
        //special functionality 1
    }
}

class PasengerVehicle extends Vehicle{
    //uses drive method of base class
}


class OffRoadVehicle extends Vehicle{
    @Override
    void drive(){
        //special functionality 1
    }
}