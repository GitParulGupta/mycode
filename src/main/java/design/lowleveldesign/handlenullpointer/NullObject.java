package design.lowleveldesign.handlenullpointer;

public class NullObject implements Vehicle {
    @Override
    public int getFuelCapacity() {
        return 0;
    }

    @Override
    public int getSeatingCapacity() {
        return 0;
    }
}
