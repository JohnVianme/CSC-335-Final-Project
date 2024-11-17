
/*
 * enums for the Dice objects
 *
 * authors:
 * @ Garret W
 * @ JOhn I
 * @ Dylan C
 * @ Jason B
 */

public enum DiceEnum {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int value;

    // constructor at runtime
    DiceEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
