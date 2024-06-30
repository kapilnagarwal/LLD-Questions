public class Request {
    private int fromFloor;
    private int destinationFloor;
    private Direction direction;
    public Request(int fromFloor, int destinationFloor, Direction direction){
        this.fromFloor = fromFloor;
        this.destinationFloor = destinationFloor;
        this.direction = direction;
    }

    public int getFromFloor() {
        return fromFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}
