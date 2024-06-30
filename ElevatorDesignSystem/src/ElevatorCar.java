import java.util.PriorityQueue;

public class ElevatorCar implements ButtonPanel{

    private int currentFloor;
    private Direction direction;
    private PriorityQueue<Integer> upRequests;
    private PriorityQueue<Integer> downRequests;
    private String elevatorName;

    public ElevatorCar() {
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.upRequests = new PriorityQueue<>();
        this.downRequests = new PriorityQueue<>((a, b) -> b - a);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getElevatorName(){
        return elevatorName;
    }

    public void setElevatorName(String elevatorName) {
        this.elevatorName = elevatorName;
    }

    public void addRequest(int requestFloor, Direction direction){
        if (direction == Direction.UP){
            upRequests.add(requestFloor);
        }
        else if (direction == Direction.DOWN){
            downRequests.add(requestFloor);
        }

        if (this.direction == Direction.IDLE){
            this.direction = direction;
        }
    }

    @Override
    public void pressButton(int destinationFloor){
        if (currentFloor < destinationFloor){
            addRequest(destinationFloor, Direction.UP);
        } else if (currentFloor > destinationFloor) {
            addRequest(destinationFloor, Direction.DOWN);
        }
    }

    @Override
    public void pressButton(int destinationFloor, Direction direction){
        addRequest(destinationFloor, direction);
    }

    public void move(){
        if (direction == Direction.UP){
            moveUp();
        } else if (direction == Direction.DOWN){
            moveDown();
        }
    }

    private void moveUp() {
       if (!upRequests.isEmpty()){
          currentFloor = upRequests.poll();
          if (upRequests.isEmpty()){
              direction = downRequests.isEmpty() ? Direction.IDLE : Direction.DOWN;
          }
        }
    }

    private void moveDown() {
        if (!downRequests.isEmpty()){
            currentFloor = downRequests.poll();
            if (downRequests.isEmpty()){
                direction = upRequests.isEmpty() ? Direction.IDLE : Direction.UP;
            }
        }
    }
}
