import java.util.concurrent.ThreadLocalRandom;

public class Die {
    private int numSides;
    private int value;

    // default constructor
    public Die() {
        this.numSides = 6;
        this.value = 1;
    }

    // constructor that assigns number of sides to die object
    public Die(int numSides) {
        this.numSides = numSides;
        this.value = 1;
    }

    // method that rolls the dice
    public void roll() {
        this.value = ThreadLocalRandom.current().nextInt(1, numSides + 1);
    }

    // getters and setters
    public int getNumSides() {
        return this.numSides;
    }

    public int getValue() {
        return this.value;
    }

    public void setNumSides(int s) {
        this.numSides = s;
    }

    public void setValue(int v) {
        this.value = v;
    }
}
