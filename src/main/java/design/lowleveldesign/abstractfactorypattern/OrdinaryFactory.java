package design.lowleveldesign.abstractfactorypattern;

public class OrdinaryFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String vehicle) {
        switch (vehicle) {
            case "MARUTI":
                return new Maruti();
            case "HYUNDAI":
                return new Hyundai();
            default:
                return null;
        }
    }
}
