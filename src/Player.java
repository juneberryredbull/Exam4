public class Player {
    private String name;
    private Die die;

    public Player(String name, Die die) {
        this.name = name;
        this.die = die;
    }

    // overriden toString method.
    // im not sure whether the toString method shouldve been in die class or player class
    // but i think it makes more sense to be in player class
    public String toString() {
        return "Player " + this.name + " rolled a " + this.die.getValue() + " on a " +
                this.die.getNumSides() + " sided die.";
    }

    // getters and setters
    public String getName() {
        return this.name;
    }

    public Die getDie() {
        return this.die;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setDie(Die v) {
        this.die = v;
    }
}
