package design.solidprinciples;

import java.util.ArrayList;
import java.util.List;

//states that any subclass of the base class should be able to extend (upscale or downscale) the functionality w/o breaking the code
public class LiskovSubstitutionIssue {

    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car());
        vehicleList.add(new Bicycle());
        vehicleList.add(new MotorCycle());

        for(Vehicle v:vehicleList){
            System.out.println(v.hasEngine().toString());//this will break in case of bicycle as bicycle returns null. NPE will be thrown
            System.out.println(v.numOfWheels().toString());
        }
    }
}

class Vehicle{
    public Integer numOfWheels(){
        return 2;
    }

    public Boolean hasEngine(){
        return true;
    }
}

class Car extends Vehicle{
    @Override
    public Integer numOfWheels(){
        return 4;
    }
}

class MotorCycle extends Vehicle{
}

class Bicycle extends Vehicle{
    @Override
    public Boolean hasEngine(){
        return null;
    }
}