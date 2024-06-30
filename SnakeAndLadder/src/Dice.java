public class Dice {
    private int sides;
    private int numberOfDice;

    public Dice(int sides, int numberOfDice) {
        this.sides = sides;
        this.numberOfDice = numberOfDice;
    }

    public int roll() {
        int total = 0;
        for (int i = 0; i < numberOfDice; i++) {
            total += (int) (Math.random() * sides) + 1;
        }
        return total;
    }
}
