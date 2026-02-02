package design.lowleveldesign.handlenullpointer;

public class Main {

    public static void main(String[] args) {

        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle vehicle = vehicleFactory.getVehicle("Car");
        System.out.println(vehicle.getFuelCapacity());
        System.out.println(vehicle.getSeatingCapacity());

        Vehicle vehicle2 = vehicleFactory.getVehicle("Bus");
        System.out.println(vehicle2.getFuelCapacity());
        System.out.println(vehicle2.getSeatingCapacity());
    }
}
