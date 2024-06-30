public class Main {
    public static void main(String[] args) {
        int numberOfFloors = 10;
        int numberOfElevators = 3;
        ElevatorController controller = new ElevatorController(numberOfElevators, numberOfFloors);

        // Simulate the button panels on different floors
        Floor panel1 = new Floor(1, controller);
        Floor panel2 = new Floor(2, controller);
        Floor panel3 = new Floor(3, controller);
        Floor panel8 = new Floor(8, controller);

        // Simulate requests from floor
        panel1.pressButton(8, Direction.UP);
        panel2.pressButton(1, Direction.DOWN);
        panel3.pressButton(1, Direction.UP);
        panel8.pressButton(2, Direction.DOWN);

        // Simulate internal requests from inside of elevator
        ElevatorCar elevatorCar = controller.getElevatorCars().get(0);
        elevatorCar.pressButton(3);
        elevatorCar.pressButton(6);

        for (int i = 0; i < 10; i++) {
            controller.moveElevators();
            System.out.println("Elevator positions: ");
            for (ElevatorCar e : controller.getElevatorCars()) {
                System.out.println("Elevator:" + e.getElevatorName() + " floor:" + e.getCurrentFloor() + " with direction : " + e.getDirection());
            }
            try {
                Thread.sleep(1000); // for time passing simulation
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
