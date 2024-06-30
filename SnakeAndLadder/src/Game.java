import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private Dice dice;
    private boolean isGameOver;

    public Game(int boardSize, int diceSides, int numberOfDice) {
        board = new Board(boardSize);
        players = new ArrayList<>();
        dice = new Dice(diceSides, numberOfDice);
        isGameOver = false;
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void addLadder(int start, int end) {
        board.addLadder(start, end);
    }

    public void addSnake(int start, int end) {
        board.addSnake(start, end);
    }

    public void play() {
        while (!isGameOver) {
            for (Player player : players) {
                int diceValue = dice.roll();
                int newPosition = player.getPosition() + diceValue;

                // Check if newPosition exceeds the board size
                if (newPosition > board.getSize()) {
                    System.out.println(player.getName() + " rolled a " + diceValue + " but can't move beyond " + board.getSize());
                    newPosition = player.getPosition(); // Stay in the same position
                } else {
                    newPosition = board.getNewPosition(newPosition);
                    player.setPosition(newPosition);
                    System.out.println(player.getName() + " rolled a " + diceValue + " and moved to " + newPosition);
                }

                if (newPosition == board.getSize()) {
                    System.out.println(player.getName() + " wins!");
                    isGameOver = true;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game(100, 6, 2); // Example: 100 squares, 6-sided dice, 2 dice
        game.addPlayer("Alice");
        game.addPlayer("Bob");
        game.addLadder(2, 22);
        game.addLadder(4, 14);
        game.addSnake(17, 7);
        game.addSnake(20, 5);
        game.play();
    }
}
