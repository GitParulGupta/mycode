package design.lowleveldesign.abstractfactorypattern;

public class LuxuryFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String vehicle) {
        switch (vehicle) {
            case "AUDI":
                return new Audi();
            case "BMW":
                return new Bmw();
            default:
                return null;
        }
    }
}
