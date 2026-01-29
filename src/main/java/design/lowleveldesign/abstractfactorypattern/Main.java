package design.lowleveldesign.abstractfactorypattern;

public class Main {

    public static void main(String[] args) {
        VehicleTypeFactory vehicleTypeFactory = new VehicleTypeFactory();
        VehicleFactory vehicleFactory = vehicleTypeFactory.createVehicleFactory("LUXURY");
        Vehicle vehicle = vehicleFactory.createVehicle("AUDI");
        System.out.println(vehicle.averageSpeed());

        Vehicle vehicle_1 = vehicleFactory.createVehicle("BMW");
        System.out.println(vehicle_1.averageSpeed());


        VehicleFactory vehicleFactory1 = vehicleTypeFactory.createVehicleFactory("ORDINARY");
        Vehicle vehicle1 = vehicleFactory1.createVehicle("MARUTI");
        System.out.println(vehicle1.averageSpeed());

        Vehicle vehicle2 = vehicleFactory1.createVehicle("HYUNDAI");
        System.out.println(vehicle2.averageSpeed());
    }
}
