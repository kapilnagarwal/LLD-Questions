import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    private int numberOfFloors;
    private List<ElevatorCar> elevatorCars;

    public ElevatorController(int numberOfElevators, int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
        elevatorCars = new ArrayList<>();
        for (int i = 0; i < numberOfElevators; i++) {
            ElevatorCar car = new ElevatorCar();
            car.setElevatorName("Elevator" + (i + 1));
            elevatorCars.add(car);
        }
    }

    public void sendRequest(Request request) {
        if (request.getFromFloor() < 0 || request.getFromFloor() >= numberOfFloors ||
                request.getDestinationFloor() < 0 || request.getDestinationFloor() >= numberOfFloors) {
            throw new IllegalArgumentException("Invalid Floor");
        }

        // Find best elevator for serving request
        ElevatorCar bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorCar elevatorCar : elevatorCars) {
            int distance = Math.abs(elevatorCar.getCurrentFloor() - request.getFromFloor());

            if (elevatorCar.getDirection() == Direction.IDLE ||
                    (elevatorCar.getDirection() == Direction.UP && request.getDirection() == Direction.UP && request.getFromFloor() >= elevatorCar.getCurrentFloor()) ||
                    (elevatorCar.getDirection() == Direction.DOWN && request.getDirection() == Direction.DOWN && request.getFromFloor() <= elevatorCar.getCurrentFloor())) {
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevatorCar;
                }
            }
        }

        if (bestElevator != null) {
            bestElevator.addRequest(request.getDestinationFloor(), request.getDirection());
        }
    }

    public List<ElevatorCar> getElevatorCars() {
        return elevatorCars;
    }

    public void moveElevators() {
        for (ElevatorCar elevatorCar : elevatorCars) {
            elevatorCar.move();
        }
    }
}
