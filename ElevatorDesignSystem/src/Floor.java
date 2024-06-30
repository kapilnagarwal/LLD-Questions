import javax.print.attribute.standard.Destination;

public class Floor implements ButtonPanel{
    private int floorNumber;
    private ElevatorController elevatorController;

    public Floor(int floorNumber, ElevatorController elevatorController){
        this.floorNumber = floorNumber;
        this.elevatorController = elevatorController;
    }

    @Override
    public void pressButton(int destinationFloor){
        throw new UnsupportedOperationException("Use pressbutton with direction for floors");
    }

    @Override
    public void pressButton(int destinationFloor, Direction direction) {
        elevatorController.sendRequest(new Request(floorNumber, destinationFloor, direction));
    }

}
