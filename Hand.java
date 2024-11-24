import java.util.ArrayList;

public final class Hand {
    //
    // instance variables
    //
    ArrayList<DiceEnum> aHand = new ArrayList<DiceEnum>();

    //
    // constructor
    //
    public Hand() {
        getHand();
    }

    /*
     * This method will call the dice class to get five dices that will represent a
     * player hand.
     *
     */
    public ArrayList<DiceEnum> getHand() {
        for (int i = 0; i < 5; i++) {
            // create five dices and add them to hand
            aHand.add(Dice.getDice());
        }
        return aHand;
    }

    // TODO
    public ArrayList<DiceEnum> setHand(int index, DiceEnum dice) {
        return aHand;
    }
}
