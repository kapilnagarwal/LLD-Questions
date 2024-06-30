import java.util.HashMap;
import java.util.Map;

public class Board {
    private int size;
    private Map<Integer, Integer> ladders;
    private Map<Integer, Integer> snakes;

    public Board(int size) {
        this.size = size;
        this.ladders = new HashMap<>();
        this.snakes = new HashMap<>();
    }

    public void addLadder(int start, int end) {
        ladders.put(start, end);
    }

    public void addSnake(int start, int end) {
        snakes.put(start, end);
    }

    public int getSize() {
        return size;
    }

    public int getNewPosition(int position) {
        if (ladders.containsKey(position)) {
            return ladders.get(position);
        }
        if (snakes.containsKey(position)) {
            return snakes.get(position);
        }
        return position;
    }
}
