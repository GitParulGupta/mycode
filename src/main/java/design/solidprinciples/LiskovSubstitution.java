package design.solidprinciples;

import java.util.ArrayList;
import java.util.List;

//To fix the issue, we keep only very generic methods in base class
public class LiskovSubstitution{

    public static void main(String[] args) {
        List<Vehicle1> vehicleList = new ArrayList<>();
        vehicleList.add(new Bicycle1());
        vehicleList.add(new Car1());
        vehicleList.add(new MotorCycle1());

        for(Vehicle1 v:vehicleList){
            //System.out.println(v.hasEngine().toString());//will throw compilation as hasEngine not accessible to Bicycle class
            System.out.println(v.numOfWheels().toString());
        }
    }
}

class Vehicle1{
    public Integer numOfWheels(){
        return 2;
    }
}

class EngineVehicle extends Vehicle1{
    public Boolean hasEngine(){
        return true;
    }
}

class NonEngineVehicle extends Vehicle1{
}

class Car1 extends EngineVehicle{
    @Override
    public Integer numOfWheels(){
        return 4;
    }
}

class MotorCycle1 extends EngineVehicle{
}

class Bicycle1 extends NonEngineVehicle{
}