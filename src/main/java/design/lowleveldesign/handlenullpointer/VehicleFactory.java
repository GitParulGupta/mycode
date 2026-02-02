package design.lowleveldesign.handlenullpointer;

public class VehicleFactory {

    public Vehicle getVehicle(String type){

        if("Car".equals(type)){
            return new Car();
        }

        return new NullObject();
    }

}
