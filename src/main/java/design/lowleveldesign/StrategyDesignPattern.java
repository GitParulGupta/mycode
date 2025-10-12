package design.lowleveldesign;

/**
 *
 */
public class StrategyDesignPattern{
    public static void main(String[] args) {
        Vehicle1 obj1 = new SportsVehicle1();
        obj1.drive();

        Vehicle1 obj2 = new PasengerVehicle1();
        obj2.drive();
    }
}

interface DriveStrategy{
    void drive();
}

class SportsDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Sports drive strategy");
    }
}

class NormalDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Normal drive strategy");
    }
}

class Vehicle1{

    DriveStrategy obj;

    public Vehicle1(DriveStrategy obj){
        this.obj  = obj;
    }

    public void drive(){
        obj.drive();
    }
}

class SportsVehicle1 extends Vehicle1{
    SportsVehicle1(){
        super(new SportsDriveStrategy());
    };
}

class PasengerVehicle1 extends Vehicle1{
    PasengerVehicle1(){
        super(new NormalDriveStrategy());
    };
}


class OffRoadVehicle1 extends Vehicle1{
    OffRoadVehicle1(){
        super(new SportsDriveStrategy());
    };
}