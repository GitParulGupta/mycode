package design.lowleveldesign.abstractfactorypattern;

public class VehicleTypeFactory {
    public VehicleFactory createVehicleFactory(String vehicleType) {
        switch (vehicleType) {
            case "LUXURY":
                return new LuxuryFactory();
            case "ORDINARY":
                return new OrdinaryFactory();
                default:
                    throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }
}
